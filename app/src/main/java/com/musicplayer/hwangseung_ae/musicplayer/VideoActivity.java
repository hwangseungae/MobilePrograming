package com.musicplayer.hwangseung_ae.musicplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class VideoActivity extends AppCompatActivity {

    ImageButton but1;
    ImageButton but2;
    ImageButton but3;
    ImageButton but4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        but1 = (ImageButton) findViewById(R.id.naver);
        but2 = (ImageButton) findViewById(R.id.daum);
        but3 = (ImageButton) findViewById(R.id.youtube);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.daum.net"));
                startActivity(intent);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.youtube.com"));
                startActivity(intent);
            }
        });
    }
}

