package com.example.rssfeedactivity;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment{

	 private OnItemSelectedListener listener;
	@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
View view = inflater.inflate(R.layout.fragment_rsslist_overview,container,false);
Button button = (Button) view.findViewById(R.id.b);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
      updateDetail();
    }

  });
return view;
	
}
	public interface OnItemSelectedListener {
	      public void onRssItemSelected(String link);
	    }
	@Override
    public void onAttach(Activity activity) {
      super.onAttach(activity);
      if (activity instanceof OnItemSelectedListener) {
        listener = (OnItemSelectedListener) activity;
      } else {
        throw new ClassCastException(activity.toString()
            + " must implemenet MyListFragment.OnItemSelectedListener");
      }
    }
  

private void updateDetail() {
	// TODO Auto-generated method stub
	// Create fake data
    String newTime = String.valueOf(System.currentTimeMillis());
    // Send data to Activity
    listener.onRssItemSelected(newTime);
}
}
