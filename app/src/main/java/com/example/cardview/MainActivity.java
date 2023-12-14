package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener, Activity, View.OnClickListener {

    public CardView cardL, cardP, cardA, cardG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardL = (CardView) findViewById(R.id.lightCard);
        cardP = (CardView) findViewById(R.id.proximityCard);
        cardA = (CardView) findViewById(R.id.accelerometerCard);
        cardG = (CardView) findViewById(R.id.gyroscopeCard);

        cardL.setOnClickListener((View.OnClickListener) this);
        cardP.setOnClickListener((View.OnClickListener) this);
        cardA.setOnClickListener((View.OnClickListener) this);
        cardG.setOnClickListener((View.OnClickListener) this);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorManager sensorManager1= (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorManager sensorManager2= (SensorManager) getSystemService(SENSOR_SERVICE);
        SensorManager sensorManager3= (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager!=null) {
            Sensor lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

            if(lightSensor!=null) {
                sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            Toast.makeText(this, "Sensor Not Detected.", Toast.LENGTH_SHORT).show();
        }

        if(sensorManager1!=null) {
            Sensor accelarometerSensor = sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

            if(accelarometerSensor!=null) {
                sensorManager1.registerListener(this, accelarometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            Toast.makeText(this, "Aceelarometer Not Detected", Toast.LENGTH_SHORT).show();
        }

        if (sensorManager2!=null) {
            Sensor proximitySensor = sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY);

            if (proximitySensor!=null) {
                sensorManager2.registerListener(this, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            Toast.makeText(this, "Proximity Sensor Not Detected", Toast.LENGTH_SHORT).show();
        }

        if (sensorManager3!=null) {
            Sensor gyroscope = sensorManager3.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

            if (gyroscope!=null) {
                sensorManager3.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
            }
        } else {
            Toast.makeText(this, "Gyroscope Not Detected", Toast.LENGTH_SHORT).show();
        }
    }



    public void onClick(View v) {
        Intent i;

        switch(v.getId()) {
            case R.id.lightCard :
                i = new Intent(this,LightActivity.class);
                startActivity(i);
                break;

            case R.id.proximityCard :
                i = new Intent(this,ProximityActivity.class);
                startActivity(i);
                break;

            case R.id.accelerometerCard :
                i= new Intent(this,AccelerometerActivity.class);
                startActivity(i);
                break;
            case R.id.gyroscopeCard :
                i = new Intent(this,GyroscopeActivity.class);
                startActivity(i);
                break;
        }

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            ((TextView)findViewById(R.id.Light)).setText("Values: " + event.values[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            ((TextView)findViewById(R.id.accel)).setText("X: " + event.values[0] + "Y: " + event.values[1] + "Z: " + event.values[2]);
        }

        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            ((TextView)findViewById(R.id.proxy)).setText("Va" + event.values[0]);
        }

        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            ((TextView)findViewById(R.id.gyro)).setText("X: " + event.values[0] + "Y: " + event.values[1] + "Z: " + event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }





}