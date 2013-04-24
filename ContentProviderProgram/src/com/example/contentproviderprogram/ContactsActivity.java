package com.example.contentproviderprogram;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.widget.TextView;

public class ContactsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		 TextView contactView = (TextView) findViewById(R.id.contactview);
		 Cursor cursor = getContacts();
		 while(cursor.moveToNext()){
			String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME));
			contactView.append("Name: ");
		      contactView.append(displayName);
		      contactView.append("\n");
		 }
	}

	private Cursor getContacts() {
		// TODO Auto-generated method stub
		//run query
		 Uri uri = ContactsContract.Contacts.CONTENT_URI;
		 String[] projection = new String[]{ContactsContract.Contacts._ID,ContactsContract.Contacts.DISPLAY_NAME};
		 String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '" + ("1") + "'";
		 String sortOrder = ContactsContract.Contacts.DISPLAY_NAME    + " COLLATE LOCALIZED ASC";
		
		return managedQuery(uri, projection, selection, null, sortOrder);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_contact, menu);
		return true;
	}

}
