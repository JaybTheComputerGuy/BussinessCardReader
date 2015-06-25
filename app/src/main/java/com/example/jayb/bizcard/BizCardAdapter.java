package com.example.jayb.bizcard;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jayb on 6/8/15.
 */
public class BizCardAdapter extends CursorAdapter {

    public BizCardAdapter(Context context,Cursor cursor){
        super(context,cursor);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent){
        return LayoutInflater.from(context).inflate(R.layout.contact_info,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor){
        TextView titleView = (TextView) view.findViewById(R.id.job_title);
        titleView.setText(cursor.getString(cursor.getColumnIndex("Title")));
        TextView cell_number = (TextView)view.findViewById(R.id.cell_number);
        cell_number.setText(cursor.getString(cursor.getColumnIndex("cell")));
    }
}
