package com.minhnpa.trolldemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MoreDetailsWebFragment extends Fragment {
    WebView webView;

    Troll troll;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_moredetails_web, null);

        webView = (WebView) v.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(troll.getUrl());

        return v;
    }

    public void setTroll(Troll troll) {
        this.troll = troll;
    }
}
