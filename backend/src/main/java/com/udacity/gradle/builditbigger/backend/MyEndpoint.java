package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.builditbigger.jokejavalibrary.Joke;
import com.google.api.server.spi.config.Named;


/**
     * An endpoint method that returns a joke
     */
    @Api(
            name = "myApi",
            version = "v1",
            namespace = @ApiNamespace(
                    ownerDomain = "backend.builditbigger.gradle.udacity.com",
                    ownerName = "backend.builditbigger.gradle.udacity.com",
                    packagePath = ""
            )
    )
    public class MyEndpoint {

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        response.setData(Joke.getJoke());

        return response;
    }
}