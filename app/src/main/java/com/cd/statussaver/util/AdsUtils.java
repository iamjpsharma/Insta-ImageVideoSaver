package com.cd.statussaver.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;


import com.cd.statussaver.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import static com.facebook.ads.AudienceNetworkAds.TAG;

public class AdsUtils {

    public static void showGoogleBannerAd(Context context, com.google.android.gms.ads.AdView googleAdView) {

        googleAdView.setVisibility(View.VISIBLE);
        //Load Banner Ad
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        googleAdView.loadAd(adRequest);
    }

    public static void showGoogleInterstitialAd(Context context) {

        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        final com.google.android.gms.ads.InterstitialAd mInterstitialAd = new com.google.android.gms.ads.InterstitialAd(context);
        mInterstitialAd.setAdUnitId(context.getResources().getString(R.string.admob_interstitial_ad));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
            }

            @Override
            public void onAdOpened() {
            }

            @Override
            public void onAdClicked() {
            }

            @Override
            public void onAdLeftApplication() {
            }

            @Override
            public void onAdClosed() {
            }
        });


    }


    public static AdView showFBBannerAd(Context context, LinearLayout adContainer) {
        adContainer.setVisibility(View.VISIBLE);
        AdView adView = new AdView(context, context.getResources().getString(R.string.fb_placement_id), AdSize.BANNER_HEIGHT_50);
        adContainer.addView(adView);
        adView.loadAd();

        return adView;

    }

    public static InterstitialAd showIntertitialAd(Context context) {
        final InterstitialAd interstitialAd = new InterstitialAd(context, context.getResources().getString(R.string.fb_placement_interstitial_id));
        // Set listeners for the Interstitial Ad
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Show the ad
                interstitialAd.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        interstitialAd.loadAd();

        return interstitialAd;
    }


    public static AdView showFBBannerAdRect(Context context, LinearLayout adContainer) {
        adContainer.setVisibility(View.VISIBLE);
        AdView adView = new AdView(context, context.getResources().getString(R.string.fb_placement_id), AdSize.RECTANGLE_HEIGHT_250);
        adContainer.addView(adView);
        adView.loadAd();

        return adView;

    }


}
