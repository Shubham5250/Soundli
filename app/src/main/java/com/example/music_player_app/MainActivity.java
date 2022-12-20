package com.example.music_player_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity<Textview> extends AppCompatActivity {

    private SeekBar seekBar;
    private Textview songTitle;
    private MediaPlayer mediaPlayer;
    private Runnable runnable;
    private AudioManager audioManager;
    ImageView play;
    ImageView skipNext;
    ImageView skipPrev;

    int currentIndex =0;

    public MainActivity(Textview songTitle) {
        this.songTitle = songTitle;
        if(currentIndex == 0){
            (new TextView((Context) songTitle)).setText("Yugat Mandli.mp3");
        }
        if(currentIndex == 1){
            (new TextView((Context) songTitle)).setText("Shivba Raja shivba raja.mp3");
        }if(currentIndex == 2){
            (new TextView((Context) songTitle)).setText("Shwasat raja dhyasat raja.mp3");
        }
        if(currentIndex == 3){
            (new TextView((Context) songTitle)).setText("Majhya Raja Ra.mp3");
        }
        if(currentIndex == 4){
            (new TextView((Context) songTitle)).setText("Sawari Bhavani Chauka madhi.mp3");
        }
    }

    //Arraylist to store our songs




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the values
        play = findViewById(R.id.play);
        seekBar = findViewById(R.id.seekBar);
        skipNext = findViewById(R.id.skipNext);
        final Textview songTitle = (Textview) findViewById(R.id.songTitle);

        ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0,R.raw.yugatMandali);
        songs.add(1,R.raw.shivbaRaja);
        songs.add(2,R.raw.shwasatRaja);
        songs.add(3,R.raw.majhyaRajaRa);
        songs.add(4,R.raw.sawari);


        //initializing the mediaplayer
        mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
        mediaPlayer.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                }else{
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_baseline_play_circle_24);
                }
                songNames();
            }
        });

        skipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer !=null){
                    play.setImageResource(R.drawable.ic_baseline_play_circle_24);
                }

                if(currentIndex < songs.size()-1 ){
                    currentIndex++;
                }

                else{
                    currentIndex = 0;
                }

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mediaPlayer.start();
                songNames();
            }
        });

        skipPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer !=null){
                    play.setImageResource(R.drawable.ic_baseline_play_circle_24);
                }

                if(currentIndex >0 ){
                    currentIndex--;
                }

                else{
                    currentIndex = songs.size()-1;
                }

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.start();
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(currentIndex));
                mediaPlayer.start();
                songNames();
            }

        });





//        mediaPlayer = new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource("http://socialdance.stanford.edu/music/Moskwa.mp3");
//            //mediaPlayer.prepare();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


            seekBar.setMax(mediaPlayer.getDuration());
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                   if(fromUser){
                        mediaPlayer.seekTo(progress);}
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


//        play.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.start();
//
//            }
//        });
//        prev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mediaPlayer.pause();
//            }
//        });
        }

        private void songNames(){
            if(currentIndex == 0){
                (new TextView((Context) songTitle)).setText("Yugat Mandli.mp3");
            }
            if(currentIndex == 1){
                (new TextView((Context) songTitle)).setText("Shivba Raja shivba raja.mp3");
            }if(currentIndex == 2){
                (new TextView((Context) songTitle)).setText("Shwasat raja dhyasat raja.mp3");
            }
            if(currentIndex == 3){
                (new TextView((Context) songTitle)).setText("Majhya Raja Ra.mp3");
            }
            if(currentIndex == 4){
                (new TextView((Context) songTitle)).setText("Sawari Bhavani Chauka madhi.mp3");
            }
        }

    }
