package com.udacity.gradle.builditbigger.Test;

import android.util.Log;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;
import com.udacity.gradle.builditbigger.onJoke;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class EndpointAsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception{
        try {
            onJoke onJokeListener = new onJoke() {
                @Override
                public void onJokeListener(String result) {

                }
            };
            EndpointAsyncTask endpointsAsyncTask = new EndpointAsyncTask(onJokeListener);
            endpointsAsyncTask.execute();
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            Log.e("EndpointsAsyncTaskTest", "testDoInBackground: Timed out");
        }
    }
}
