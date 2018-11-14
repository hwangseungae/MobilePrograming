package com.musicplayer.hwangseung_ae.musicplayer;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button MusicButton = (Button) findViewById(R.id.MusicButton);
        final Button MvButton = (Button) findViewById(R.id.MvButton);
        final Button MyButton = (Button) findViewById(R.id.MyButton);
        //해당 fragment를 눌렀을 때 화면이 바뀌는 layout
        final LinearLayout chart = (LinearLayout) findViewById(R.id.chart);

        MusicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 실시간차트가 보이지 않도록
                chart.setVisibility(View.GONE);
                MusicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                MyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MvButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MusicFragment());
                fragmentTransaction.commit();
            }
        });

        MvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 실시간차트가 보이지 않도록
                // 실시간차트가 보이지 않도록
                chart.setVisibility(View.GONE);
                MusicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MvButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MvFragment());
                fragmentTransaction.commit();
            }
        });

        MyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 실시간차트가 보이지 않도록
                chart.setVisibility(View.GONE);
                MusicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                MyButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                MvButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MyFragment());
                fragmentTransaction.commit();
            }
        });
    }
}
