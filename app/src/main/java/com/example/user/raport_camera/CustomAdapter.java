package com.example.user.raport_camera;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


class CustomAdapter extends ArrayAdapter{

    public static final String TAG = "RAport";
    public Bitmap b = null;

    public CustomAdapter(Context context, PostClass[] post_class) {
        super(context,R.layout.custom_row, post_class);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row, parent, false);

        PostClass post_title = (PostClass) getItem(position);
        TextView tv1 = (TextView) customView.findViewById(R.id.post_title);
        TextView tv2 = (TextView) customView.findViewById(R.id.post_description);
        ImageView imageView = (ImageView) customView.findViewById(R.id.post_image);

        tv1.setText(post_title.get_title_array());
        tv2.setText(post_title.get_description_array());

        final ImageView like_button = (ImageView) customView.findViewById(R.id.like_icon);
        like_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        like_button.setImageResource(R.drawable.like_icon_blue);
                    }
                }
        );

        final ImageView dislike_button = (ImageView) customView.findViewById(R.id.dislike_icon);
        dislike_button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){
                        dislike_button.setImageResource(R.drawable.dislike_icon_blue);
                    }
                }
        );

        try {
            int id = convertView.getResources().getIdentifier("com.example.user.raport_camera:drawable/" + post_title.get_image_array(), null, null);
            imageView.setImageResource(id);
            //View v = super.getView(position, convertView, parent);
            //Picasso.with(convertView.getContext()).load(post_title.get_image_array()).into(imageView);
            Log.i(TAG, "id: " + String.valueOf(id));

        } catch (Exception e) {
            Log.i(TAG, e.toString());
        }
        return customView;
    }
}
