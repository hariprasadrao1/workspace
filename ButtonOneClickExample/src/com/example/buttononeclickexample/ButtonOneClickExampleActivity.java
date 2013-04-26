package com.example.buttononeclickexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;

public class ButtonOneClickExampleActivity extends Activity {
Button clickable;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button_one_click_example);
	 clickable = 	(Button)findViewById(R.id.clickable);
	RelativeLayout layout = (RelativeLayout) findViewById(R.id.linear_layout_tags);

	    //set the properties for button
	    Button btnTag = new Button(this);
	    btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
	    btnTag.setText("settings");
	  

	    //add button to the layout
	    layout.addView(btnTag);
	    btnTag.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "clickable true", Toast.LENGTH_LONG).show();
				clickable.setClickable(true);
			}
		});
	 clickable.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "clickable false", Toast.LENGTH_LONG).show();
			clickable.setClickable(false);
		}
	});
	}
	@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
			super.onBackPressed();
			clickable.setClickable(true);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_button_one_click_example,
				menu);
		return true;
	}

}
