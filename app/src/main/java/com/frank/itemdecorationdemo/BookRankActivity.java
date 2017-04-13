package com.frank.itemdecorationdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookRankActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    List<String> data;
    BookRankAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookrank);
        mRecyclerView = (RecyclerView) findViewById(R.id.bookrank_recyclerview);


        initDatas();
        int resouces[] = new int[] {R.drawable.book_renmin,R.drawable.book_huochetou,
            R.drawable.book_jieyouzahuodian,R.drawable.book_tensoflow,R.drawable.book_wangyangming
            ,R.drawable.book_renmin,R.drawable.book_huochetou,
                R.drawable.book_jieyouzahuodian,R.drawable.book_tensoflow,R.drawable.book_wangyangming
            ,R.drawable.book_renmin,R.drawable.book_huochetou,
                R.drawable.book_jieyouzahuodian,R.drawable.book_tensoflow,R.drawable.book_wangyangming
        };
        mAdapter = new BookRankAdapter(data,resouces);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        layoutmanager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutmanager);
        mRecyclerView.addItemDecoration(new FlagItemDecoration(this));
    }

    private void initDatas() {
        data = new ArrayList<>();
        data.add("人民的名义- ￥ 33.5");
        data.add("火车头 - ￥ 27.5");
        data.add("解忧杂货店- ￥ 19.9");
        data.add("TensorFlow - ￥ 102.5");
        data.add("王阳明心学 - ￥ 60");

        data.add("人民的名义1- ￥ 33.5");
        data.add("火车头1 - ￥ 27.5");
        data.add("解忧杂货店1- ￥ 19.9");
        data.add("TensorFlow1 - ￥ 102.5");
        data.add("王阳明心学1 - ￥ 60");

        data.add("人民的名义2 - ￥ 33.5");
        data.add("火车头2 - ￥ 27.5");
        data.add("解忧杂货店2- ￥ 19.9");
        data.add("TensorFlow2 - ￥ 102.5");
        data.add("王阳明心学2 - ￥ 60");
    }
}
