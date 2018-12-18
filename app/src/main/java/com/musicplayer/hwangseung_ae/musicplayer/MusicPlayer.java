package com.musicplayer.hwangseung_ae.musicplayer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;


public class MusicPlayer extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);


        ListView listview ;
        ListViewAdapter adapter;

        // Adapter 생성
        adapter = new ListViewAdapter() ;

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.musicList);
        listview.setAdapter(adapter);

        // 첫 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Ben - 180도", " # Ben 신곡 180도 추가 #", "2018.12.17") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "MINO - 아낙네", "# 송민호 신곡 아낙네 추가 #", "2018.12.17") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Update", "버튼 클릭시 공지 사라지는 오류 수정", "2018.12.15") ;
        // 네 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Update", "전반적인 디자인 수정", "2018.12.14") ;
        // 다섯 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Notice!", "원하는 노래 메모장에 기록", "2018.12.12") ;

        // 여섯 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Notice", "어플이름 추천", "2018.12.12") ;


        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                String dateStr = item.getDate() ;
                Drawable iconDrawable = item.getIcon() ;

                // TODO : use item data.
            }
        }) ;



        final ImageButton musicButton = (ImageButton) findViewById(R.id.musicButton);
        final ImageButton videoButton = (ImageButton) findViewById(R.id.videoButton);
        final ImageButton myButton =  (ImageButton) findViewById(R.id.myButton);
        final ImageButton settingButton =  (ImageButton) findViewById(R.id.settingButton);
        final ImageButton notice =  (ImageButton) findViewById(R.id.notice);


        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                videoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                Intent intent = new Intent(getApplicationContext(), MusicListActivity.class);
                startActivity(intent);
            }
        });


        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                videoButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                myButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                startActivity(intent);
            }
        });


        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                musicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                videoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(intent);
            }
        });

        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
            }
        });


        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), NoticeActivity.class);
                startActivity(intent);
            }
        });
    }
}
