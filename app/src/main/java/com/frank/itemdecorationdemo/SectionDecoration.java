package com.frank.itemdecorationdemo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;

/**
 * Created by ly-zhaominglai on 2017/4/11.
 */

public class SectionDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    Bitmap bitmap;
    private TextPaint mTextPaint;
    private Paint.FontMetrics mFontMetric;
    private int mGap;


    public SectionDecoration() {
        mPaint = new Paint();
        mPaint.setColor(Color.CYAN);
        mPaint.setAntiAlias(true);
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.YELLOW);

        mTextPaint.setTextSize(28);
        mTextPaint.getFontMetrics(mFontMetric);

        mGap = 28;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //super.getItemOffsets(outRect, view, parent, state);
        int index = parent.getChildAdapterPosition(view);

        if ( index % 5 == 0 ) {
            outRect.top = mGap;
        } else {
            outRect.top = 0;
        }

       // if ( index == 0) outRect.top = 0;
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

            int index = parent.getChildAdapterPosition(view);
            Log.d("zml","index "+i);

            if (!isFirstVisibleIndexInGroup(i,index)) {
                continue;
            }

//            if (i == 1 && getGroupId(index-1) != getGroupId(index)) {
//                continue;
//            }

//            if ( index % 5 != 0 ) {
//                continue;
//            }
            int top = view.getTop() - mGap;
            if (i == 0 ) {
                 //top = top < 0 ? 0 : top;
                top = 0;

                if (getGroupId(index + 1) != getGroupId(index)) {
                    top = view.getBottom() - mGap;
                    top = Math.min(top,0);
                }
            }

            int bottom = top + mGap;
            c.drawRect(0,top,parent.getWidth()-parent.getPaddingRight(),bottom,mPaint);
            c.drawText(index/5+"",0,top+mGap,mTextPaint);

//            c.drawLine(10,top,10,top + (bottom - top) / 2 - 4,mPaint);
//            c.drawCircle(10,top + (bottom - top) / 2,3,mPaint);
//            c.drawLine(10,top + (bottom - top) / 2 + 4,10,bottom+4,mPaint);
        }
    }

    private boolean isFirstVisibleIndexInGroup(int i,int index) {
        return i == 0 || index % 5 == 0;
    }

    private int getGroupId(int index) {
        return index / 5;
    }

    public interface GroupIdCallback {
        int getGroupId(int position);
    }
}
