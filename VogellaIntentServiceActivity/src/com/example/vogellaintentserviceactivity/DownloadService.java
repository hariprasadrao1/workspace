package com.example.vogellaintentserviceactivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

public class DownloadService extends IntentService{
	 private int result = Activity.RESULT_CANCELED;
	public DownloadService() {
		super("Download Service");
		// TODO Auto-generated constructor stub
	
	}
	 // Will be called asynchronously be Android
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
	Uri  data =	intent.getData();
	String urlPath = intent.getStringExtra("urlpath");
	String fileName = data.getLastPathSegment();
	Log.e("data.getLastPathSegment", fileName);


	File output = new File(Environment.getExternalStorageDirectory(),fileName);
	 Log.e("output.getPath()", output.getPath());
	 System.out.println(output.getAbsolutePath());
	if (output.exists()) {
	      output.delete();
	    }
	InputStream stream = null;
	 FileOutputStream fos = null;
	 try{
		
		 URL url = new URL(urlPath);
		
		 stream = url.openConnection().getInputStream();
		
		 InputStreamReader reader = new InputStreamReader(stream);
		
		 fos = new FileOutputStream(output.getPath());
		
		 int next = -1;
		
	      while ((next = reader.read()) != -1) {
	      //getting data from reader writing it in to FileOutputStream
	    	   
	    	  fos.write(next);
	      }
	      // Successful finished
	      result = Activity.RESULT_OK;
	   
	 }catch(Exception e){
		e.printStackTrace(); 
	 }finally {
	      if (stream != null) {
	          try {
	            stream.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          }
	        }
	        if (fos != null) {
	          try {
	            fos.close();
	          } catch (IOException e) {
	            e.printStackTrace();
	          }
	        }
	      }
	
	Bundle extras = intent.getExtras();
    if (extras != null) {
      Messenger messenger = (Messenger) extras.get("MESSENGER");
      Message msg = Message.obtain();
      msg.arg1 = result;
      System.out.println(result);
      System.out.println("msg.arg1"  + msg.arg1);
      msg.obj = output.getAbsolutePath();
      try {
        messenger.send(msg);
      } catch (android.os.RemoteException e1) {
        Log.w(getClass().getName(), "Exception sending message", e1);
      }

    }
  }
}
