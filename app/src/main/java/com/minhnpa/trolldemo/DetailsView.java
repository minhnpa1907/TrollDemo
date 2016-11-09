package com.minhnpa.trolldemo;

import android.content.Context;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsView extends ScrollView implements View.OnClickListener{
    TextView txtName, txtDetail;
    ImageView imgAvatar;
    Button btnMoreD;
    Troll troll;

    public void setHost(MainActivity host){
        this.host = host;
    }

    MainActivity host;

    public DetailsView(Context context, Troll troll) {
        super(context); //bắt buộc
        inflate(context, R.layout.view_details, this);
        this.troll = troll;

        txtName = (TextView) findViewById(R.id.txtName);
        imgAvatar = (ImageView) findViewById(R.id.imgAvatar);
        txtDetail = (TextView) findViewById(R.id.txtDetail);
        btnMoreD = (Button) findViewById(R.id.btnMoreD);

        txtName.setText(troll.getName());
        imgAvatar.setImageResource(troll.getImage());
        txtDetail.setText(troll.getDesc());
        btnMoreD.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnMoreD) {
            MoreDetailsWebFragment moreDetailsWebFragment = new MoreDetailsWebFragment();
            FragmentTransaction fragmentTransaction = host.getFragmentManager().beginTransaction();
            moreDetailsWebFragment.setTroll(troll);
            fragmentTransaction.replace(R.id.mainLayout, moreDetailsWebFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }
}
