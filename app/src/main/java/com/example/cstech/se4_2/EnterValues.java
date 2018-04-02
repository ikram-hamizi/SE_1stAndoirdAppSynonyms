package com.example.cstech.se4_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EnterValues extends AppCompatActivity {

    private String RECEIVED_WORD; //onCreate will assign a String to it
    private String ASSIGNED_SYN;
    private DBHelper helper = new DBHelper(this);
    private  WordSynTuple wst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_values);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        RECEIVED_WORD = intent.getStringExtra(MainActivity.EXTRA_WORD);

        // Capture the layout's PlainText and set the string as its text
        EditText et_word = (EditText) findViewById(R.id.EditText_word);
        et_word.setText(RECEIVED_WORD);
    }

    //Action - Submit
    public void submitNewWord(View view)
    {

        EditText et_syn = (EditText) findViewById(R.id.EditText_syn);
        ASSIGNED_SYN = et_syn.getText().toString();

        wst = new WordSynTuple(RECEIVED_WORD, ASSIGNED_SYN);

        if(ASSIGNED_SYN.length()!=0 || RECEIVED_WORD.length()!=0)
        {
            Toast error = Toast.makeText(EnterValues.this, "Field is empty, you cannot submit.", Toast.LENGTH_SHORT);
            error.show();
        }
        else if(!helper.wordDoesExist(wst))
        {
            helper.addWordSyn(wst); //If w/s tuple does not exist in DB
            helper.rowAddedToast(EnterValues.this).show();
        }
        else
        {
            Toast already_exists_pop_up = Toast.makeText(EnterValues.this, "Word already exists, try another one", Toast.LENGTH_SHORT);
            already_exists_pop_up.show();
        }
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
