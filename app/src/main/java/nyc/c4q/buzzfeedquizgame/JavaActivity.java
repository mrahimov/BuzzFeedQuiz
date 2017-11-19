package nyc.c4q.buzzfeedquizgame;

/**
 * Created by muridjonrahimov on 11/16/17.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class JavaActivity extends AppCompatActivity {

    private TextView javaScoreView, javaQuestion;
    private ImageView javaImageView;
    private Button javaTrueButton, javaFalseButton;
    private boolean javaAnswer;
    private int javaScore = 0;
    private int javaQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_quiz);

        javaScoreView = (TextView) findViewById(R.id.points);
        javaImageView = (ImageView) findViewById(R.id.imageView);
        javaQuestion = (TextView) findViewById(R.id.question);
        javaTrueButton = (Button) findViewById(R.id.trueButton);
        javaFalseButton = (Button) findViewById(R.id.falseButton);

        updateQuestion();

        // logic for True button
        javaTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (javaAnswer == true) {
                    javaScore++;
                    updateScore(javaScore);

                    if (javaQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(JavaActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", javaScore);
                        i.putExtras(bundle);
                        JavaActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (javaQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(JavaActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", javaScore);
                        i.putExtras(bundle);
                        JavaActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

        //logic for False button
        javaFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (javaAnswer == false) {
                    javaScore++;
                    updateScore(javaScore);

                    if (javaQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(JavaActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", javaScore);
                        i.putExtras(bundle);
                        JavaActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                } else {
                    if (javaQuestionNumber == QuizBook.questions.length) {
                        Intent i = new Intent(JavaActivity.this, ResultsActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("finalScore", javaScore);
                        i.putExtras(bundle);
                        JavaActivity.this.finish();
                        startActivity(i);
                    } else {
                        updateQuestion();
                    }
                }
            }
        });

    }
    private void updateQuestion() {

        javaImageView.setImageResource(QuizBook.images[javaQuestionNumber]);
        javaQuestion.setText(QuizBook.questions[javaQuestionNumber]);
        javaAnswer = QuizBook.answers[javaQuestionNumber];
        javaQuestionNumber++;
    }

    private void updateScore(int point) {
        javaScoreView.setText("" + javaScore);
    }

    public void clickExit(View view) {
        askToClose();
    }


    //cool function to ask user are he really wanna quit.
    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(JavaActivity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes I am a loser!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("No I am a cool guy!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}