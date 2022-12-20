package com.example.music_player_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private MediaPlayer mediaPlayer;
    ImageView play;
    ImageView skipNext;
    ImageView skipPrev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.play);
        seekBar = findViewById(R.id.seekBar);
        skipNext = findViewById(R.id.skipNext);

        mediaPlayer = MediaPlayer.create(this,R.raw.excuse);
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
    }