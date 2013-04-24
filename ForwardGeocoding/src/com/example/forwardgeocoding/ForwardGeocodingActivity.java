package com.example.forwardgeocoding;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ForwardGeocodingActivity extends Activity implements View.OnClickListener{
EditText takeAddress,takeLong,takeLat;
Button getAddress,getLatAndLong;
TextView addLatAndLong,addAddress;
String address ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_forward_geocoding);
		takeAddress = (EditText) findViewById(R.id.take_address);
		takeLong = (EditText) findViewById(R.id.take_longitude);
 		takeLat =  (EditText) findViewById(R.id.take_latitude);
 		
 		
 		
 		getAddress = (Button) findViewById(R.id.get_address);
 		getLatAndLong= (Button) findViewById(R.id.get_coordinates);
 		getAddress.setOnClickListener(this);
 		getLatAndLong.setOnClickListener(this);
 		addLatAndLong = (TextView) findViewById(R.id.adding_longandlat);
 		addAddress= (TextView) findViewById(R.id.adding_address);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_forward_geocoding, menu);
		return true;
	}

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.get_address:
		System.out.println("for address");	
		Geocoder geocode = new Geocoder(this);
			try {
				
				 address = takeAddress.getText().toString();	
			List<Address>	 listAddress = geocode.getFromLocationName(address, 1);
			
			Address add = listAddress.get(0);
			System.out.println(add);
			String lat = String.valueOf(listAddress.get(0).getLatitude());
			 String longitude =  String.valueOf(listAddress.get(0).getLongitude()) ;
			 Toast.makeText(getApplicationContext(), longitude + ","+lat, Toast.LENGTH_LONG).show();
			  listAddress.get(0).getLatitude();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		case R.id.get_coordinates:
			
			System.out.println("for lat and long");	
			break;
		}
	}

	
	

}
