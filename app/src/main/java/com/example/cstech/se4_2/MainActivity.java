package com.example.cstech.se4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_WORD = "com.example.cstech.se4_2.WORD";
    private DBHelper myDBhelper = new DBHelper(this);
    public static final String EXTRA_SYN = "com.example.cstech.se4_2.SYN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Action 1: Find Synonym
    public void findSynonymIntent(View view){
        EditText edit_Text = (EditText) findViewById(R.id.editText); //WORD EditText
        String word = edit_Text.getText().toString(); //STRING FROM EDIT_TEXT

        String FOUND_SYN = myDBhelper.searchSyn(word); //SEARCH

        Intent i = new Intent(this, FindSynonym.class);
        i.putExtra(EXTRA_WORD, word);
        i.putExtra(EXTRA_SYN, FOUND_SYN);
        startActivity(i);
    }

    //Action 2: Enter Values
    public void enterValueIntent(View view){

        EditText edit_Text = (EditText) findViewById(R.id.editText); //WORD EditText
        String word = edit_Text.getText().toString(); //STRING FROM EDIT_TEXT

        Intent intent = new Intent(this, EnterValues.class);
        intent.putExtra(EXTRA_WORD, word);
        startActivity(intent);
    }
}
