package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

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

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private LinearLayout canvasLayout = null;
    CustomGraphing customGraphing = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeControl();

        customGraphing = new CustomGraphing(getApplicationContext());
        customGraphing.setOnTouchListener(this);
        canvasLayout.addView(customGraphing);
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
            customGraphing.setxCoor(x);
            customGraphing.setyCoor(y);

            Paint paint = new Paint();
            paint.setColor(Color.RED);
            customGraphing.setPaint(paint);

            customGraphing.drawImage();

            return true;
        }else {
            return false;
        }
    }
}