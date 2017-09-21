package com.example.android.quizproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void CheckAnswers(View v) {
        int numCorrectAnswers = 0;

        Boolean rbq1c = ((RadioButton) findViewById(R.id.radioButtonQ1c)).isChecked();
        Boolean rbq2a = ((RadioButton) findViewById(R.id.radioButtonQ2a)).isChecked();

        Boolean cbq3a = ((CheckBox) findViewById(R.id.checkBoxQ3a)).isChecked();
        Boolean cbq3c = ((CheckBox) findViewById(R.id.checkBoxQ3c)).isChecked();
        Boolean cbq3d = ((CheckBox) findViewById(R.id.checkBoxQ3d)).isChecked();
        Boolean cbq3b = ((CheckBox) findViewById(R.id.checkBoxQ3b)).isChecked();

        String county = ((EditText) findViewById(R.id.editTextQ4)).getText().toString();

        if (rbq1c) numCorrectAnswers++;

        if (rbq2a) numCorrectAnswers++;

        if ((cbq3a && cbq3c && cbq3d) && (!cbq3b)) numCorrectAnswers++;

        if (county.trim().compareToIgnoreCase("alameda") == 0) numCorrectAnswers++;

        Context context = getApplicationContext();
        CharSequence text;

        if (numCorrectAnswers == 1)
            text = "You got " + numCorrectAnswers + " answer correct out of four questions.";
        else
            text = "You got " + numCorrectAnswers + " answers correct out of four questions.";
        Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        toast.show();
    }
}
