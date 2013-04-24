package com.paradigmcreatives.samplepreferences;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
public static final String PREFS = "example"
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	final EditText mEditText = (EditText)findViewById(R.id.edittext);
	Button mButton = (Button)findViewById(R.id.button);
	
	mButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String message = mEditText.getText().toString();
			
			// TODO Auto-generated method stub
			
		}
	});
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
