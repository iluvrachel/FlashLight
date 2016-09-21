package com.linsky.flashlight;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//这句要在setContentView之前，用于隐藏标题栏
        setContentView(R.layout.activity_main);
        final ToggleButton togglebutton = (ToggleButton) findViewById(R.id.toggleButton);
       final Camera  camera = Camera.open();

       final Parameters parameter = camera.getParameters();

        togglebutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 当按钮第一次被点击时候响应的事件
                if (togglebutton.isChecked()) {

                    Toast.makeText(MainActivity.this, "神说，要有光，于是便有了光", Toast.LENGTH_SHORT).show();

                    parameter.setFlashMode(Parameters.FLASH_MODE_TORCH);

                    camera.setParameters(parameter);
                }
                // 当按钮再次被点击时候响应的事件
                else {
                    Toast.makeText(MainActivity.this, "神说，要有黑夜，于是便有了黑夜", Toast.LENGTH_SHORT).show();

                    parameter.setFlashMode(Parameters.FLASH_MODE_OFF);

                    camera.setParameters(parameter);
                    //camera.release();

                }
            }
        });

    }
}