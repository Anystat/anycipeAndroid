package com.anystat.anycipeandroid.UI.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public class SquareImageView extends ImageView {
    public SquareImageView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int newWidth = getMeasuredWidth();
        int newHeight = getMeasuredHeight();

        if(newWidth<newHeight){
            setMeasuredDimension(newWidth, newWidth);
        }
        else setMeasuredDimension(newHeight, newHeight);


    }
}
