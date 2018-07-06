package com.example.johnb.motionsensor3in1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class theCombination extends AppCompatActivity implements SensorEventListener{


    Sensor  mMagnetic;
    SensorManager mMagnetman;
    TextView MagnetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_combination);


        mMagnetman=(SensorManager)getSystemService(SENSOR_SERVICE);
        mMagnetic=mMagnetman.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        mMagnetman.registerListener(this, mMagnetic, SensorManager.SENSOR_DELAY_NORMAL);
        MagnetView=(TextView)findViewById(R.id.MagneticData);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
     int sensorType= event.sensor.getType();

      if(sensorType == Sensor.TYPE_MAGNETIC_FIELD) {
          MagnetView.setText("x: " + event.values[0] + "\n" + "y: " + event.values[1] + "\n" + "z: " + event.values[2]);
      }else{
          Toast.makeText(
                  getApplicationContext(),
                  "No Sensors Detected",
                  Toast.LENGTH_LONG).show();

      }
      }

        
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }



}

