package com.builditbigger.jokejavalibrary;

import java.util.Random;

public class Joke {

    //Joke source https://redtri.com/best-jokes-for-kids/slide/1
    public static final String[] joke = new String[] {

            "Joke: What do you call a dinosaur that is sleeping?"+
                    "Response: A dino-snore!",
            "Joke: What is fast, loud and crunchy?"+
                    "Response: A rocket chip!",
            "Joke: Why did the Teddy bear say no to dessert?"+
                    "Response: Because she was stuffed!",
            "Joke: What has ears and cannot hear?"+
                    "Response: A cornfield!",
            "Joke: What did the right eye tell to the left eye"+
                    "Response: Between us, something smells!",
            "Joke: What do you get when you cross a vampire and a snowman"+
                    "Response: Frost bite!",
            "Joke: What did one plate say to the other plate?"+
                    "Response: Dinner is on me!",
            "Joke: Why did the student eat his homework?"+
                    "Response: Because the teacher said it was a piece of cake!",
            "Joke: When you look for something, why is it always in the last place you look?"+
                    "Response: Because when you find it, you stop looking.",
            "Joke: What is brown, hairy and wears sunglasses?"+
                    "Response: A coconut on vacation"
    };

    public static String getJoke(){
        Random random = new Random();
        int idx = random.nextInt(joke.length);
        return joke[idx];
    }


}
