package com.musicplayer.hwangseung_ae.musicplayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        main = (FrameLayout) findViewById(R.id.fragment_goto);
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
        transaction.replace(R.id.activity_user, list);
        transaction.commit();
    }


    @Override
    public void goDetail(){
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_goto, detail);
        Fragment mFragment = getSupportFragmentManager().findFragmentById(R.id.activity_user);
        transaction.remove(mFragment);
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

