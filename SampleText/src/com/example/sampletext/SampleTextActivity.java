package com.example.sampletext;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SampleTextActivity extends Activity {
	Boolean s1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_text);
boolean s = true;
System.out.println(s);
System.out.println(s1);
s1 = !s;
if( !s1){
 s1 = s;
 System.out.println("hari");
 System.out.println(s1);
}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sample_text, menu);
		return true;
	}

}
