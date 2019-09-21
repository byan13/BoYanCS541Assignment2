package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class CustomGraphing extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder surfaceHolder = null;
    private Paint paint = null;
    private float xCoor = 0;
    private float yCoor = 0;

    public CustomGraphing(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        drawImage();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int j, int k) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        paint = null;
    }

    public void drawImage(){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        Paint surfaceBackground = new Paint();
        surfaceBackground.setColor(Color.WHITE);
        canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);

        canvas.drawLine(0, 0, getxCoor(), getyCoor(), paint);

        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    public float getxCoor(){
        return xCoor;
    }

    public void setxCoor(float x){
        this.xCoor = x;
    }

    public float getyCoor(){
        return yCoor;
    }

    public void setyCoor(float y){
        this.yCoor = y;
    }

    public Paint getPaint(){
        return paint;
    }

    public void setPaint(Paint paint){
        this.paint = paint;
    }
}