package com.example.vsample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText mEditText;
	LinearLayout layout ;
	SharedPreferences myprefs;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 mEditText = (EditText)findViewById(R.id.text);
		 Button mButton = (Button)findViewById(R.id.press);
		 layout = (LinearLayout)findViewById(R.id.layout);
		 mButton.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View v) {
				
				TextView mTextView = new TextView(MainActivity.this);
				mTextView.setText(mEditText.getText().toString());
				myprefs = MainActivity.this.getSharedPreferences("myprefs", MODE_PRIVATE);
				layout.addView(mTextView);
				setContentView(layout);
			}
		});
		
	}

	

}
