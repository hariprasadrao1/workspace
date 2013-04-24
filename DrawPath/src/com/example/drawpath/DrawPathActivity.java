package com.example.drawpath;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class DrawPathActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new GraphicsView(this));
	}
static class GraphicsView extends View{
	private static final String QUOTE = "This is a test. This is a demo.";
	Path circle;
	Paint cPaint;
	Paint tPaint;
	public GraphicsView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		 int color = Color.argb(127, 255, 0, 255);
circle = new Path();
circle.addCircle(150, 150, 100, Direction.CW);
cPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
cPaint.setStyle(Paint.Style.STROKE);
cPaint.setColor(Color.BLUE);
cPaint.setStrokeWidth(3);
//setBackgroundResource(R.drawable.ic_launcher);

tPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
tPaint.setStyle(Paint.Style.FILL_AND_STROKE);
tPaint.setColor(Color.BLACK);
tPaint.setTextSize(20f);
	}

	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		canvas.drawTextOnPath(QUOTE, circle,0,20,tPaint);
	}
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_draw_path, menu);
		return true;
	}

}
