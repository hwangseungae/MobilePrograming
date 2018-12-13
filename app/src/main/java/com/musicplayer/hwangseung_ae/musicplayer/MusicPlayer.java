package com.musicplayer.hwangseung_ae.musicplayer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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
                "가수 - 제목", "0집 타이틀곡 노래 추가") ;
        // 두 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "가수 - 젬목", "0집 타이틀곡 노래 추가") ;
        // 세 번째 아이템 추가.
        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.notice_img),
                "Update", "000 내용 수정 및 업데이트") ;


        // 위에서 생성한 listview에 클릭 이벤트 핸들러 정의.
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get item
                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position) ;

                String titleStr = item.getTitle() ;
                String descStr = item.getDesc() ;
                Drawable iconDrawable = item.getIcon() ;

                // TODO : use item data.
            }
        }) ;



        final ImageButton musicButton = (ImageButton) findViewById(R.id.musicButton);
        final ImageButton videoButton = (ImageButton) findViewById(R.id.videoButton);
        final ImageButton myButton =  (ImageButton) findViewById(R.id.myButton);
        final LinearLayout newsong = (LinearLayout) findViewById(R.id.newsong);

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsong.setVisibility(View.GONE);
                musicButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                videoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                Intent intent = new Intent(getApplicationContext(), MusicActivity.class);
                startActivity(intent);
            }
        });


        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newsong.setVisibility(View.GONE);
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
                newsong.setVisibility(View.GONE);
                musicButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                videoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myButton.setBackgroundColor(getResources().getColor(R.color.colorAccent));

                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(intent);
            }
        });
    }
}
