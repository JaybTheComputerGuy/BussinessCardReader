package com.example.jayb.bizcard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class BizCard extends ActionBarActivity {
    private ArrayList<BizCardDataSource> datasource = new ArrayList<BizCardDataSource>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        populateList();
        populateListView();
        registerButtonCallBack(); //When you want to add a new contact info
        registerListCallBack();

    }

    private void registerListCallBack(){
        ListView list = (ListView) findViewById(R.id.contacts_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position , long id){
                Intent newIntent = new Intent(getBaseContext(),DetailActivity.class);

                BizCardDataSource dataSrc = datasource.get(position);

                newIntent.putExtra("job_title",dataSrc.getTitle());
                newIntent.putExtra("name",dataSrc.getTitle());
                newIntent.putExtra("cell_number",dataSrc.getTitle());
                newIntent.putExtra("email",dataSrc.getTitle());
                newIntent.putExtra("url",dataSrc.getTitle());

            }
        });
    }

    private void registerButtonCallBack() {
        final Button btn_add = (Button)findViewById(R.id.btn_camera);

        btn_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Camera implementation...
            }
        });

    }

    private void populateListView() {
        ArrayAdapter<BizCardDataSource> adapter = new MyListAdapter();
        ListView list = (ListView)findViewById(R.id.contacts_list);
        list.setAdapter(adapter);
    }

    private void populateList() {
        datasource.add(new BizCardDataSource("Finance Manager",0720123456,"www.bizcard.com","bizcard@gmail.com","Dennis Ochieng"));
        datasource.add(new BizCardDataSource("System Administrator",0712345671,"www.trello.com","jayb@trello.com","Emmanuel Jayb"));
        datasource.add(new BizCardDataSource("Project Manager",0723123426,"www.sana.org","ougo@gmail.com","Ougo Ken"));
        datasource.add(new BizCardDataSource("Infrastructure Manager",0721123452,"www.takaka.com","wini@gmail.com","Winnie Akinyi"));
        datasource.add(new BizCardDataSource("Accountant",0720123456,"www,favourandmercy.or.ke","favour@gmail.com","Grace sewe"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_biz_card, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyListAdapter extends ArrayAdapter<BizCardDataSource>{
        public MyListAdapter() {
            super(BizCard.this, R.layout.contact_info,datasource);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent){
            View itemView = view;

            if(view == null){
                 itemView = getLayoutInflater().inflate(R.layout.contact_info, parent, false);
            }

            BizCardDataSource dataSrc = datasource.get(position);

            TextView job_title = (TextView) itemView.findViewById(R.id.job_title);
            job_title.setText(dataSrc.getTitle());

            TextView cell_number = (TextView) itemView.findViewById(R.id.cell_number);
            cell_number.setText("" + dataSrc.getNumber());

            return itemView;
        }
    }
}
