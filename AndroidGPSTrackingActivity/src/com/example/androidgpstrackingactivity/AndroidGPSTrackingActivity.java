package com.example.androidgpstrackingactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AndroidGPSTrackingActivity extends Activity {
Button btnShowLocation;
GPSTracker gps;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_android_gpstracking);
		btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
		btnShowLocation.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("hari");
				gps = new GPSTracker(AndroidGPSTrackingActivity.this);
				if(gps.canGetLocation()){
					double latitude = gps.getLatitude();
					double longitude = gps.getLongitude();
					Toast.makeText(getApplicationContext(), "your locatin is - \nLat:"+ latitude + "\nLong"+ longitude , Toast.LENGTH_LONG);
				}else{
					// can't get location
                    // GPS or Network is not enabled
                    // Ask user to enable GPS/network in settings
					gps.showSettingsAlert();
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_android_gpstracking, menu);
		return true;
	}

}
