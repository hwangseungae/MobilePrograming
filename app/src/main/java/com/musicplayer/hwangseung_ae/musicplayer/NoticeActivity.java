package com.musicplayer.hwangseung_ae.musicplayer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show();
            }
        });
    }

    void show()
    {
        final List<String> ListItems = new ArrayList<>();
        ListItems.add("MadeBy : Hwang Seung Ae");
        ListItems.add("Production date : Dec.18.2018");
        ListItems.add("Suggestions : hsa@gmail.com");
        ListItems.add("Thanks You");
        final CharSequence[] items =  ListItems.toArray(new String[ ListItems.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("INFO");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int pos) {
                String selectedText = items[pos].toString();
                Toast.makeText(NoticeActivity.this, selectedText, Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

}