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
    private float radius = 100;
//    private float x1Coor = 0;
//    private float y1Coor = 0;

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
        //Paint surfaceBackground = new Paint();
        //surfaceBackground.setColor(Color.WHITE);
        //canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), surfaceBackground);
        canvas.drawColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(radius);
        paint.setColor(Color.BLACK);
        canvas.drawLine(getxCoor(), getyCoor(), 525, 600, paint);
        paint.setColor(Color.RED);
        canvas.drawCircle(525, 600, (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(525 - (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 600 - (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 525 + (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 600 + (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), paint);
        canvas.drawLine(525 - (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 600 - (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 525 + (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), 600 + (float)(Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))), paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(525 - (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 600 - (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 525 + (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 600 + (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), paint);
        canvas.drawLine(525 + (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 600 - (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 525 - (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), 600 + (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(getxCoor() - 525, 2) + Math.pow(getyCoor() - 600, 2))) / 2), paint);
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

//    public float getx1Coor(){
//        return x1Coor;
//    }
//
//    public void setx1Coor(float x){
//        this.x1Coor = x;
//    }
//
//    public float gety1Coor(){
//        return y1Coor;
//    }
//
//    public void sety1Coor(float y){
//        this.y1Coor = y;
//    }

    public Paint getPaint(){
        return paint;
    }

    public void setPaint(Paint paint){
        this.paint = paint;
    }

    public float getRadius(){
        return radius;
    }

    public void setRadius(float r){
        this.radius = r;
    }

    public void resetPaint(){
        surfaceHolder = getHolder();
        Canvas canvas = surfaceHolder.lockCanvas();
        canvas.drawColor(Color.WHITE);
        surfaceHolder.unlockCanvasAndPost(canvas);
    }
}