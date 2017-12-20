package com.example.aishwarya.monvoix;

/**
 * Created by aishwarya on 10/03/17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class FaqsAdapter extends RecyclerView.Adapter<FaqsAdapter.MyViewHolder> {

    private List<Faq> FaqsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView question, year, ans;

        public MyViewHolder(View view) {
            super(view);
            question = (TextView) view.findViewById(R.id.question);
            ans = (TextView) view.findViewById(R.id.ans);

        }
    }


    public FaqsAdapter(List<Faq> FaqsList) {
        this.FaqsList = FaqsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.faq_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Faq Faq = FaqsList.get(position);
        holder.question.setText(Faq.getquestion());
        holder.ans.setText(Faq.getans());
    }

    @Override
    public int getItemCount() {
        return FaqsList.size();
    }
}
