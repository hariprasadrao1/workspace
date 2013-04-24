package com.example.patheffectdemo;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Picture;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class PathEffectDemoActivity extends Activity {

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(new SampleView(this));
	  }

	  private static class SampleView extends View {
	    private ShapeDrawable[] mDrawables;

	    private static Shader makeSweep() {
	      return new SweepGradient(150, 25, new int[] { 0xFFFF0000,
	          0xFF00FF00, 0xFF0000FF, 0xFFFF0000 }, null);
	    }

	    private static Shader makeLinear() {
	      return new LinearGradient(0, 0, 50, 50, new int[] { 0xFFFF0000,
	          0xFF00FF00, 0xFF0000FF }, null, Shader.TileMode.MIRROR);
	    }

	    private static Shader makeTiling() {
	      int[] pixels = new int[] { 0xFFFF0000, 0xFF00FF00, 0xFF0000FF, 0 };
	      Bitmap bm = Bitmap.createBitmap(pixels, 2, 2,
	          Bitmap.Config.ARGB_8888);

	      return new BitmapShader(bm, Shader.TileMode.REPEAT,
	          Shader.TileMode.REPEAT);
	    }

	    private static class MyShapeDrawable extends ShapeDrawable {
	      private Paint mStrokePaint = new Paint(Paint.ANTI_ALIAS_FLAG);

	      public MyShapeDrawable(Shape s) {
	        super(s);
	        mStrokePaint.setStyle(Paint.Style.STROKE);
	      }

	      public Paint getStrokePaint() {
	        return mStrokePaint;
	      }

	      @Override
	      protected void onDraw(Shape s, Canvas c, Paint p) {
	        s.draw(c, p);
	        s.draw(c, mStrokePaint);
	      }
	    }

	    public SampleView(Context context) {
	      super(context);
	      setFocusable(true);

	      float[] outerR = new float[] { 12, 12, 12, 12, 0, 0, 0, 0 };
	      RectF inset = new RectF(6, 6, 6, 6);
	      float[] innerR = new float[] { 12, 12, 0, 0, 12, 12, 0, 0 };

	      Path path = new Path();
	      path.moveTo(50, 0);
	      path.lineTo(0, 50);
	      path.lineTo(50, 100);
	      path.lineTo(100, 50);
	      path.close();

	      mDrawables = new ShapeDrawable[7];
	      mDrawables[0] = new ShapeDrawable(new RectShape());
	      mDrawables[1] = new ShapeDrawable(new OvalShape());
	      mDrawables[2] = new ShapeDrawable(new RoundRectShape(outerR, null,
	          null));
	      mDrawables[3] = new ShapeDrawable(new RoundRectShape(outerR, inset,
	          null));
	      mDrawables[4] = new ShapeDrawable(new RoundRectShape(outerR, inset,
	          innerR));
	      mDrawables[5] = new ShapeDrawable(new PathShape(path, 100, 100));
	      mDrawables[6] = new MyShapeDrawable(new ArcShape(45, -270));

	      mDrawables[0].getPaint().setColor(0xFFFF0000);
	      mDrawables[1].getPaint().setColor(0xFF00FF00);
	      mDrawables[2].getPaint().setColor(0xFF0000FF);
	      mDrawables[3].getPaint().setShader(makeSweep());
	      mDrawables[4].getPaint().setShader(makeLinear());
	      mDrawables[5].getPaint().setShader(makeTiling());
	      mDrawables[6].getPaint().setColor(0x88FF8844);

	      PathEffect pe = new DiscretePathEffect(10, 4);
	      PathEffect pe2 = new CornerPathEffect(4);
	      mDrawables[3].getPaint().setPathEffect(
	          new ComposePathEffect(pe2, pe));

	      MyShapeDrawable msd = (MyShapeDrawable) mDrawables[6];
	      msd.getStrokePaint().setStrokeWidth(4);
	    }

	    @Override
	    protected void onDraw(Canvas canvas) {

	      int x = 10;
	      int y = 10;
	      int width = 300;
	      int height = 50;

	      for (Drawable dr : mDrawables) {
	        dr.setBounds(x, y, x + width, y + height);
	        dr.draw(canvas);
	        y += height + 5;
	      }
	    }
	  }
	}
