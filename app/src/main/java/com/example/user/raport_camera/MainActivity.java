package com.example.user.raport_camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
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

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "RAport";
    public static final String msg_key = "msg_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.i(TAG,"before");
            PushDate();
            Log.i(TAG,"after");

        }
        catch (Exception e) {
            Log.i(TAG,"error " + e.toString());

        }
    }

    public static final String[] intent_msg = new String[7];
    public void onSubmit(View view)
    {
        TextView date_obj = (TextView) findViewById(R.id.TextDate);
        String date = date_obj.getText().toString();
        String image = "post_image1";
        EditText location_obj = (EditText) findViewById(R.id.EditTextName);
        String location = date_obj.getText().toString();
        Spinner categoty_obj = (Spinner) findViewById(R.id.SpinnerFeedbackType);
        String category = categoty_obj.getSelectedItem().toString();
        CheckBox isShare_obj = (CheckBox) findViewById(R.id.CheckBoxResponse);
        String isShare = "";
        if (isShare_obj.isChecked())
        {
            isShare = "1";
        }
        else
        {
            isShare = "0";
        }
        EditText title_obj = (EditText) findViewById(R.id.ReportName);
        String title = title_obj.getText().toString();
        EditText description_obj = (EditText) findViewById(R.id.EditTextFeedbackBody);
        String description = description_obj.getText().toString();

        intent_msg[0] = date;
        intent_msg[1] = image;
        intent_msg[2] = location;
        intent_msg[3] = category;
        intent_msg[4] = isShare;
        intent_msg[5] = title;
        intent_msg[6] = description;

        Intent intent = new Intent(this, ListViewActivity.class);
        intent.putExtra(msg_key,intent_msg);
        if (intent_msg!=null)
            Log.i(TAG,"in new post: " + String.valueOf(intent_msg.length));

        startActivity(intent);
    }

    public void PushDate()
    {
        long date = System.currentTimeMillis();

        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        TextView tv = (TextView) findViewById(R.id.TextDate);
        tv.setText(dateString);
    }

    public void cameraOpen(View view)
    {
        //Toast.makeText(this, "message", Toast.LENGTH_SHORT).show();
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        if (cameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1);
        }
    }

    public void gpsOpen(View view)
    {
        Context context = getApplicationContext();
        CharSequence text = "gpsOpen()";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void galleryOpen(View view)
    {
        Context context = getApplicationContext();
        CharSequence text = "galleryopen()";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    Bitmap yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                }
        }
    }
*/
    public String path = "";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView image = (ImageView) findViewById(R.id.imageView5);
            image.setImageBitmap(imageBitmap);
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            image.setBackgroundColor(0x00000000);
            image.setPadding(0, 0, 0, 0);

            //MediaStore.Images.Media.insertImage(getContentResolver(),imageBitmap,"image_test", "des_test");
        }
    }

}
