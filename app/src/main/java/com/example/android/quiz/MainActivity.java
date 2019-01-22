package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

//This app is a Harry Potter quiz

public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Check the answers and set the score
    public void checkAnswers(View v) {

        //Get all checkboxes from question 1
        CheckBox a1question1 = (CheckBox) findViewById(R.id.a1question1);
        CheckBox a2question1 = (CheckBox) findViewById(R.id.a2question1);
        CheckBox a3question1 = (CheckBox) findViewById(R.id.a3question1);
        CheckBox a4question1 = (CheckBox) findViewById(R.id.a4question1);
        CheckBox a5question1 = (CheckBox) findViewById(R.id.a5question1);
        CheckBox a6question1 = (CheckBox) findViewById(R.id.a6question1);

        //Check if there's at least one CheckBox checked
        if ((a1question1.isChecked() == false) && (a2question1.isChecked() == false) && (a3question1.isChecked() == false) && (a4question1.isChecked() == false) && (a5question1.isChecked() == false) && (a6question1.isChecked() == false)) {
            Toast.makeText(this, getString(R.string.error1), Toast.LENGTH_SHORT).show();
            return;
        }

        //Add 1 point if CheckBoxes are correct
        if (a1question1.isChecked() && a3question1.isChecked() && a4question1.isChecked() && a6question1.isChecked() && !(a2question1.isChecked()) && !(a5question1.isChecked())) {
            score++;
        }

        //Get question2 value
        RadioGroup question2 = (RadioGroup) findViewById(R.id.question2);

        //Get the id from the selected RadioButton
        int selectedId = question2.getCheckedRadioButtonId();

        //Check if there's a RadioButton checked on the RadioGroup
        if (selectedId == -1) {
            Toast.makeText(this, getString(R.string.error1), Toast.LENGTH_SHORT).show();
            return;
        }

        //Get the RadioButton checked
        RadioButton aQuestion2 = (RadioButton) findViewById(selectedId);

        //Get the value from the RadioButton
        String answerQ2 = aQuestion2.getText().toString();

        //Add 1 point if question 2 is correct
        if (answerQ2 == getString(R.string.a3question2)) {
            score++;
        }

        //Get question3
        EditText question3 = (EditText) findViewById(R.id.question3);
        String aQ3 = question3.getText().toString();

        //Check if EditBox is empty
        if (aQ3.matches("")) {
            Toast.makeText(this, getString(R.string.error1), Toast.LENGTH_SHORT).show();
            return;
        }

        //Add 1 point if question3 is correct
        if (aQ3.toLowerCase().matches(getString(R.string.aQ3).toLowerCase())) {
            score++;
        }

        //Get question4, same process as question1
        CheckBox a1question4 = (CheckBox) findViewById(R.id.a1question4);
        CheckBox a2question4 = (CheckBox) findViewById(R.id.a2question4);
        CheckBox a3question4 = (CheckBox) findViewById(R.id.a3question4);
        CheckBox a4question4 = (CheckBox) findViewById(R.id.a4question4);
        CheckBox a5question4 = (CheckBox) findViewById(R.id.a5question4);

        if ((a1question4.isChecked() == false) && (a2question4.isChecked() == false) && (a3question4.isChecked() == false) && (a4question4.isChecked() == false) && (a5question4.isChecked() == false)) {
            Toast.makeText(this, getString(R.string.error1), Toast.LENGTH_SHORT).show();
            return;
        }

        if (a5question4.isChecked() && a2question4.isChecked() && a3question4.isChecked() && !(a1question4.isChecked()) && !(a4question4.isChecked())) {
            score++;
        }

        //Get question5, same process as question2
        RadioGroup question5 = (RadioGroup) findViewById(R.id.question5);

        int selectedId2 = question5.getCheckedRadioButtonId();

        if (selectedId2 == -1) {
            Toast.makeText(this, getString(R.string.error1), Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton aQuestion5 = (RadioButton) findViewById(selectedId2);
        String answerQ5 = aQuestion5.getText().toString();

        if (answerQ5 == getString(R.string.a2question5)) {
            score++;
        }

        Toast.makeText(this, getString(R.string.result, score), Toast.LENGTH_SHORT).show();
        score = 0;
    }

    //This method reset the quiz
    public void reset(View v) {
        score = 0;
        setContentView(R.layout.activity_main);
    }

}
