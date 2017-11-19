package nyc.c4q.buzzfeedquizgame.controler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import nyc.c4q.buzzfeedquizgame.BuildConfig;
import nyc.c4q.buzzfeedquizgame.R;
import nyc.c4q.buzzfeedquizgame.model.Model;
import nyc.c4q.buzzfeedquizgame.view.AndroidViewHolder;
import nyc.c4q.buzzfeedquizgame.view.ResultViewHolder;

/**
 * Created by muridjonrahimov on 11/16/17.
 */

public class AndroidAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ClickDelegate{
    private int counter = 0;
    private List<Model> list;
    private static final int VIEW_TYPE_QUESTION = 0;
    private static final int VIEW_TYPE_RESULT = 1;

    public AndroidAdapter(List<Model> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_QUESTION:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_item_view, parent, false);
                return new AndroidViewHolder(view);
            case VIEW_TYPE_RESULT:
                View view1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_layout, parent, false);
                return new ResultViewHolder(view1);
        }
        throw new IllegalArgumentException("Invalid view type:" + viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_QUESTION:
                 Model model = list.get(position);
                 AndroidViewHolder androidViewHolder = (AndroidViewHolder) holder;
                 androidViewHolder.onBind(model, this);
                break;

            case VIEW_TYPE_RESULT:
                ResultViewHolder resultViewHolder = (ResultViewHolder) holder;
                resultViewHolder.bindData(counter);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) {
            return VIEW_TYPE_RESULT;
        } else {
            return VIEW_TYPE_QUESTION;
        }
    }

    @Override
    public void incrementCount(int counter) {
        this.counter=counter;
    }
}

