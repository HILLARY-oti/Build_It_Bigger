package com.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.builditbigger.jokeandroidlibrary.DisplayJoke;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.onJoke;

public class MainActivityFragment extends Fragment implements onJoke {

    InterstitialAd mInterstitialAd;
    Button mJokeButton;
    ProgressBar mProgressBar;
    String mResult;
    Boolean mAdsOnScreen;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mJokeButton = (Button) root.findViewById(R.id.btn_joke);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        // Instantiate the InterstitialAd object
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        // Create the AdListener
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                mAdsOnScreen = false;
                launchActivity();
            }
        });

        requestNewInterstitial();

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Display the interstitial ad
                if (mInterstitialAd.isLoaded()) {
                    mAdsOnScreen = true;
                    mInterstitialAd.show();
                } else {
                    mAdsOnScreen = false;
                }

                loadData();
                launchActivity();
            }
        });

        return root;
    }

    public void loadData() {
        mResult = null;
        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(this);
        endpointAsyncTask.execute();
    }

    @Override
    public void onJokeListener(String result) {
        mResult = result;
        launchActivity();
    }

    public void launchActivity() {
        // No ads currently displayed
        if (!mAdsOnScreen) {
            // Data is ready
            if (mResult != null) {
                Intent intent = new Intent(getActivity(), DisplayJoke.class);
                intent.putExtra("joke", mResult);
                mProgressBar.setVisibility(View.GONE);
                startActivity(intent);

            } else {
                mProgressBar.setVisibility(View.VISIBLE);
            }
        }
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}