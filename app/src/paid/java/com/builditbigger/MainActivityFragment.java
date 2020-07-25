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
import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.onJoke;

public class MainActivityFragment extends Fragment implements onJoke{
    Button mJokeButton;
    ProgressBar mProgressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mJokeButton = (Button) root.findViewById(R.id.btn_joke);

        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        mJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });

        return root;
    }

    public void loadData() {
        mProgressBar.setVisibility(View.VISIBLE);

        EndpointAsyncTask endpointAsyncTask = new EndpointAsyncTask(this);
        endpointAsyncTask.execute();
    }

    @Override
    public void onJokeListener(String result) {
        Intent intent = new Intent(getActivity(), DisplayJoke.class);
        intent.putExtra("joke", result);

        mProgressBar.setVisibility(View.GONE);

        startActivity(intent);
    }
}