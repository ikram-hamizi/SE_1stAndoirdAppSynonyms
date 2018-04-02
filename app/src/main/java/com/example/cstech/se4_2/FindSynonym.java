package com.example.cstech.se4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FindSynonym extends AppCompatActivity {

    private String RECEIVED_WORD;
    private String RECEIVED_SYN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_syn);

        Intent intent = getIntent();
        RECEIVED_WORD = intent.getStringExtra(MainActivity.EXTRA_WORD);
        RECEIVED_SYN = intent.getStringExtra(MainActivity.EXTRA_SYN);

        TextView tv_word = (TextView) findViewById(R.id.tv_word);
        tv_word.setText(RECEIVED_WORD);

        TextView tv_syn = (TextView) findViewById(R.id.tv_syn);
        tv_syn.setText(RECEIVED_SYN);
    }
}