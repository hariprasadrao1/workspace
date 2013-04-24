package com.example.verysimpledoodle;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class VerySimpleDoodleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_very_simple_doodle);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_very_simple_doodle, menu);
		return true;
	}

	class MySurfaceView extends SurfaceView{
        Path path;
        SurfaceHolder holder;
        Random random;
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		public MySurfaceView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		holder = getHolder();
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		paint.setColor(Color.WHITE);
		
		}
		public boolean onTouchEvent(MotionEvent me){
			
			
			return true;
		}
		
	}
}
