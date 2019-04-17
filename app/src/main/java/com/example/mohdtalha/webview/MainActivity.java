package com.example.mohdtalha.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;
    WebView webView;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView=findViewById(R.id.webView);
        mProgressBar=findViewById(R.id.mProgressBar);
        mProgressBar.setMax(100);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("....url...");

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                mProgressBar.setProgress(newProgress);
            }
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String request)
            {
                if(webView.getHitTestResult().getExtra().endsWith(".pdf"))
                {
                    try
                    {
                        Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                        intent.putExtra("url",webView.getHitTestResult().getExtra());
                        startActivity(intent);
                        return true;
                    }
                    catch (Exception e)
                    {
                        Toast.makeText(MainActivity.this, e+"", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                else
                {
                    webView.loadUrl(request);
                    return true;
                }
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                mProgressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }
    public void onBackPressed ()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}