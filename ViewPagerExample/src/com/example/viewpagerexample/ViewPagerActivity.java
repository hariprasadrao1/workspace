package com.example.viewpagerexample;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class ViewPagerActivity extends FragmentActivity {
 ViewPager _mViewPager;
 ViewPageAdapter _adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		_mViewPager = (ViewPager) findViewById(R.id.hari);
		setUpView();
		setTab();
		
	}

	private void setTab() {
		// TODO Auto-generated method stub
		
	}

	private void setUpView() {
		// TODO Auto-generated method stub
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_pager, menu);
		return true;
	}

}
