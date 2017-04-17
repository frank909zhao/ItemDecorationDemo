package com.frank.itemdecorationdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by frank on 2017/4/11.
 */

public class BookRankAdapter extends RecyclerView.Adapter<BookRankAdapter.TestHolder> {

    List<String> data;
    int[] mIconResouces;
    public BookRankAdapter(List<String> data,int[] ids) {
        this.data = data;
        this.mIconResouces = ids;
    }

    public void setData(List<String> data,int[] ids) {
        this.data = data;
        mIconResouces = ids;
        notifyDataSetChanged();
    }

    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ranklist_item,parent,false);
        TestHolder holder = new TestHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TestHolder holder, int position) {
        if (data != null && data.size() > 0 ) {
            String text = data.get(position);

            String[] infos = text.split("-");
            holder.tvOrder.setText(position+"");
            holder.tvTitle.setText(infos[0]);
            holder.tvPrice.setText(infos[1]);

            holder.ivCover.setImageResource(mIconResouces[position]);
        }
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    static class TestHolder extends  RecyclerView.ViewHolder{
        public TextView tvOrder;
        public TextView tvTitle;
        public TextView tvPrice;
        public ImageView ivCover;
        public TestHolder(View itemView) {
            super(itemView);

            tvOrder = (TextView) itemView.findViewById(R.id.tv_rank_oder);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            ivCover = (ImageView) itemView.findViewById(R.id.iv_cover);

        }

    }
}
