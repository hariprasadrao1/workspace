package com.paradigmcreatives.demowebview;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends Activity{
WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.web_view);
	webView = (WebView)findViewById(R.id.webview);
	
	webView.getSettings().getJavaScriptEnabled();
	//webView.loadUrl("http://google.com");
	
	String customHtml = " <html>  <body> Hello, WebView </body></html>";
	webView.loadData(customHtml, "text/html", "UTF-8");
	}
}
