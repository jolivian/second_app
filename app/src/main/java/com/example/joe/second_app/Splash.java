package com.example.joe.second_app;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Joe on 1/30/2018.
 */

public class Splash extends Activity{

    MediaPlayer ourSong;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        ourSong = MediaPlayer.create(Splash.this,R.raw.ringtone);
        ourSong.start();
        Thread timer = new Thread() {
          public void run(){
            try{
                sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent openStartingPoint = new Intent("com.second_app.joe.MENU");
                startActivity(openStartingPoint);
            }
          }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSong.release();
        finish();
    }
}
