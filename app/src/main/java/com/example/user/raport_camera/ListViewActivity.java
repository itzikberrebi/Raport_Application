package com.example.user.raport_camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.text.Html;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    public static final String TAG = "RAport";
    public static String[] intent_msg = null;
    public static final String msg_key = "msg_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Log.i(TAG,"start");

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list_view);

            PostClass[] p;

            intent_msg = getIntent().getStringArrayExtra(msg_key);
            if (intent_msg!=null)
            Log.i(TAG,String.valueOf(intent_msg.length));

            if (intent_msg!=null) {

                p = new PostClass[5];
                p[0] = new PostClass();
                p[1] = new PostClass();
                p[2] = new PostClass();
                p[3] = new PostClass();
                p[4] = new PostClass();

                p[0].set_title_array("פירצה בגדר ההיקפית");
                p[0].set_description_array("ליד המנהרה יש פירצה בגדר ההיקפית");
                //p[0].set_image_array("https://www.poundstretcher.co.uk/media/catalog/category/fencing_image.jpg");
                p[0].set_image_array("post_image4");
                p[0].set_category_array("ביטחון");
                p[0].set_location_array("23.454,45.67856");
                p[0].set_share_array("1");
                p[0].set_time_array("19/06/17 17:54");

                p[1].set_title_array("מנת השף חסרה היום");
                p[1].set_description_array("בשל החג לא תוגש מנת השף!");
                //p[1].set_image_array("https://www.poundstretcher.co.uk/media/catalog/category/fencing_image.jpg");
                p[1].set_image_array("post_image3");
                p[1].set_category_array("הסעדה");
                p[1].set_location_array("חדר אוכל מרכזי");
                p[1].set_share_array("1");
                p[1].set_time_array("10/06/17 08:54");

                p[2].set_title_array("אירוע סייבר קריטי");
                p[2].set_description_array("מספר רב של עובדים קיבלו מייל זדוני מתוקף שמזדהה בתור סמנכל כספים");
                //p[2].set_image_array("http://s4.evcdn.com/images/block250/I0-001/037/711/759-7.jpeg_/november-cyber-breakfast-cyber-business-59.jpeg");
                p[2].set_image_array("post_image2");
                p[2].set_category_array("סייבר");
                p[2].set_location_array("רפאל");
                p[2].set_share_array("1");
                p[2].set_time_array("19/01/17 20:54");

                p[3].set_title_array("חיסכון בחשמל");
                p[3].set_description_array("האורות בבניין 30 נשארים דלוקים כל הלילה. לא חבל?");
                p[3].set_image_array("post_image1");
                p[3].set_category_array("תשתיות");
                p[3].set_location_array("23.454,45.67856");
                p[3].set_share_array("1");
                p[3].set_time_array("19/05/17 17:54");

                p[4].set_time_array(intent_msg[0]);
                p[4].set_image_array(intent_msg[1]);
                p[4].set_location_array(intent_msg[2]);
                p[4].set_category_array(intent_msg[3]);
                p[4].set_share_array(intent_msg[4]);
                p[4].set_title_array(intent_msg[5]);
                p[4].set_description_array(intent_msg[6]);

            } else {
                p = new PostClass[4];
                p[0] = new PostClass();
                p[1] = new PostClass();
                p[2] = new PostClass();
                p[3] = new PostClass();

                p[0].set_title_array("פירצה בגדר ההיקפית");
                p[0].set_description_array("ליד המנהרה יש פירצה בגדר ההיקפית");
                //p[0].set_image_array("https://www.poundstretcher.co.uk/media/catalog/category/fencing_image.jpg");
                p[0].set_image_array("post_image4");
                p[0].set_category_array("ביטחון");
                p[0].set_location_array("23.454,45.67856");
                p[0].set_share_array("1");
                p[0].set_time_array("19/06/17 17:54");

                p[1].set_title_array("מנת השף חסרה היום");
                p[1].set_description_array("בשל החג לא תוגש מנת השף!");
                //p[1].set_image_array("https://www.poundstretcher.co.uk/media/catalog/category/fencing_image.jpg");
                p[1].set_image_array("post_image3");
                p[1].set_category_array("הסעדה");
                p[1].set_location_array("חדר אוכל מרכזי");
                p[1].set_share_array("1");
                p[1].set_time_array("10/06/17 08:54");

                p[2].set_title_array("אירוע סייבר קריטי");
                p[2].set_description_array("מספר רב של עובדים קיבלו מייל זדוני מתוקף שמזדהה בתור סמנכל כספים");
                //p[2].set_image_array("http://s4.evcdn.com/images/block250/I0-001/037/711/759-7.jpeg_/november-cyber-breakfast-cyber-business-59.jpeg");
                p[2].set_image_array("post_image2");
                p[2].set_category_array("סייבר");
                p[2].set_location_array("רפאל");
                p[2].set_share_array("1");
                p[2].set_time_array("19/01/17 20:54");

                p[3].set_title_array("חיסכון בחשמל");
                p[3].set_description_array("האורות בבניין 30 נשארים דלוקים כל הלילה. לא חבל?");
                p[3].set_image_array("post_image1");
                p[3].set_category_array("תשתיות");
                p[3].set_location_array("23.454,45.67856");
                p[3].set_share_array("1");
                p[3].set_time_array("19/05/17 17:54");
            }
//            ListAdapter listview_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, posts);
            ListAdapter listview_adapter = new CustomAdapter(this, p);

            ListView listview = (ListView) findViewById(R.id.listview);
            listview.setAdapter(listview_adapter);

            listview.setOnItemClickListener(
                    new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long i) {
                            Object temp = (parent.getItemAtPosition(position));
                            PostClass p = (PostClass) temp;
                            String[] post_ext = new String[7];

                            post_ext[0] = p.get_time_array();
                            post_ext[1] = p.get_image_array();
                            post_ext[2] = p.get_location_array();
                            post_ext[3] = p.get_category_array();
                            post_ext[4] = p.get_share_array();
                            post_ext[5] = p.get_title_array();
                            post_ext[6] = p.get_description_array();
                            Log.i(TAG,"des: " + post_ext[6]);

                            Intent intent = new Intent(ListViewActivity.this, RaportZoom.class);
                            intent.putExtra(msg_key,post_ext);
                            startActivity(intent);

                        }
                    }
            );

        } catch (Exception e) {
            Log.i(TAG,"exception!");
            Log.i(TAG,e.toString());
        }
    }

    public void add_new_post(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
