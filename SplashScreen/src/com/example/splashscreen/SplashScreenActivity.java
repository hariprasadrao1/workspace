package com.example.splashscreen;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.VideoView;

public class SplashScreenActivity extends Activity {
VideoView myVideoView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
		/*Uri raw_uri=Uri.parse("android.resource://com.example.splashscreen/"+R.raw.splash);

				myVideoView=(VideoView) findViewById(R.id.video_view);

				myVideoView.setVideoURI(raw_uri);
				myVideoView.setMediaController(new MediaController(this));
				//myVideoView.requestFocus();
				myVideoView.start();*/
		myVideoView = (VideoView) findViewById(R.id.video_view);
		myVideoView.setMediaController(new MediaController(this));
	  //  myVideoView.setVideoPath("android.resource://com.example.splashscreen/raw/splash");
	String url = "android:resource://"+ getPackageName() + "/"+ R.raw.somevideo;
	myVideoView.setVideoURI(Uri.parse(url));   
	myVideoView.start();
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}

}
