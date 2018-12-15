package com.musicplayer.hwangseung_ae.musicplayer;

//public class UserActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_user);
//
//        final ImageButton musicButton = (ImageButton) findViewById(R.id.plus);
//
//        musicButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity implements ListInterface, DetailInterface{
    private static final String TAG="MemoMain";
    ListFragment list;
    MemoFragment detail;

    FrameLayout main;
    FragmentManager manager;

    DBHelper dbHelper;

    List<Memo> datas = new ArrayList<>();
    Dao<Memo, Integer> memoDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        list = ListFragment.newInstance(1);
        detail = MemoFragment.newInstance();
        main = (FrameLayout) findViewById(R.id.activity_user);
        manager = getSupportFragmentManager();
        try {
            loadData();
        }catch (SQLException e){
            Log.e(TAG, e+"============================");
        }

        list.setData(datas);
        setList();
    }

    public void loadData() throws SQLException {
        dbHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        memoDao = dbHelper.getMemoDao();
        datas = memoDao.queryForAll();
        Log.e(TAG, "data size============================"+datas.size());
    }

    // 목록 프래그먼트 FrameLayout 에 add
    private void setList(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_user, list);
        transaction.commit();
    }

    @Override
    public void goDetail(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.activity_user, detail);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goDetail(int position) {

    }

    @Override
    public void backToList() {
        super.onBackPressed();
    }

    @Override
    public void saveToList(Memo memo) throws SQLException {

        Log.i(TAG,"memo============================================"+memo.getMemo());

        dbHelper = OpenHelperManager.getHelper(this, DBHelper.class);
        memoDao = dbHelper.getMemoDao();
        memoDao.create(memo);
        loadData();
        list.setData(datas);
        super.onBackPressed();
        list.refreshAdapter();
    }
}

