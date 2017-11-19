package nyc.c4q.buzzfeedquizgame;

/**
 * Created by muridjonrahimov on 11/16/17.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView javaGrade, javaFinalScore;
    Button javaRetryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        javaGrade = (TextView)findViewById(R.id.grade);
        javaFinalScore = (TextView)findViewById(R.id.outOf);
        javaRetryButton = (Button)findViewById(R.id.retry);


        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("finalScore");

        javaFinalScore.setText("You scored " + score + " out of " + QuizBook.questions.length);

        if (score == 9){
            javaGrade.setText("Outstanding");
        }else if (score == 8){
            javaGrade.setText("Good Work");
        }else if (score == 7) {
            javaGrade.setText("You need more practice");
        }else {
            javaGrade.setText("You are not Android Developer");
        }

        javaRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, JavaActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}