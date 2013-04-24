package com.example.vogellaintentserviceactivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Messenger;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class VogellaIntentServiceActivity extends Activity {

	 private Handler handler = new Handler(){
		 public void handleMessage(android.os.Message msg) {
			Object path =  msg.obj;
		System.out.println(path);
		System.out.println(msg.arg1);
		System.out.println(RESULT_OK);
			 if (msg.arg1 == RESULT_OK && path != null) {
			        Toast.makeText(VogellaIntentServiceActivity.this,
			            "Downloaded" + path.toString(), Toast.LENGTH_LONG)
			            .show();
			      } else {
			        Toast.makeText(VogellaIntentServiceActivity.this, "Download failed.",
			            Toast.LENGTH_LONG).show();
			      }

		 }
	 };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vogella_intent_service);
		
	}
	public void startClick(View v){
		 Intent intent = new Intent(this, DownloadService.class);
		// Create a new Messenger for the communication back
	    Messenger messenger = new Messenger(handler);
	    intent.putExtra("MESSENGER", messenger);
	    intent.setData(Uri.parse("http://www.vogella.com/index.html"));
	    intent.putExtra("urlpath", "http://www.vogella.com/index.html");
	    startService(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_vogella_intent_service, menu);
		return true;
	}

}
