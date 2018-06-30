package com.example.android.quiz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //score holds the number of correct answers by the player
    int score=0;
    //score holds the number of wrong answers by the player
    int fails=0;
    //displays the right answers to the questions the player fails
    String missedQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //passes in the xml as an input
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view){
        //score holds the summary of quiz
        String quizResult;
        //gets the name of the player
        EditText editText= (EditText) findViewById(R.id.name_of_player);
        String name= editText.getText().toString();
        //tests the answers the player provided against the right answers either clicked or entered as text from questions 1-8
        CheckBox question_one= (CheckBox) findViewById(R.id.q1Option3);
        boolean answerOne= question_one.isChecked();
            if (answerOne){
                score++;
            }
            else {
                missedQuestions= "The answer to Question 1 is: "+ getString(R.string.Q1option3);
                fails++;
            }

        CheckBox question_two= (CheckBox) findViewById(R.id.q2Option3);
        boolean answerTwo= question_two.isChecked();
            if (answerTwo){
                score++;
            }
            else {
                missedQuestions+= "\n"+ "The answer to Question 2 is: "+ getString(R.string.Q2option3);
                fails++;
            }
        EditText editQuestionThree= (EditText) findViewById(R.id.q3Option);
        String answerThree= editQuestionThree.getText().toString();
            if (answerThree.equals("Patmos") || answerThree.equals("PATMOS") || answerThree.equals("patmos")){
                score++;
            }
            else{
                missedQuestions+= "\n"+ "The answer to Question 3 is: PATMOS";
                fails++;
            }
        CheckBox question_four= (CheckBox) findViewById(R.id.q4Option2);
        boolean answerFour= question_four.isChecked();
            if (answerFour){
                score++;
            }
            else {
                missedQuestions+= "\n"+ "The answer to Question 4 is: "+ getString(R.string.Q4option2);
                fails++;
            }
        EditText editQuestionFive= (EditText) findViewById(R.id.q5Option);
        String answerFive= editQuestionFive.getText().toString();
            if (answerFive.equals("969")){
                score++;
            }
            else{
                missedQuestions+= "\n"+ "The answer to Question 5 is: 969";
                fails++;
            }
        CheckBox question_six= (CheckBox) findViewById(R.id.q6Option3);
        boolean answerSix= question_six.isChecked();
            if (answerSix){
                score++;
            }
            else {
                missedQuestions+= "\n"+ "The answer to Question 6 is: "+ getString(R.string.Q6option3);
                fails++;
            }
        CheckBox question_seven= (CheckBox) findViewById(R.id.q7Option1);
        boolean answerSeven= question_seven.isChecked();
            if (answerSeven){
                score++;
            }
            else {
                missedQuestions+= "\n"+ "The answer to Question 7 is: "+ getString(R.string.Q7option1);
                fails++;
            }
        EditText editQuestionEight= (EditText) findViewById(R.id.q8Option);
        String answerEight= editQuestionEight.getText().toString();
            if (answerEight.equals("Death") || answerEight.equals("DEATH") || answerEight.equals("death")){
                score++;
            }
            else{
                missedQuestions+= "\n"+ "The answer to Question 8 is: DEATH";
                fails++;
            }
        //determines the result of the quiz and displayes a unique toast message to player
        if (score==8){
            quizResult= "You are a bible pro! "+ name;
            quizResult+= "\n" + "You scored: "+ score;
            Toast.makeText(this, quizResult, Toast.LENGTH_LONG).show();

        }
        else if (score >=5 && score<8){
            quizResult= "Nice play "+ name;
            quizResult+= "\n" + "You scored: "+ score;
            quizResult+= "\n" + "You missed: "+ fails;
            quizResult+= "\n"+ missedQuestions;
            Toast.makeText(this, quizResult, Toast.LENGTH_LONG).show();
        }
        else{
            quizResult= "You can do better "+ name;
            quizResult+= "\n" + "You scored: "+ score;
            quizResult+= "\n" + "You missed: "+ fails;
            quizResult+= "\n"+ missedQuestions;
            Toast.makeText(this, quizResult, Toast.LENGTH_LONG).show();
        }
        //initialize all params back to zero or null for String
        score=0; fails=0;  missedQuestions=" ";

    }

}
