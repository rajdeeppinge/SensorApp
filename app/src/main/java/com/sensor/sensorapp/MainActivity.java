package com.sensor.sensorapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor lightSensor = null;
    private Sensor accelerometer = null;
    private Sensor gravitySensor = null;
    private Sensor gyroscope = null;
    private Sensor magnetometer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
/*
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<String> sensorNames = new ArrayList<String>(deviceSensors.size());
        for(int i = 0; i < deviceSensors.size(); i++) {
            sensorNames.add(deviceSensors.get(0).getName());
        }

        ListView listView = (ListView) findViewById(R.id.sensor_list);
        ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sensorNames);
        listView.setAdapter(la);

        lightSensor = null;
*/
        if (lightSensor == null){
            if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null){
                lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
                //Toast toast = Toast.makeText(this, "This device has light Sensor", Toast.LENGTH_LONG);
                //toast.show();
            }
            else{
                Toast toast = Toast.makeText(this, "This device does not have light Sensor", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (accelerometer == null){
            if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
                accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                //Toast toast = Toast.makeText(this, "This device has light Sensor", Toast.LENGTH_LONG);
                //toast.show();
            }
            else{
                Toast toast = Toast.makeText(this, "This device does not have accelerometer", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (gravitySensor == null){
            if (sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY) != null){
                gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
                //Toast toast = Toast.makeText(this, "This device has light Sensor", Toast.LENGTH_LONG);
                //toast.show();
            }
            else{
                Toast toast = Toast.makeText(this, "This device does not have gravity Sensor", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (gyroscope == null){
            if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null){
                gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
                //Toast toast = Toast.makeText(this, "This device has light Sensor", Toast.LENGTH_LONG);
                //toast.show();
            }
            else{
                Toast toast = Toast.makeText(this, "This device does not have gyroscope", Toast.LENGTH_LONG);
                toast.show();
            }
        }

        if (magnetometer == null){
            if (sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD) != null){
                magnetometer = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
                //Toast toast = Toast.makeText(this, "This device has light Sensor", Toast.LENGTH_LONG);
                //toast.show();
            }
            else{
                Toast toast = Toast.makeText(this, "This device does not have magnetometer", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if lightSensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        // The light lightSensor returns a single value.
        // Many sensors return 3 values, one for each axis.
//        float lux = event.values[0];

//        TextView textView = (TextView) findViewById(R.id.sensor_data);
//        textView.setText(Float.toString(lux));
        // Do something with this lightSensor value.

        Sensor sensor = event.sensor;

        if (sensor.getType() == Sensor.TYPE_LIGHT) {
            //TODO: get values
            float light = event.values[0];
            TextView textView = (TextView) findViewById(R.id.lightsensor_data);
            textView.setText("Ambient Light: " + Float.toString(light) + "  lux\n");
        } else if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //TODO: get values
            float ax = event.values[0];
            float ay = event.values[1];
            float az = event.values[2];
            TextView textView = (TextView) findViewById(R.id.accelerometer_data);
            textView.setText("Accelerometer:\n" +
                    "x-dir = " + Float.toString(ax) + " m/s^2\n" +
                    "y-dir = " + Float.toString(ay) + " m/s^2\n" +
                    "z-dir = " + Float.toString(az) + " m/s^2\n");
        } else if (sensor.getType() == Sensor.TYPE_GRAVITY) {
            //TODO: get values
            float gx = event.values[0];
            float gy = event.values[1];
            float gz = event.values[2];
            TextView textView = (TextView) findViewById(R.id.gravitysensor_data);
            textView.setText("Gravity Sensor:\n" +
                    "x-dir = " + Float.toString(gx) + " m/s^2\n" +
                    "y-dir = " + Float.toString(gy) + " m/s^2\n" +
                    "z-dir = " + Float.toString(gz) + " m/s^2\n");
        } else if (sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            //TODO: get values
            float gyrox = event.values[0];
            float gyroy = event.values[1];
            float gyroz = event.values[2];
            TextView textView = (TextView) findViewById(R.id.gyroscope_data);
            textView.setText("Gyroscope:\n" +
                    "ang speed around x-axis = " + Float.toString(gyrox) + " rad/s^2\n" +
                    "ang speed around y-axis = " + Float.toString(gyroy) + " rad/s^2\n" +
                    "ang speed around z-axis = " + Float.toString(gyroz) + " rad/s^2\n");
        } else if (sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            //TODO: get values
            float magx = event.values[0];
            float magy = event.values[1];
            float magz = event.values[2];
            TextView textView = (TextView) findViewById(R.id.magnetometer_data);
            textView.setText("Magnetic field:\n" +
                    "x-dir = " + Float.toString(magx) + " micro-tesla\n" +
                    "y-dir = " + Float.toString(magy) + " micro-tesla\n" +
                    "z-dir = " + Float.toString(magz) + " micro-tesla\n");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gravitySensor, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(this, magnetometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
        sensorManager.unregisterListener(this);
        sensorManager.unregisterListener(this);
        sensorManager.unregisterListener(this);
        sensorManager.unregisterListener(this);
    }

}
