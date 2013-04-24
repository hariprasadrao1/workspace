package com.example.lbssample;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;

public class myLocationListener implements LocationListener {
Context context;
	public myLocationListener(Context context){
	this.context = context;
}
	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		String message = String.format(
				"New Location \n Longitude: %1$s \n Latitude: %2$s",
				location.getLongitude(), location.getLatitude());
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		 Toast.makeText(context, "Provider status changed",
				                  Toast.LENGTH_LONG).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		Toast.makeText(context,
				                    "Provider disabled by the user. GPS turned off",
			                    Toast.LENGTH_LONG).show();
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		 Toast.makeText(context,
				                    "Provider enabled by the user. GPS turned on",
				                    Toast.LENGTH_LONG).show();
	}

}
