package com.example.ayushgupta.my6;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.wview);
        webView.setBackgroundColor(Color.parseColor("#9e9e9e"));
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.addJavascriptInterface(this,"MyJavaInterface");
        ImageView imageView = findViewById(R.id.iv1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl("file:///android_asset/Login.html");
            }
        });
    }
    @JavascriptInterface
    public void display(String uname, String pass){
        Toast.makeText(this,uname+"\t"+pass,Toast.LENGTH_SHORT).show();
    }

    public void ClickEvent (View v){
        //Toast.makeText(this,"Button pressed",Toast.LENGTH_SHORT).show();
        switch (v.getId()){
            case R.id.iv2:
                EditText editText = findViewById(R.id.et1);
                webView.loadUrl("https://"+editText.getText().toString());
                break;
            case R.id.iv3:
                webView.loadUrl("https://www.facebook.com");
                break;
            case R.id.iv4:
                webView.loadUrl("https://plus.google.com");
                break;
            case R.id.iv5:
                webView.loadUrl("https://www.tumblr.com");
                break;
            case R.id.iv6:
                webView.loadUrl("https://www.twitter.com");
                break;
        }
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                bar = new ProgressDialog(MainActivity.this,ProgressDialog.STYLE_SPINNER);
                bar.setMessage("Page is loading...");
                bar.show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if(bar.isShowing()){
                    bar.dismiss();
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                    bar.dismiss();
            }
        });
    }
}
