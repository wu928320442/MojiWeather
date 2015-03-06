package com.wjj.mojiweather;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wujiajun on 2015/2/16.
 * @author 928320442@qq.com
 */
public class BirdUp extends Actor {
    private static final int[] imgs = new int[]{R.drawable.finedayup_1, R.drawable.finedayup_2, R.drawable.finedayup_3, R.drawable.finedayup_4, R.drawable.finedayup_5, R.drawable.finedayup_6, R.drawable.finedayup_7, R.drawable.finedayup_8};

    float initPositionX;
    float initPositionY;
    boolean isInit;
    List<Bitmap> frames;
    RectF box;
    RectF targetBox;
    int curFrameIndex;
    long lastTime;
    Paint paint = new Paint();

    protected BirdUp(Context context) {
        super(context);
        frames = new ArrayList<Bitmap>();
        box = new RectF();
        targetBox = new RectF();
        paint.setAntiAlias(true);
    }

    @Override
    public void draw(Canvas canvas, int width, int height) {
        //逻辑处理
        //初始化
        if (!isInit) {
            initPositionX = width * 0.117F;
            initPositionY = height * 0.35F;
            matrix.reset();
            matrix.postTranslate(initPositionX, initPositionY);
            for (int res : imgs) {
                frames.add(BitmapFactory.decodeResource(context.getResources(), res));
            }
            box.set(0, 0, frames.get(0).getWidth(), frames.get(0).getHeight());
            isInit = true;
            lastTime = System.currentTimeMillis();
            return;
        }
        //移动
        matrix.postTranslate(2, 0);
        //边界处理
        matrix.mapRect(targetBox, box);
        if (targetBox.left > width) {
            matrix.postTranslate(-targetBox.right, 0);
        }
        //取得帧动画图片
        long curTime = System.currentTimeMillis();
        curFrameIndex = (int) ((curTime - lastTime) / 500 % 8);

        Bitmap curBitmap = frames.get(curFrameIndex);
        //绘制
        canvas.save();
        canvas.drawBitmap(curBitmap, matrix, paint);
        canvas.restore();
    }
}
