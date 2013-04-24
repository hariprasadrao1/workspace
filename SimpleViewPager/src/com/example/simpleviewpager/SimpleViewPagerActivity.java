package com.example.simpleviewpager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;

public class SimpleViewPagerActivity extends Activity {
ViewPager myViewPager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_view_pager);
		MyPagerAdapter adapter = new MyPagerAdapter();
		myViewPager = (ViewPager) findViewById(R.id.);
		myViewPager.setAdapter(adapter);
		myViewPager.setCurrentItem(2);
		
	}
public void farLeftButton(){
	
}
public void farRightButton(){
	
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_simple_view_pager, menu);
		return true;
	}
 private class MyPagerAdapter extends PagerAdapter{

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
 public Object instantiateItem(View collection,int position){
	 LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	
	 int resId = 0;
	 switch(position){
	 case 0:
		 resId = R.layout.farleft;
	 case 1:
		 resId = R.layout.left;
	 case 2:
		 resId = R.layout.middle;
	 case 3:
		 resId = R.layout.right;
	 case 4:
		 resId = R.layout.farright;
	 }
	 
	View view = inflater.inflate(resId, null);
	((ViewPager) collection).addView(view,0);
	return view;
 }
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == ((View)arg1);
	}
	public void  restoreState(){
		 
	 }
	 public void startUpadate(){
		 
	 }
	public Parcelable saveState(){
		 return null;
	 }
	public void finishUpdate(){
		 
	 }
 }
}
