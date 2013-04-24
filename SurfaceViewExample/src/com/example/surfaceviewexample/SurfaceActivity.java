package com.example.surfaceviewexample;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceActivity extends Activity {
   MySurfaceView mySurfaceView;
   Sprite sprite;
   Bitmap b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_surface);
		mySurfaceView = new MySurfaceView(this);
		b = BitmapFactory.decodeResource(getResources(), R.drawable.sprite);
		setContentView(mySurfaceView);
	}
@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mySurfaceView.onPause();
	}
@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mySurfaceView.onResume();
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_surface, menu);
		return true;
	}
class MySurfaceView extends SurfaceView implements Runnable{
  Thread thread = null;
	SurfaceHolder holder;
	boolean running = false;
	private ElaineAnimated elaine;
	Random random;
	Paint  paint= new Paint(Paint.ANTI_ALIAS_FLAG);
	public MySurfaceView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		holder = getHolder();
		random = new Random();
	}
	void onResume(){
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	void onPause(){
		boolean retry = true;
		  running = false;
		   while(retry){
		    try {
		     thread.join();
		     retry = false;
		    } catch (InterruptedException e) {
		     // TODO Auto-generated catch block
		     e.printStackTrace();
		    }
		   }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/**elaine = new ElaineAnimated(BitmapFactory.decodeResource(
				getResources(), R.drawable.sprite), 400, 70, // initial position
								 BitmapFactory.decodeResource(getResources(),
						R.drawable.one));*/
		while(running){
			sprite  = new Sprite(this,b);
			if(holder.getSurface().isValid()){
				Canvas c = holder.lockCanvas();
			   /**  paint.setStyle(Paint.Style.STROKE);
			        paint.setStrokeWidth(3);
			      
			     int w = c.getWidth();
			     int h = c.getHeight();
			     int x = random.nextInt(w-1);
			     int y = random.nextInt(h-1);
			     int r = random.nextInt(255);
			     int g = random.nextInt(255);
			     int b = random.nextInt(255);
			     paint.setColor(0xff000000 + (r << 16) + (g << 8) + b);
			     c.drawPoint(x, y, paint);
				
				//elaine.update(System.currentTimeMillis());
				//onDraw(c);*/
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}
		}
	}
	public void onDraw(Canvas c){
		//elaine.draw(c);
	sprite.onDraw(c);
	}
}
}