/*
	class GraphicsActivity extends Activity {
	  // set to true to test Picture
	  private static final boolean TEST_PICTURE = false;

	  @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	  }

	  @Override
	  public void setContentView(View view) {
	    if (TEST_PICTURE) {
	      ViewGroup vg = new PictureLayout(this);
	      vg.addView(view);
	      view = vg;
	    }

	    super.setContentView(view);
	  }
	}

	class PictureLayout extends ViewGroup {
	  private final Picture mPicture = new Picture();

	  public PictureLayout(Context context) {
	    super(context);
	  }

	  public PictureLayout(Context context, AttributeSet attrs) {
	    super(context, attrs);
	  }

	  @Override
	  public void addView(View child) {
	    if (getChildCount() > 1) {
	      throw new IllegalStateException(
	          "PictureLayout can host only one direct child");
	    }

	    super.addView(child);
	  }

	  @Override
	  public void addView(View child, int index) {
	    if (getChildCount() > 1) {
	      throw new IllegalStateException(
	          "PictureLayout can host only one direct child");
	    }

	    super.addView(child, index);
	  }

	  @Override
	  public void addView(View child, LayoutParams params) {
	    if (getChildCount() > 1) {
	      throw new IllegalStateException(
	          "PictureLayout can host only one direct child");
	    }

	    super.addView(child, params);
	  }

	  @Override
	  public void addView(View child, int index, LayoutParams params) {
	    if (getChildCount() > 1) {
	      throw new IllegalStateException(
	          "PictureLayout can host only one direct child");
	    }

	    super.addView(child, index, params);
	  }

	  @Override
	  protected LayoutParams generateDefaultLayoutParams() {
	    return new LayoutParams(LayoutParams.MATCH_PARENT,
	        LayoutParams.MATCH_PARENT);
	  }

	  @Override
	  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	    final int count = getChildCount();

	    int maxHeight = 0;
	    int maxWidth = 0;

	    for (int i = 0; i < count; i++) {
	      final View child = getChildAt(i);
	      if (child.getVisibility() != GONE) {
	        measureChild(child, widthMeasureSpec, heightMeasureSpec);
	      }
	    }

	    maxWidth += getPaddingLeft() + getPaddingRight();
	    maxHeight += getPaddingTop() + getPaddingBottom();

	    Drawable drawable = getBackground();
	    if (drawable != null) {
	      maxHeight = Math.max(maxHeight, drawable.getMinimumHeight());
	      maxWidth = Math.max(maxWidth, drawable.getMinimumWidth());
	    }

	    setMeasuredDimension(resolveSize(maxWidth, widthMeasureSpec),
	        resolveSize(maxHeight, heightMeasureSpec));
	  }

	  private void drawPict(Canvas canvas, int x, int y, int w, int h, float sx,
	      float sy) {
	    canvas.save();
	    canvas.translate(x, y);
	    canvas.clipRect(0, 0, w, h);
	    canvas.scale(0.5f, 0.5f);
	    canvas.scale(sx, sy, w, h);
	    canvas.drawPicture(mPicture);
	    canvas.restore();
	  }

	  @Override
	  protected void dispatchDraw(Canvas canvas) {
	    super.dispatchDraw(mPicture.beginRecording(getWidth(), getHeight()));
	    mPicture.endRecording();

	    int x = getWidth() / 2;
	    int y = getHeight() / 2;

	    if (false) {
	      canvas.drawPicture(mPicture);
	    } else {
	      drawPict(canvas, 0, 0, x, y, 1, 1);
	      drawPict(canvas, x, 0, x, y, -1, 1);
	      drawPict(canvas, 0, y, x, y, 1, -1);
	      drawPict(canvas, x, y, x, y, -1, -1);
	    }
	  }

	  @Override
	  public ViewParent invalidateChildInParent(int[] location, Rect dirty) {
	    location[0] = getLeft();
	    location[1] = getTop();
	    dirty.set(0, 0, getWidth(), getHeight());
	    return getParent();
	  }

	  @Override
	  protected void onLayout(boolean changed, int l, int t, int r, int b) {
	    final int count = super.getChildCount();

	    for (int i = 0; i < count; i++) {
	      final View child = getChildAt(i);
	      if (child.getVisibility() != GONE) {
	        final int childLeft = getPaddingLeft();
	        final int childTop = getPaddingTop();
	        child.layout(childLeft, childTop,
	            childLeft + child.getMeasuredWidth(),
	            childTop + child.getMeasuredHeight());

	      }
	    }
	  }
	}
*/