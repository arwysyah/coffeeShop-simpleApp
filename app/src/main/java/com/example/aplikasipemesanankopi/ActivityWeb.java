package com.example.aplikasipemesanankopi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        WebView WV = (WebView) findViewById(R.id.webview);
        WV.setWebViewClient(new WebViewClient());
        WV.getSettings().setJavaScriptEnabled(true);
        WV.loadUrl("http://mangaku.in");
    }
}
