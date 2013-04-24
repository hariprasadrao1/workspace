package com.example.sharedvinod;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.TextView;

public class SharedActivity extends Activity {

	TextView firstText,secondText;
	public static final String STORE = "store";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared);
		firstText = (TextView)findViewById(R.id.first_text);
		secondText = (TextView)findViewById(R.id.second_text);
		SharedPreferences storing = getSharedPreferences(STORE, MODE_PRIVATE);
		SharedPreferences.Editor editor = storing.edit();
		editor.putString("first", "first text");
		editor.putString("second", "second text");
		editor.commit();
		firstText.setText(storing.getString("first","default string"));
		secondText.setText(storing.getString("second","default string"));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_shared, menu);
		return true;
	}

}
