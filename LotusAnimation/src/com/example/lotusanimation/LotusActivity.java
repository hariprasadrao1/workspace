package com.example.lotusanimation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class LotusActivity extends Activity implements OnTouchListener{
   OurView ov;
   Bitmap ball;
   float x,y;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lotus);
		ov = new OurView(this);
		ball = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		ov.setOnTouchListener(this);
		x = y =0;
		setContentView(ov);
	}
 
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ov.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		ov.resume();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lotus, menu);
		return true;
	}
 private class OurView extends SurfaceView implements Runnable{

	 Thread thread = null;
	 SurfaceHolder holder;
	 boolean isItOk = false;
	public OurView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	holder = getHolder();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isItOk == true){
		if(!holder.getSurface().isValid()){
			continue;
		}
		Canvas c = holder.lockCanvas();
		c.drawARGB(255, 150,150, 10);
		c.drawBitmap(ball,x,y,new Paint());
		holder.unlockCanvasAndPost(c);
		}
	}
	 public void pause(){
		 isItOk = false;
		 while(true){
	    try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		break;
		 }
		 thread = null;
	 }
	 public void resume(){
		isItOk = true;
		thread = new Thread(this); 
		thread.start();
	 }
 }
@Override
public boolean onTouch(View v, MotionEvent event) {
	// TODO Auto-generated method stub
	return false;
}
}
