package com.minhnpa.trolldemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DetailsFragment extends Fragment implements View.OnClickListener {
    ViewPager viewPager;
    Button btnPrevious, btnNext;

    MainActivity host;
    TrollPagerAdapter adapter;

    int currentPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        host = (MainActivity) getActivity();

        View v = inflater.inflate(R.layout.fragment_details, null);

        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        btnPrevious = (Button) v.findViewById(R.id.btnPrevious);
        btnNext = (Button) v.findViewById(R.id.btnNext);


        adapter = new TrollPagerAdapter();
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(currentPosition, true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnPrevious) {
            if (currentPosition > 0) {
                currentPosition--;
                viewPager.setCurrentItem(currentPosition, true);
            } else {
                currentPosition = host.trolls.size() - 1;
                viewPager.setCurrentItem(currentPosition, true);
            }
        } else if (id == R.id.btnNext) {
            if (currentPosition < (host.trolls.size() - 1)) {
                currentPosition++;
                viewPager.setCurrentItem(currentPosition, true);
            } else {
                currentPosition = 0;
                viewPager.setCurrentItem(currentPosition, true);
            }
        }
    }

    class TrollPagerAdapter extends PagerAdapter {

        public TrollPagerAdapter() {
        }

        @Override
        public int getCount() {
            return host.trolls.size();
        }

        public Object instantiateItem(View collection, final int position) {
            DetailsView view = new DetailsView(host, host.trolls.get(position));
            view.setHost(host);
            ((ViewPager) collection).addView(view, 0);
            return view;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView((View) object);
        }
    }

}
