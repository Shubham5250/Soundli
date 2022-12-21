package com.example.music_player_app;





import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    MediaPlayer mediaPlayer;
    ImageView play;
    ImageView imageView3;
    ImageView skipNext;
    TextView textView2;
    ImageView skipPrev;


    int currentIndex = 0;


    //Arraylist to store our songs
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing the values
        play = findViewById(R.id.play);
        seekBar = findViewById(R.id.seekBar);
        skipNext = findViewById(R.id.skipNext);
        skipPrev = findViewById(R.id.skipPrev);
        textView2 = findViewById(R.id.textView2);
        imageView3 = findViewById(R.id.imageView3);

        final ArrayList<Integer> songs = new ArrayList<>();
        songs.add(0, R.raw.yugat);
        songs.add(1, R.raw.shivba);
        songs.add(2, R.raw.shwasat);
        songs.add(3,R.raw.maaybhavani);
        songs.add(4,R.raw.shoorveer);
        songs.add(5,R.raw.ranishoor);
        //songs.add(3, R.raw.insane);
        //songs.add(4, R.raw.excuse);


        //initializing the mediaPlayer
        mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));


        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                seekBar.setMax(mediaPlayer.getDuration());


                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    play.setImageResource(R.drawable.ic_baseline_play_circle_24);
                } else {
                    mediaPlayer.start();
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                }

                songNames();
            }

            private void songNames() {
                if (currentIndex == 0) {
                    textView2.setText("Yugat Mandali");
                    imageView3.setImageResource(R.drawable.yugaticon);

                }
                if (currentIndex == 1) {
                    textView2.setText("Shivba Raja");
                    imageView3.setImageResource(R.drawable.shivbaraja);
                }
                if (currentIndex == 2) {
                    textView2.setText("Shwasat Raja Ra Dhyasat Raja");
                    imageView3.setImageResource(R.drawable.shwasatraja);
                }
                if (currentIndex == 3) {
                    textView2.setText("Maay Bhavani");
                    imageView3.setImageResource(R.drawable.maaybhavani);
                }
                if (currentIndex == 4) {
                    textView2.setText("Shoorveer 3");
                    imageView3.setImageResource(R.drawable.shoorver);
                }
                if (currentIndex == 5) {
                    textView2.setText("Rani Nighata Shoor");
                    imageView3.setImageResource(R.drawable.ranishoor);
                }

            }
        });

        skipNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_24);


                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }


                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
                songNames();
            }

            private void songNames() {
                if (currentIndex == 0) {
                    textView2.setText("Yugat Mandali");
                    imageView3.setImageResource(R.drawable.yugaticon);

                }
                if (currentIndex == 1) {
                    textView2.setText("Shivba Raja");
                    imageView3.setImageResource(R.drawable.shivbaraja);
                }
                if (currentIndex == 2) {
                    textView2.setText("Shwasat Raja Ra Dhyasat Raja");
                    imageView3.setImageResource(R.drawable.shwasatraja);
                }
                if (currentIndex == 3) {
                    textView2.setText("Maay Bhavani");
                    imageView3.setImageResource(R.drawable.maaybhavani);
                }
                if (currentIndex == 4) {
                    textView2.setText("Shoorveer");
                    imageView3.setImageResource(R.drawable.shoorver);
                }
                if (currentIndex == 5) {
                    textView2.setText("Rani Nighata Shoor");
                    imageView3.setImageResource(R.drawable.ranishoor);
                }

            }
        });

        skipPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    play.setImageResource(R.drawable.ic_baseline_pause_circle_24);
                    imageView3.setImageResource(R.drawable.shwasatraja);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }


                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }

                mediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mediaPlayer.start();
                songNames();
            }

            private void songNames() {
                if (currentIndex == 0) {
                    textView2.setText("Yugat Mandali");
                    imageView3.setImageResource(R.drawable.yugaticon);

                }
                if (currentIndex == 1) {
                    textView2.setText("Shivba Raja");
                    imageView3.setImageResource(R.drawable.shivbaraja);
                }
                if (currentIndex == 2) {
                    textView2.setText("Shwasat raja ra dhyasat raja");
                    imageView3.setImageResource(R.drawable.shwasatraja);
                }
                if (currentIndex == 3) {
                    textView2.setText("Maay Bhavani");
                    imageView3.setImageResource(R.drawable.maaybhavani);
                }
                if (currentIndex == 4) {
                    textView2.setText("Shoorveer");
                    imageView3.setImageResource(R.drawable.shoorver);
                }
                if (currentIndex == 5) {
                    textView2.setText("Rani Nighata Shoor");
                    imageView3.setImageResource(R.drawable.ranishoor);
                }

            }

        });


        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(mediaPlayer.getDuration());
                mediaPlayer.start();
            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        },0,1000);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    seekBar.setProgress(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}





