package com.musicplayer.hwangseung_ae.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final ImageButton musicButton = (ImageButton) findViewById(R.id.plus);

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                newsong.setVisibility(View.GONE);
//                musicButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
//                videoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                myButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                startActivity(intent);
            }
        });

    }
}
