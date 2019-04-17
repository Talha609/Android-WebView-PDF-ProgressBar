package com.example.mohdtalha.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent=getIntent();
        String t=intent.getStringExtra("url");
        String s="http://docs.google.com/viewer?url=";
        s=s.concat(t);
        webView=(WebView)findViewById(R.id.webView);
        webView.loadUrl(s);
    }
    @Override
    protected void onResume()
    {
        this.finish();
        super.onResume();
    }
}
