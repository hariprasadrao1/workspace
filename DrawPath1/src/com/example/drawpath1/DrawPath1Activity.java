package com.example.drawpath1;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

public class DrawPath1Activity extends Activity {
	ImageView drawingImageView;
	  @Override
	  public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_draw_path1);
	    drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);
	    Bitmap bitmap = Bitmap.createBitmap((int) getWindowManager()
	        .getDefaultDisplay().getWidth(), (int) getWindowManager()
	        .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
	    Canvas canvas = new Canvas(bitmap);
	    drawingImageView.setImageBitmap(bitmap);

	    Paint paint = new Paint();
	    paint.setColor(Color.GREEN);
	    paint.setTextSize(20);
	    paint.setTypeface(Typeface.DEFAULT);
	    Path p = new Path();
	    p.moveTo(20, 20);
	    p.lineTo(100, 150);
	    p.lineTo(200, 220);
	    canvas.drawTextOnPath("this is a test", p, 0, 0, paint);
	    
	  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_draw_path1, menu);
		return true;
	}

}
