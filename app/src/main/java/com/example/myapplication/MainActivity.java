package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static  final String TITLE="isomatedString";
    private static  final String SUBTITLE= "String_length";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar(toolbar);

        List<Map<String, String>> values = prepareContent();

        ListView listView = findViewById(R.id.listView);

        BaseAdapter listContentAdapter = createAdapter(values);
        listView.setAdapter(listContentAdapter);
    }



    private BaseAdapter createAdapter(List<Map<String,String>> values){
        String[] from = {TITLE, SUBTITLE};
        int[] to = {R.id.tv_title, R.id.tv_subtitle};
        return new SimpleAdapter(this,values, R.layout.list_item, from, to);
    }


    private  List<Map<String,String>> prepareContent(){

        String[] strings = getString(R.string.large_text).split("\n\n");
        List<Map<String,String>> list=new ArrayList<>();
        for (String str: strings){
            Map<String,String> map = new HashMap<>();
            map.put(TITLE,str.length()+"");
            map.put(SUBTITLE,str);
            list.add(map);

        }
        return  list;

    }
}