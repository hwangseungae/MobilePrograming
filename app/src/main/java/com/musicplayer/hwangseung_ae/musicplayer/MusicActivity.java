package com.musicplayer.hwangseung_ae.musicplayer;


//import android.content.Intent;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//
//public class MusicActivity extends AppCompatActivity {
//    private ListView listView;
//    public static ArrayList<MusicDto> list;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_music);
//        getMusicList(); // 디바이스 안에 있는 mp3 파일 리스트를 조회하여 LIst를 만듭니다.
//        listView = (ListView)findViewById(R.id.listview);
//        MyAdapter adapter = new MyAdapter(this,list);
//        listView.setAdapter(adapter);
//
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MusicActivity.this,PlayingActivity.class);
//                intent.putExtra("position",position);
//                intent.putExtra("playlist",list);
//                startActivity(intent);
//            }
//        });
//    }
//
//
//    public  void getMusicList(){
//        list = new ArrayList<>();
//        //가져오고 싶은 컬럼 명을 나열합니다. 음악의 아이디, 앰블럼 아이디, 제목, 아스티스트 정보를 가져옵니다.
//        String[] projection = {MediaStore.Audio.Media._ID,
//                MediaStore.Audio.Media._ID,
//                MediaStore.Audio.Media.ALBUM_ID,
//                MediaStore.Audio.Media.TITLE,
//                MediaStore.Audio.Media.ALBUM,
//                MediaStore.Audio.Media.ARTIST,
//                MediaStore.Audio.Media.DATA
//        };
//
//        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
//                projection, null, null, null);
//
//        while(cursor.moveToNext()){
//            MusicDto musicDto = new MusicDto();
//            musicDto.setId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA)));
//            musicDto.setId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
//            musicDto.setAlbumId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)));
//            musicDto.setAlbumId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)));
//            musicDto.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
//            musicDto.setArtist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
//            list.add(musicDto);
//        }
//        cursor.close();
//    }
//}


import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MusicActivity extends Activity {
    MediaPlayer mp;

    // 시작버튼
    Button startButton;
    //종료버튼
    Button stopButton;

    int playstopBtns[] = {R.id.startme, R.id.stopme, R.id.startbackwalk, R.id.stopbackwalk, R.id.startcry, R.id.stopcry,
            R.id.startcure, R.id.stopcure, R.id.startluv, R.id.stopluv, R.id.startrelove, R.id.stoprelove};

    int resMp3[] = {R.raw.mino, R.raw.twice, R.raw.ben, R.raw.shaun, R.raw.heize, R.raw.jennie};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

//        for (int btns : playstopBtns) {
//            Button btn = (Button) findViewById(btns);
//            btn.setOnClickListener(startButton);
//        }
        startButton = findViewById(R.id.startme);
        stopButton = findViewById(R.id.stopme);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MediaPlayer 객체 할당
                mp = MediaPlayer.create(MusicActivity.this, R.raw.mino);
                mp.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 정지버튼
                mp.stop();
                // 초기화
                mp.reset();
            }
        });
    }


}

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
//}