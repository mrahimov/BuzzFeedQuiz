package nyc.c4q.buzzfeedquizgame.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import nyc.c4q.buzzfeedquizgame.R;
import nyc.c4q.buzzfeedquizgame.controler.ClickDelegate;
import nyc.c4q.buzzfeedquizgame.model.Model;

/**
 * Created by muridjonrahimov on 11/16/17.
 */

public class AndroidViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView question;
    private ImageView imageView;
    Button trueButton;
    Button falseButton;
    ClickDelegate clickDelegate;
    Model model;
    int counter = 0;


    public AndroidViewHolder(View itemView) {
        super(itemView);

        question = (TextView) itemView.findViewById(R.id.question_textview);
        imageView = (ImageView) itemView.findViewById(R.id.image_view_android);
        falseButton = (Button) itemView.findViewById(R.id.false_button);
        trueButton = (Button) itemView.findViewById(R.id.true_button);

        trueButton.setOnClickListener(this);
        falseButton.setOnClickListener(this);


    }

    public void onBind(Model model, ClickDelegate listener) {
        this.clickDelegate = listener;
        this.model = model;

        question.setText(model.getQuestion());
        imageView.setImageResource(model.getImage());
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.true_button:

                if (model.isAnswerCorrect()) {
                    clickDelegate.incrementCount(++counter);
                    trueButton.setEnabled(false);
                }
                break;
            case R.id.false_button:

                if (!model.isAnswerCorrect()) {
                    clickDelegate.incrementCount(++counter);
                    falseButton.setEnabled(false);

                }
                break;
        }
    }

}
