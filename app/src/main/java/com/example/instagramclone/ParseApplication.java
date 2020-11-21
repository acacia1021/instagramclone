package com.example.instagramclone;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    //Initializes Parse SDK as soon as the application is created
    @Override
    public void onCreate() {
        super.onCreate();

        //Register your parse models
        ParseObject.registerSubclass(Post.class);

        //Register your parse models
   //     ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("TpPVq7dOHXWOs3HHwJcSQsXFebOGGPk0IL7OVgne")
                .clientKey("grRoTdQgRXgjdTM7x0lxk94IBO5d5JVAksKOtRET")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
