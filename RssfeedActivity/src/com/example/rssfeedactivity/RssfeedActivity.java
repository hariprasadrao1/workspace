package com.example.rssfeedactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class RssfeedActivity extends Activity implements MyListFragment.OnItemSelectedListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rssfeed);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rssfeed, menu);
		return true;
	}
	 public void onRssItemSelected(String link) {
		    DetailFragment fragment = (DetailFragment) getFragmentManager()
		            .findFragmentById(R.id.detailFragment);
		        if (fragment != null && fragment.isInLayout()) {
		          fragment.setText(link);
		        } 
		  }
}
