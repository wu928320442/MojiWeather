package com.wjj.mojiweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by wujiajun on 2015/2/16.
 */
public abstract class Actor {

    protected Context context;
    protected Matrix matrix = new Matrix();

    protected Actor(Context context) {
        this.context = context;
    }

    public abstract void draw(Canvas canvas, int width, int height);
}
