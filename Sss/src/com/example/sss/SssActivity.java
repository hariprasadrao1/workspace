package com.example.sss;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class SssActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState != null){
			String str = savedInstanceState.getString("data");
			Toast.makeText(this, str, Toast.LENGTH_LONG).show();
		}
		setContentView(R.layout.activity_sss);
		
	}

	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		super.onStart();
		Toast.makeText(this, "start", Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
		super.onResume();
		Toast.makeText(this, "resume", Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(this, "pause", Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Toast.makeText(this, "stop", Toast.LENGTH_LONG).show();
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putString("data", "i am in onSave()");
		Toast.makeText(this, "onSaveInstance", Toast.LENGTH_LONG).show();
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sss, menu);
		return true;
	}

}
