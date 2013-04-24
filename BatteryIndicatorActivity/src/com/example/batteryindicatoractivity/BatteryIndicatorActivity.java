package com.example.batteryindicatoractivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BatteryIndicatorActivity extends Activity {
	//Create Broadcast Receiver Object along with class definition
	private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
		  //When Event is published, onReceive method is called
		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			 //Get Battery %
			int level = intent.getIntExtra("level", 0);
			//Find the progressbar creating in main.xml
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressbar);
              //Set progress level with battery % value
            pb.setProgress(level);
              //Find textview control created in main.xml
            TextView tv = (TextView) findViewById(R.id.textfield);
              //Set TextView with text
            tv.setText("Battery Level: " + Integer.toString(level) + "%");
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battery_indicator);
		 //Register the receiver which triggers event
        //when battery charge is changed
		//the above receiver i am registering here
		   registerReceiver(mBatInfoReceiver, new IntentFilter(
	                Intent.ACTION_BATTERY_CHANGED));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_battery_indicator, menu);
		return true;
	}

}
