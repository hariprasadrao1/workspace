package com.example.space;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SpaceActivity extends Activity {
EditText space;
Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_space);
		space = (EditText) findViewById(R.id.space);
	button = 	(Button)findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		/*InputFilter filter = new InputFilter() { 
	        public CharSequence filter(CharSequence source, int start, int end, 
	Spanned dest, int dstart, int dend) { 
	                for (int i = start; i < end; i++) { 
	                        if (!Character.isLetterOrDigit(source.charAt(i))) { 
	                                return ""; 
	                        } 
	                } 
	                return null; 
	        } 
	}; */

	//space.setFilters(new InputFilter[]{filter}); 
		space.addTextChangedListener(new TextWatcher() {

		    public void afterTextChanged(Editable s) {
		    	String result = s.toString().replaceAll(" ", "");
		    	 if (!s.toString().equals(result)) {
		            space.setText(result);
		             space.setSelection(result.length());
		             // alert the user
		        }        //---//
		                  }
		    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

		    public void onTextChanged(CharSequence s, int start, int before, int count) {}
		        }); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_space, menu);
		return true;
	}

}
