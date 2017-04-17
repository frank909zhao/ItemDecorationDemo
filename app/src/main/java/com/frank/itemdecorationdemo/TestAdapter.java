package com.frank.itemdecorationdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by frank on 2017/4/11.
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    List<String> data;

    public TestAdapter(List<String> data) {
        this.data = data;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false);
//        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
//        layoutParams.topMargin = 1;
//        view.setLayoutParams(layoutParams);
        TestHolder holder = new TestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TestHolder holder, int position) {
        if (data != null && data.size() > 0 ) {
            String text = data.get(position);
            holder.textView.setText(text);
        }
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class TestHolder extends  RecyclerView.ViewHolder{
        public TextView textView;
        public TestHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_content);
            textView.setTextSize(38.0f);
        }

    }
}
