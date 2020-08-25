package com.udacity.gradle.builditbigger;


import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class EndpointAsycTaskTest {

    @Test
    public void setup() throws ExecutionException, InterruptedException {

        EndpointAsyncTask endPointAsyncTask = new EndpointAsyncTask();

        String joke = endPointAsyncTask.execute().get();
        assertEquals("Joke: What do you call a dinosaur that is sleeping?"+
        "Response: A dino-snore!",joke);
    }
}
