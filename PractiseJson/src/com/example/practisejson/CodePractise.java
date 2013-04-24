package com.example.practisejson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class CodePractise {
  public static JSONObject getJSONfromURL(String url){
	JSONObject jObject = null;
	InputStream is = null;
	String result = "";
	HttpClient httpClient = new DefaultHttpClient();
	HttpPost httpPost = new HttpPost(url);
		try {
		HttpResponse response = httpClient.execute(httpPost);
	       HttpEntity entity = response.getEntity();
		is = entity.getContent();
		} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//convert response to string
	
	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	StringBuilder sb = new StringBuilder();
	String line = null;
	try {
		while((line = reader.readLine()) != null){
			sb.append(line + "\n");
		}
		is.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	result = sb.toString();
	jObject = new JSONObject();
	return jObject;
}
	
 
}
