package com.minhnpa.trolldemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridFragment extends Fragment implements AdapterView.OnItemClickListener {
    GridView gridTroll;
    TrollAdapter adapter;

    MainActivity host;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        host = (MainActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_grid, null);
        gridTroll = (GridView) v.findViewById(R.id.gridTroll);
        adapter = new TrollAdapter(getActivity(), R.layout.cell_troll, host.trolls);
        gridTroll.setAdapter(adapter);
        gridTroll.setOnItemClickListener(this);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.currentPosition = position;
        FragmentTransaction fragmentTransaction = getActivity().getFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(R.id.mainLayout, detailsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    class TrollAdapter extends ArrayAdapter<Troll> {
        Context context;
        int resource;
        ArrayList<Troll> data;

        public TrollAdapter(Context context, int resource, ArrayList<Troll> data) {
            super(context, resource, data);
            this.context = context;
            this.resource = resource;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;

            if (convertView == null) {
                viewHolder = new ViewHolder();
                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                convertView = inflater.inflate(resource, null);

                viewHolder.imgView = (ImageView) convertView.findViewById(R.id.imgView);
                viewHolder.txtView = (TextView) convertView.findViewById(R.id.txtView);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Troll troll = data.get(position);
            viewHolder.imgView.setImageResource(troll.getImage());
            viewHolder.txtView.setText(troll.getName());

            return convertView;
        }

        class ViewHolder {
            ImageView imgView;
            TextView txtView;
        }
    }
}
