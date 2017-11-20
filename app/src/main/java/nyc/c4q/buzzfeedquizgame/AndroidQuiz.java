package nyc.c4q.buzzfeedquizgame;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.buzzfeedquizgame.controler.AndroidAdapter;
import nyc.c4q.buzzfeedquizgame.controler.ClickDelegate;
import nyc.c4q.buzzfeedquizgame.model.Model;

public class AndroidQuiz extends AppCompatActivity implements ClickDelegate {

    private boolean answer;
    private int aScore = 0;
    private int questionNumber = 0;
    
    private Button buttonIsTrue, buttonIsFalse;
    private List<Model> androidQuiz;
    private int counter;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_quiz);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        androidQuiz = new ArrayList<>();

        androidQuiz.add(new Model("<?xml version=\"1.0\" encoding=\"UTF-8\"?> This line is XML prolog", true, R.drawable.android));      //1:true
        androidQuiz.add(new Model("XML has only one root elements.\n", true, R.drawable.android_one));                                   //2:true
        androidQuiz.add(new Model("We use \"sp\"  for setting image size.", false, R.drawable.android_two));                              //3:false
        androidQuiz.add(new Model("Uses-permission attributes should be placed in activity_main.xml", false, R.drawable.android_three));  //4:false
        androidQuiz.add(new Model("use sharedPreferences in the apps to store and retrieve primitive data entries as key/value pairs", true, R.drawable.android_four));//5:true
        androidQuiz.add(new Model("drawable, layout, values located the \"res\" folder.", true, R.drawable.android_five));              //6:true


        final AndroidAdapter androidAdapter = new AndroidAdapter(androidQuiz);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setAdapter(androidAdapter);
        androidAdapter.setListener(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void clickExit(View view) {
        askToClose();
    }


    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(AndroidQuiz.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes I am loser!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("No I am cool guy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void incrementCount(int counter) {
        count++;
    }

    @Override
    public int getScore() {
        return count;
    }
}

