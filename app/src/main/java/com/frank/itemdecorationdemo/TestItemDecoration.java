package com.frank.itemdecorationdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ly-zhaominglai on 2017/4/11.
 */

public class TestItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    Bitmap bitmap;


    public TestItemDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setAntiAlias(true);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = 4;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
//        int childCount = parent.getChildCount();
//
//        for ( int i = 0; i < childCount; i++ ) {
//            View view = parent.getChildAt(i);
//            int top = view.getBottom();
//            int bottom = top + 2;
//            c.drawCircle(parent.getWidth() / 2 , top + ( bottom - top ) / 2,2,mPaint);
//        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);


        int childCount = parent.getChildCount();

        for ( int i = 0; i < childCount; i++ ) {
            View view = parent.getChildAt(i);
            int top = view.getTop();
            int bottom = view.getBottom();
            c.drawLine(10,top,10,top + (bottom - top) / 2 - 4,mPaint);
            c.drawCircle(10,top + (bottom - top) / 2,3,mPaint);
            c.drawLine(10,top + (bottom - top) / 2 + 4,10,bottom+4,mPaint);
        }
    }
}
