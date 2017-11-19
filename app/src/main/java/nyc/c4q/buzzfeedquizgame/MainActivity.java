package nyc.c4q.buzzfeedquizgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    Button javaQuiz;
    Button androidQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_main);
//        linearLayout.setBackgroundResource();

        //Setting on click to JavaActivity class
        javaQuiz = (Button) findViewById(R.id.java_button);
        javaQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, JavaActivity.class));
            }
        });

        //Setting on click to AndroidActivity class
        androidQuiz = (Button) findViewById(R.id.android_button);
        androidQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AndroidQuiz.class));
            }
        });


        Picasso.with(this)
                .load("https://images-na.ssl-images-amazon.com/images/I/61f4ruZJCYL.png")
                .into(((ImageView) findViewById(R.id.image_bg)));


    }

}