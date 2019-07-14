package com.edward.alcabout;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutAlcActivity extends AppCompatActivity {

    private WebView alcWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        setTitle("About ALC");

        alcWebView = findViewById(R.id.webview_about_alc);
        alcWebView.getSettings().setLoadsImagesAutomatically(true);
        alcWebView.getSettings().setJavaScriptEnabled(true);
        alcWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        alcWebView.loadUrl("https://andela.com/alc/");

        alcWebView.setWebViewClient(new WebViewClient() {
            ProgressDialog progressDialog = new ProgressDialog(AboutAlcActivity.this);

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressDialog.setTitle("Loading...");
                progressDialog.setMessage("Please wait...");
                progressDialog.setCancelable(false);
                progressDialog.show();
            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed(); // Ignore SSL certificate errors
            }
        });

        alcWebView.getSettings().setLoadWithOverviewMode(true);
        alcWebView.getSettings().setUseWideViewPort(true);
    }

}
