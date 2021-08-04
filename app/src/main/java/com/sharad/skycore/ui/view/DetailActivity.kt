package com.sharad.skycore.ui.view

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.sharad.skycore.R

/**
 * Created by Sharad-Ubuntu on 07/05/2021.
 */
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val mWebView: WebView = findViewById(R.id.webview)
        mWebView.loadUrl(intent.getStringExtra("url"))
        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }
        }
    }
}