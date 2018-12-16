package com.musicplayer.hwangseung_ae.musicplayer;


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;


public class MusicActivity extends Activity {

    ImageButton btn1, btn2, btn3;
    MediaPlayer mp;
    SeekBar seekBar;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        btn1 = (ImageButton)findViewById(R.id.button1);
        btn2 = (ImageButton)findViewById(R.id.button2);
        btn3 = (ImageButton)findViewById(R.id.button3);

        text = (TextView)findViewById(R.id.text1);


        mp = MediaPlayer.create(MusicActivity.this, R.raw.ben);

        seekBar = (SeekBar)findViewById(R.id.playbar);
        seekBar.setVisibility(ProgressBar.VISIBLE);
        seekBar.setMax(mp.getDuration());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mp.seekTo(progress);
                }
                int m = progress / 60000;
                int s = (progress % 60000) / 1000;
                String strTime = String.format("%02d:%02d", m, s);
                text.setText(strTime);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                Thread();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                try
                {
                    mp.prepare();
                }
                catch(IOException ie)
                {
                    ie.printStackTrace();
                }
                mp.seekTo(0);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });


    }

    public void Thread(){
        Runnable task = new Runnable(){


            public void run(){
                // 음악이 재생중일때
                while(mp.isPlaying()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    seekBar.setProgress(mp.getCurrentPosition());
                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

}


//
//
//    int playstopBtns[] = {R.id.startme, R.id.stopme, R.id.startbackwalk, R.id.stopbackwalk, R.id.startcry, R.id.stopcry,
//            R.id.startcure, R.id.stopcure, R.id.startluv, R.id.stopluv, R.id.startrelove, R.id.stoprelove};
//
//    int resMp3[] = {R.raw.mino, R.raw.twice, R.raw.ben, R.raw.shaun, R.raw.heize, R.raw.jennie};
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_music);
//
//        for (int btns : playstopBtns) {
//            Button btn = (Button) findViewById(btns);
//            btn.setOnClickListener(clickListener);
//        }
//
//
//}
//
//    View.OnClickListener clickListener = new View.OnClickListener() {
//
//        public void onClick(View v) {
//
//            switch (v.getId()) {
//
//                case R.id.startme:
//                    Play(0); break;
//                case R.id.startbackwalk:
//                    Play(1); break;
//                case R.id.startcry:
//                    Play(2); break;
//                case R.id.startcure:
//                    Play(3); break;
//                case R.id.startluv:
//                    Play(4); break;
//                case R.id.startrelove:
//                    Play(5); break;
//                default :
//                    Stop();
//            }
//
//        }
//
//    };
//
//
//    private void Play(int selNo){
//
//        Stop();
//
//        mp = MediaPlayer.create(MusicActivity.this, resMp3[selNo]);
//        mp.start();
//    }
//
//    private void Stop(){
//
//        if(mp!=null){
//            mp.stop();
//            mp = null;
//        }
//
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Stop();
//    }
//
