package com.example.android.quiz_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        RadioGroup question_one= (RadioGroup) findViewById(R.id.radioQ1);
        String answerOne= ((RadioButton) findViewById(question_one.getCheckedRadioButtonId())).getText().toString();
        String answerA=getString(R.string.Q1option3);
            if (answerOne==answerA ){
                score++;
            }
            else {
                missedQuestions= "The answer to Question 1 is: "+ getString(R.string.Q1option3);
                fails++;
            }

        RadioGroup question_two= (RadioGroup) findViewById(R.id.radioQ2);
        String answerTwo= ((RadioButton) findViewById(question_two.getCheckedRadioButtonId())).getText().toString();
        String answerB=getString(R.string.Q1option3);
            if (answerTwo == answerB){
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
        CheckBox question_fourA= (CheckBox) findViewById(R.id.q4Option2);
        CheckBox question_fourB= (CheckBox) findViewById(R.id.q4Option3);
        CheckBox question_fourC= (CheckBox) findViewById(R.id.q4Option1);
        CheckBox question_fourD= (CheckBox) findViewById(R.id.q4Option4);
        boolean answerFourA= question_fourA.isChecked();
        boolean answerFourB= question_fourB.isChecked();
        boolean answerFourC= question_fourC.isChecked();
        boolean answerFourD= question_fourD.isChecked();
        //ensures that the player is only awarded a score for choosing only the two correct options
            if (answerFourA == true && answerFourB == true && answerFourC == false && answerFourD == false ){
                score++;
            }
            else  {
                missedQuestions+= "\n"+ "The answer to Question 4 is: "+ getString(R.string.Q4option2) + " & " +getString(R.string.Q4option3);
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
        CheckBox question_sixA= (CheckBox) findViewById(R.id.q6Option2);
        boolean answerSixA= question_sixA.isChecked();
        CheckBox question_sixB= (CheckBox) findViewById(R.id.q6Option3);
        boolean answerSixB= question_sixB.isChecked();
        CheckBox question_sixC= (CheckBox) findViewById(R.id.q6Option1);
        boolean answerSixC= question_sixC.isChecked();
        CheckBox question_sixD= (CheckBox) findViewById(R.id.q6Option4);
        boolean answerSixD= question_sixD.isChecked();
        //ensures that the player is only awarded a score for choosing only the two correct options
            if (answerSixA == true && answerSixB == true && answerSixC == false && answerSixD == false){
                score++;
            }
            else {
                missedQuestions+= "\n"+ "The answer to Question 6 is: "+ getString(R.string.Q6option2) + " & " + getString(R.string.Q6option3);
                fails++;
            }
        RadioGroup question_seven= (RadioGroup) findViewById(R.id.radioQ7);
        String answerSeven= ((RadioButton) findViewById(question_seven.getCheckedRadioButtonId())).getText().toString();
        String answerC=getString(R.string.Q7option1);
            if (answerSeven== answerC){
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
