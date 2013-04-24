package com.example.surfaceviewexample;

import com.example.surfaceviewexample.SurfaceActivity.MySurfaceView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	int x,y;
	int width,height;
	Bitmap b;
	int xSpeed, ySpeed;
	MySurfaceView mySurfaceView;
	
	public Sprite(MySurfaceView mySurfaceView, Bitmap b){
		this.b = b;
		this.mySurfaceView = mySurfaceView;
		x = y = 0;
		width = b.getWidth();
		height = b.getHeight();
		xSpeed = 5;
		ySpeed = 0;
	}
	public void onDraw(Canvas c){
		update();
		Rect src = new Rect(0,0,width,height);
		Rect dst = new Rect(x,y,x + width, y+height);
		c.drawBitmap(b, src, dst, null);
	}
	private void update() {
		System.out.println("hari");
		// TODO Auto-generated method stub
		if(x>mySurfaceView.getWidth()-width-xSpeed){
			xSpeed = 0 ;
			ySpeed = 5;
		}
		if(y>mySurfaceView.getHeight()-height-ySpeed){
			xSpeed = -5;
			ySpeed = 0;
		}
		if(x+xSpeed<0){
			x = 0;
			xSpeed = 0;
			ySpeed = -5;
		}
		if(y+ySpeed<0){
			y = 0;
			ySpeed = 0;
			xSpeed = 5;
		}
	}
}
