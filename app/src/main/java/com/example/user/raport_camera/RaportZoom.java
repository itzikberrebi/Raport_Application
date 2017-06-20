package com.example.user.raport_camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RaportZoom extends AppCompatActivity {

    public static final String msg_key = "msg_key";
    public static final String TAG = "RAport";
    public static String[] intent_msg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raport_zoom);

        try {
            Log.i(TAG,"RAPORT!");

            intent_msg = getIntent().getStringArrayExtra(msg_key);

            // push Date
            TextView date_obj = (TextView) findViewById(R.id.TextDate);
            Log.i(TAG,"date: " + intent_msg[0]);
            date_obj.setText(intent_msg[0].toString());

            // push Image
            String image = intent_msg[1];
            int id = getResources().getIdentifier("com.example.user.raport_camera:drawable/" + image, null, null);
            ImageView iv = (ImageView) findViewById(R.id.imageView5);
            iv.setImageResource(id);

            // push location
            TextView location_obj = (TextView) findViewById(R.id.TextLocation);
            Log.i(TAG,"location: " + intent_msg[2]);
            date_obj.setText(intent_msg[2]);

            // push categoty
            TextView category_obj = (TextView) findViewById(R.id.SpinnerFeedbackType);
            category_obj.setText(intent_msg[3]);

            // push isShare
            CheckBox isShare_obj = (CheckBox) findViewById(R.id.CheckBoxResponse);
            Log.i(TAG,"isShare: " + intent_msg[4]);
            if (intent_msg[4] == "0") {
                isShare_obj.setChecked(false);
            } else {
                isShare_obj.setChecked(true);
            }

            TextView title_obj = (TextView) findViewById(R.id.ReportName);
            title_obj.setText(intent_msg[5]);
            TextView description_obj = (TextView) findViewById(R.id.EditTextFeedbackBody);
            description_obj.setText(intent_msg[6]);
        } catch (Exception e) {
            Log.i(TAG,e.toString());

        }
    }

}
