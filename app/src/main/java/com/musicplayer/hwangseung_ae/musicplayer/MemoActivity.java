//package com.musicplayer.hwangseung_ae.musicplayer;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class MemoActivity extends AppCompatActivity {
//
//    EditText mMenoEdit = null;
//    TextFileManager mTextFileManager = new TextFileManager(this);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_memo);
//
//        mMenoEdit = (EditText)findViewById(R.id.memo_edit);
//    }
//
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.load_btn: {
//                String memoData = mTextFileManager.load();
//                mMenoEdit.setText(memoData);
//
//                Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();
//                break;
//            }
//
//            case R.id.save_btn: {
//                String memoData = mMenoEdit.getText().toString();
//                mTextFileManager.save(memoData);
//                mMenoEdit.setText("");
//
//                Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
//                break;
//            }
//
//            case R.id.delete_btn: {
//                mTextFileManager.delete();
//                mMenoEdit.setText("");
//                Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
//
//            }
//        }
//    }
//}
