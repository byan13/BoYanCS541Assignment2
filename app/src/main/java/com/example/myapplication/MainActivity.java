package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private LinearLayout canvasLayout = null;
    CustomGraphing customGraphing = null;
    SeekBar radiusBar;
    float slope = 1;
//    float tempx = 500;
//    float tempy = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControl();

        customGraphing = new CustomGraphing(getApplicationContext());
        customGraphing.setOnTouchListener(this);
        canvasLayout.addView(customGraphing);

        ExtendedFloatingActionButton exFab = findViewById(R.id.exFab);
        exFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customGraphing.resetPaint();
            }
        });

        radiusBar = (SeekBar)findViewById(R.id.radiusbar);
        radiusBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                customGraphing.setRadius(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Pen width is " + customGraphing.getRadius(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initializeControl(){
        if(canvasLayout == null){
            canvasLayout = (LinearLayout)findViewById(R.id.customGraphingLayout);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent){
        if(view instanceof SurfaceView){
            view.invalidate();

            float x = motionEvent.getX();
            float y = motionEvent.getY();
//            customGraphing.setxCoor(tempx);
//            customGraphing.setyCoor(tempy);
//            customGraphing.setx1Coor(x);
//            customGraphing.sety1Coor(y);
//
//            tempx = x;
//            tempy = y;
            customGraphing.setxCoor(x);
            customGraphing.setyCoor(y);

           //slope = customGraphing.getyCoor() / customGraphing.getxCoor();

            Paint paint = new Paint();
            //paint.setColor(Color.RED);
            customGraphing.setPaint(paint);
            customGraphing.drawImage();

            Toast.makeText(MainActivity.this, "x = " + customGraphing.getxCoor() +
                    ", y = " + customGraphing.getyCoor() + "\n" + "Radius = " +
                    (float)(Math.sqrt(Math.pow(customGraphing.getxCoor() - 520, 2) + Math.pow(customGraphing.getyCoor() - 600, 2))) +
                    "\n" + "Length of side of the inner square = " +
                    (float)(Math.sqrt(2) * (Math.sqrt(Math.pow(customGraphing.getxCoor() - 525, 2) + Math.pow(customGraphing.getyCoor() - 600, 2))) / 2) +
                    "\n" + "Length of side of the outer square = " + (float)(Math.sqrt(Math.pow(customGraphing.getxCoor() - 525, 2) + Math.pow(customGraphing.getyCoor() - 600, 2))), Toast.LENGTH_SHORT).show();

            return true;
        }else {
            return false;
        }
    }
}