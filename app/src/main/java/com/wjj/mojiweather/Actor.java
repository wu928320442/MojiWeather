package com.wjj.mojiweather;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;

/**
 * Created by wujiajun
 * @author 928320442@qq.com
 */
public abstract class Actor {

    protected Context context;
    protected Matrix matrix = new Matrix();

    protected Actor(Context context) {
        this.context = context;
    }

    public abstract void draw(Canvas canvas, int width, int height);
}
