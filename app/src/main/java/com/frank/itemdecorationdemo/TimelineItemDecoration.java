package com.frank.itemdecorationdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by frank on 2017/4/12.
 */
public class TimelineItemDecoration extends RecyclerView.ItemDecoration {


    private Paint mPaint;
    //ItemView左边的间距
    private float mOffsetLeft;
    //ItemView上边的间距
    private float mOffsetTop;
    //时间轴结点的半径
    private float mNodeRadius;

    private Bitmap mIcon;

    public TimelineItemDecoration(Context context) {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);

        mOffsetLeft = context.getResources().getDimension(R.dimen.timeline_item_offset_left);
        mNodeRadius = context.getResources().getDimension(R.dimen.timeline_item_node_radius);

        mIcon = BitmapFactory.decodeResource(context.getResources(),R.drawable.clock);
        mIcon = Bitmap.createScaledBitmap(mIcon,(int)mNodeRadius * 2,(int)mNodeRadius * 2,false);

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

//        //第一个ItemView不需要在上面绘制分割线
        if (parent.getChildAdapterPosition(view) != 0){
            //这里直接硬编码为1px
            outRect.top = 1;
            mOffsetTop = 1;
        }

        outRect.left = (int) mOffsetLeft;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();

        for ( int i = 0; i < childCount; i++ ) {
            View view = parent.getChildAt(i);

            int index = parent.getChildAdapterPosition(view);

            float dividerTop = view.getTop() - mOffsetTop;
            //第一个ItemView 没有向上方向的间隔
            if ( index == 0 ) {
                dividerTop = view.getTop();
            }

            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = view.getBottom();
            float dividerRight = parent.getWidth() - parent.getPaddingRight();

            float centerX = dividerLeft + mOffsetLeft / 2;
            float centerY = dividerTop + (dividerBottom - dividerTop) / 2;

            float upLineTopX = centerX;
            float upLineTopY = dividerTop;
            float upLineBottomX = centerX;
            float upLineBottomY = centerY - mNodeRadius;

            //绘制上半部轴线
            c.drawLine(upLineTopX,upLineTopY,upLineBottomX,upLineBottomY,mPaint);

//            //绘制时间轴结点
//            mPaint.setStyle(Paint.Style.STROKE);
//            c.drawCircle(view.getLeft(),centerY,mNodeRadius,mPaint);
////            c.drawCircle(centerX,centerY,mNodeRadius,mPaint);
//            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);

            c.drawBitmap(mIcon,centerX - mNodeRadius,centerY - mNodeRadius,mPaint);

            float downLineTopX = centerX;
            float downLineTopY = centerY + mNodeRadius;
            float downLineBottomX = centerX;
            float downLineBottomY = dividerBottom;

            //绘制上半部轴线
            c.drawLine(downLineTopX,downLineTopY,downLineBottomX,downLineBottomY,mPaint);
        }
    }
}
