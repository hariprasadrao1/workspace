package com.example.mulitplechoicelist;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MultipleChoiceListActivity extends Activity {
 
	ListView myList;
	Button getChoice;
	String[] listContent = {
			 
            "January",  "February", "March","April",  "May",  "June",
 
            "July",
 
            "August",
 
            "September",
 
            "October",
 
            "November",
 
            "December"
 
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_choice_list);
		 myList = (ListView)findViewById(R.id.list);
		 
	        getChoice = (Button)findViewById(R.id.getchoice);
	        ArrayAdapter<String> adapter
	        
	        = new ArrayAdapter<String>(this,
	 
	                android.R.layout.simple_list_item_multiple_choice,
	 
	             listContent);
	        myList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	        myList.setAdapter(adapter);
	        getChoice.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String selected = "";
					
				SparseBooleanArray sparseBooleanArray	=  myList.getCheckedItemPositions();
				for(int i = 0;i<myList.getCount();i++){
					if(sparseBooleanArray.get(i)){
					
						selected +=	myList.getItemAtPosition(i).toString();
					
					}
	               
				}
				Toast.makeText(MultipleChoiceListActivity.this,
               		 
                        selected,
 
                        Toast.LENGTH_LONG).show();
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_multiple_choice_list, menu);
		return true;
	}

}
