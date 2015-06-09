package com.example.jayb.bizcard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jayb on 6/8/15.
 */
public class BizCardAdapter extends BaseAdapter {
    private ArrayList<BizCardDataSource> datasource = new ArrayList<BizCardDataSource>();

    public BizCardAdapter(){
        datasource.add(new BizCardDataSource("Finance Manager",0720123456));
        datasource.add(new BizCardDataSource("System Administrator",0712345671));
        datasource.add(new BizCardDataSource("Project Manager",0723123426));
        datasource.add(new BizCardDataSource("Infrastructure Manager",0721123452));
    }


    @Override
    public int getCount() {
        return datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.contact_info,parent,false);
        }

        BizCardDataSource dataSrc = datasource.get(position);

        TextView job_title = (TextView) view.findViewById(R.id.job_title);
        job_title.setText(dataSrc.getTitle());

        TextView cell_number = (TextView) view.findViewById(R.id.cell_number);
        cell_number.setText("" + dataSrc.getTitle());

        return view;
    }
}
