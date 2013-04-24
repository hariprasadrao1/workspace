package com.example.lbssample;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LBSActivity extends Activity {
	Button retrieveLocation;
	LocationManager lManager;
	private static final long MINIMUM_DISTANCE_CHANGE_FOR_UPDATES = 1; // in
																		// Meters
	private static final long MINIMUM_TIME_BETWEEN_UPDATES = 1000; // in
																	// Milliseconds

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lbs);
		retrieveLocation = (Button) findViewById(R.id.retrieve_location_button);
		lManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		// requestLicationUpdates(provider,time,distance,class which implements
		// LocationListener);
		lManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				MINIMUM_TIME_BETWEEN_UPDATES,
				MINIMUM_DISTANCE_CHANGE_FOR_UPDATES, new myLocationListener(
						this));
		retrieveLocation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showLocation();
			}

			private void showLocation() {
				// TODO Auto-generated method stub

				// here i will get location using getLastKnownLocation() w.r.t
				// to
				// LocationManaget instace (i.e lManager)

				Location location = lManager
						.getLastKnownLocation(LocationManager.GPS_PROVIDER);
				if (location != null) {
					String message = String
							.format("Current Location \n Longitude: %1$s \n Latitude: %2$s",
									location.getLongitude(),
									location.getLatitude());
					Toast.makeText(LBSActivity.this, message, Toast.LENGTH_LONG)
							.show();
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lbs, menu);
		return true;
	}

}
