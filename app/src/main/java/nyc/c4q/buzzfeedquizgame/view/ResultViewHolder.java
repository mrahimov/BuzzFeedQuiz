package nyc.c4q.buzzfeedquizgame.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nyc.c4q.buzzfeedquizgame.R;

/**
 * Created by muridjonrahimov on 11/18/17.
 */

public class ResultViewHolder extends RecyclerView.ViewHolder {
    private TextView resultTV;
    private Button resultButton;
    private int counter;

    public ResultViewHolder(View itemView) {
        super(itemView);
        resultTV = (TextView) itemView.findViewById(R.id.result_textview);
        resultButton = (Button) itemView.findViewById(R.id.result_button);

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTV.setText("You scored " + counter + " out of 6");
            }
        });
    }
    public void bindData(int counter) {
        this.counter = counter;
    }

}
