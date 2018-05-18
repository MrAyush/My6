package com.example.ayushgupta.my6;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = findViewById(R.id.wview);
        webView.setBackgroundColor(Color.parseColor("#9e9e9e"));
        permissionHandle();
        final EditText editText = findViewById(R.id.et1);
        ImageView imageView = findViewById(R.id.iv2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.setBackgroundColor(Color.TRANSPARENT);
                webView.loadUrl("https://"+editText.getText().toString());
                webView.setWebViewClient(new WebViewClient());
            }
        });
        ImageView imageView1 = findViewById(R.id.iv1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Home button coming soon",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ClickEvent (View v){
        //Toast.makeText(this,"Button pressed",Toast.LENGTH_SHORT).show();
        switch (v.getId()){
            case R.id.iv3:
                webView.setBackgroundColor(Color.TRANSPARENT);
                webView.loadUrl("https://www.facebook.com");
                webView.setWebViewClient(new WebViewClient());
                break;
            case R.id.iv4:
                webView.setBackgroundColor(Color.TRANSPARENT);
                webView.loadUrl("https://plus.google.com");
                webView.setWebViewClient(new WebViewClient());
                break;
            case R.id.iv5:
                webView.setBackgroundColor(Color.TRANSPARENT);
                webView.loadUrl("https://www.tumblr.com");
                webView.setWebViewClient(new WebViewClient());
                break;
            case R.id.iv6:
                webView.setBackgroundColor(Color.TRANSPARENT);
                webView.loadUrl("https://www.twitter.com");
                webView.setWebViewClient(new WebViewClient());
                break;

        }
    }
    private void permissionHandle(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.INTERNET},100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_DENIED){
            Toast.makeText(this,"Can't access the internet",Toast.LENGTH_SHORT).show();
        }
    }
}
