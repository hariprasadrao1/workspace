package com.paradigmcreatives.zoomingimage;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ZoomingActivity extends Activity {

	ImageView image;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zooming);
	Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
		zoom.reset();
		image = (ImageView)findViewById(R.id.image);
		
		image.setImageResource(R.drawable.ic_launcher);
		image.startAnimation(zoom);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_zooming, menu);
		return true;
	}

}
