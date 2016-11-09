package com.minhnpa.trolldemo;

import android.content.res.TypedArray;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridFragment fragmentGrid;
    ArrayList<Troll> trolls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data
        trolls = prepareData();
        fragmentGrid = new GridFragment();

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.mainLayout, fragmentGrid);
        fragmentTransaction.commit();
    }

    public ArrayList<Troll> prepareData() {
        //Get Names Array
        String[] names = getResources().getStringArray(R.array.names);

        //Get Descriptions Array
        String[] descs = getResources().getStringArray(R.array.descriptions);

        //Get Images Array
        final TypedArray typedArray = getResources().obtainTypedArray(R.array.images);
        final int imageCount = names.length;
        int[] images = new int[imageCount];
        for (int i = 0; i < imageCount; i++) {
            images[i] = typedArray.getResourceId(i, 0);
        }
        typedArray.recycle();

        //Get Urls Array
        String[] urls = getResources().getStringArray(R.array.urls);

        ArrayList<Troll> arrayTroll = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Troll troll = new Troll(names[i], descs[i], images[i], urls[i]);
            arrayTroll.add(troll);
        }

        return arrayTroll;
    }
}
