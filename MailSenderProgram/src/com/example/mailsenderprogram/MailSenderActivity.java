package com.example.mailsenderprogram;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MailSenderActivity extends Activity {
Button mail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mail_sender);
	mail = (Button)	findViewById(R.id.mail);
	mail.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

            try {   
                GMailSender sender = new GMailSender("", "");
                sender.sendMail("hi",   
                        "Mail sender program demo trial",   
                        "mailtome61@gmail.com",   
                        "hariprasad_kakkera@yahoo.com,hariprasad.kakkera@gmail.com,hariprasad.k@paradigmcreatives.com"); 
                System.out.println("mail");
            } catch (Exception e) {   
                Log.e("SendMail", e.getMessage(), e);   
            } 
		}
	});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_mail_sender, menu);
		return true;
	}

}
