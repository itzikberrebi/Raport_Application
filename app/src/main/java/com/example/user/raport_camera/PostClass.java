package com.example.user.raport_camera;

public class PostClass {

    String _title;
    String _description;
    String _image;
    String _location;
    String _category;
    String _share;
    String _time;


    public PostClass(){
        _title = "";
        _description = "";
        _image = "";
        _location = "";
        _category = "";
        _share = "";
        _time = "";

    }

    public void set_title_array(String title){
        _title = title;
    }

    public void set_description_array(String description){
        _description = description;
    }

    public void set_image_array(String image){
        _image = image;
    }

    public void set_location_array(String location){
        _location = location;
    }

    public void set_category_array(String category){
        _category = category;
    }

    public void set_share_array(String share){
        _share = share;
    }

    public void set_time_array(String time){
        _time = time;
    }


    public String get_title_array(){
        return _title;
    }

    public String get_description_array(){
        return _description;
    }

    public String get_image_array(){
        return _image;
    }

    public String get_location_array(){
        return _location;
    }

    public String get_category_array(){
        return _category;
    }

    public String get_share_array(){
        return _share;
    }

    public String get_time_array(){
        return _time;
    }


}
