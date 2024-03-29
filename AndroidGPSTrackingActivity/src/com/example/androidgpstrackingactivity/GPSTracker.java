package com.example.androidgpstrackingactivity;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

public class GPSTracker extends Service implements LocationListener{
private final Context mContext;

//flag for GPS status
boolean isGPSEnabled = false;

//flag for network status
boolean isNetworkEnabled = false;
boolean canGetLocation = false;
Location location;//location
double latitude; //latitude
double longitude; //longitude

public static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;
public static final long	MIN_TIME_BW_UPDATES = 1000*60*1;

protected LocationManager locationManager;
public GPSTracker(Context context){
	mContext = context;
getLocation();	
}
public Location getLocation(){
	try{
		locationManager = (LocationManager)mContext.getSystemService(LOCATION_SERVICE);
	
	//getting GPS status
		isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
	
	// getting network status	
		isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	if(!isGPSEnabled && !isNetworkEnabled){
		
	}else{
		  this.canGetLocation = true;
		// First get location from Network Provider
          if (isNetworkEnabled) {
              locationManager.requestLocationUpdates(
                      LocationManager.NETWORK_PROVIDER,
                      MIN_TIME_BW_UPDATES,
                      MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
              Log.d("Network", "Network");
              if (locationManager != null) {
                  location = locationManager
                          .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                  if (location != null) {
                      latitude = location.getLatitude();
                      longitude = location.getLongitude();
                  }
              }
          }
          // if GPS Enabled get lat/long using GPS Services
          if (isGPSEnabled) {
              if (location == null) {
                  locationManager.requestLocationUpdates(
                          LocationManager.GPS_PROVIDER,
                          MIN_TIME_BW_UPDATES,
                          MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                  Log.d("GPS Enabled", "GPS Enabled");
                  if (locationManager != null) {
                      location = locationManager
                              .getLastKnownLocation(LocationManager.GPS_PROVIDER);
                      if (location != null) {
                          latitude = location.getLatitude();
                          longitude = location.getLongitude();
                      }
                  }
              }
          }
	}
	}catch(Exception e){
		
	}
	return location;
}
public double getLatitude(){
	if(location != null){
		latitude = location.getLatitude();
	}
	return latitude;
	
}
public double getLongitude(){
	if(location != null){
	longitude = location.getLongitude();
	}
	return longitude;
	
}
public void showSettingsAlert(){
	AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
	alertDialog.setTitle("GPS is settings");
	alertDialog.setMessage("GPS is not enabled." +
			"Do you wnat to go to settings menu?");
	
	//setting Icon to Dialog
	//alertDialog.setIcon(R.drawable.delete);
	alertDialog.setPositiveButton("",new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			mContext.startActivity(i);
		}
	});
	alertDialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
		
		@Override
		public void onClick(DialogInterface dialog, int which) {
			// TODO Auto-generated method stub
			dialog.cancel();
		}
	});

	alertDialog.show();	
}
public void stopUsingGPS(){
	if(locationManager != null){
		locationManager.removeUpdates(GPSTracker.this);
	}
}
public boolean canGetLocation(){
	return this.canGetLocation;
}
@Override
public void onLocationChanged(Location location) {
	// TODO Auto-generated method stub
	
}
@Override
public void onProviderDisabled(String provider) {
	// TODO Auto-generated method stub
	
}
@Override
public void onProviderEnabled(String provider) {
	// TODO Auto-generated method stub
	
}
@Override
public void onStatusChanged(String provider, int status, Bundle extras) {
	// TODO Auto-generated method stub
	
}
@Override
public IBinder onBind(Intent intent) {
	// TODO Auto-generated method stub
	return null;
}
}
