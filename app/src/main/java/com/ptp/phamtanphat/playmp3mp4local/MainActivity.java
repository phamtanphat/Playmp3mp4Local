package com.ptp.phamtanphat.playmp3mp4local;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    Button btnPlaymp3,btnPlaymp4;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnPlaymp3 = findViewById(R.id.buttonPlaymp3);
        btnPlaymp4 = findViewById(R.id.buttonPlaymp4);
        videoView = findViewById(R.id.videoview);

        btnPlaymp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.duyenminhlo);
//                mediaPlayer.start();
//                mediaPlayer.
//                Log.d("BBB",Tinhtime(mediaPlayer.getDuration()) );
                PlayNhacMp3("http://khoapham.vn/download/vietnamoi.mp3");
            }
        });
        btnPlaymp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.thaylayeuthuong));
//                videoView.start();
//
//                MediaController mediaController = new MediaController(MainActivity.this);
//                mediaController.setMediaPlayer(videoView);
//                videoView.setMediaController(mediaController);
                videoView.setVideoURI(Uri.parse("https://zmp3-mv-mcloud-bf-s7.zadn.vn/jxlJuU0gY_s/1c7b56f5d0b039ee60a1/058b7e344971a02ff960/480/Duyen-Minh-Lo.mp4?authen=exp=1535194177~acl=/jxlJuU0gY_s/*~hmac=6ad81c1015dba992798494201d9fcf19"));
                videoView.start();

                MediaController mediaController = new MediaController(MainActivity.this);
                mediaController.setMediaPlayer(videoView);
                videoView.setMediaController(mediaController);
            }
        });
    }
    private String Tinhtime(int time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm : ss");
        return simpleDateFormat.format(time);
    }
    public void PlayNhacMp3(String url){
        //url = "http://khoapham.vn/download/vietnamoi.mp3";
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
