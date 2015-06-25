package com.example.jayb.bizcard;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.jayb.bizcard.data.BizCardDatabaseHelper;


public class BizCard extends ActionBarActivity {
    public static final int CONTACT_REQUEST_ENTRY_CODE = 1;
    private BizCardDatabaseHelper databaseHelper;
    private BizCardAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        populateListView();
        databaseHelper = new BizCardDatabaseHelper(this);
        registerButtonCallBack(); //When you want to add a new contact info


    }


    private void registerButtonCallBack() {
        final Button btn_add = (Button)findViewById(R.id.btn_camera);

        btn_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Camera implementation...
            }
        });

    }

    private void populateListView(){
        databaseHelper = new BizCardDatabaseHelper(this);
        Cursor contact_list = databaseHelper.getAllRecords();
        adapter = new BizCardAdapter(this,contact_list);
        ListView list = (ListView)findViewById(R.id.contacts_list);
        list.setAdapter(adapter);
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

        if(id == R.id.add_contact_menu){
            Intent intent = new Intent(this,AddContacts.class);
            startActivityForResult(intent,CONTACT_REQUEST_ENTRY_CODE);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        if(requestcode == CONTACT_REQUEST_ENTRY_CODE){
            if(resultcode == RESULT_OK){
                String name = data.getStringExtra("first_name");
                name += data.getStringExtra("last_name");
                String num = data.getStringExtra("phone_number");
                String email = data.getStringExtra("email");
                String url = data.getStringExtra("url");
                String title = data.getStringExtra("title");

                databaseHelper.saveContacts(name, num, title, url, email);
                adapter.changeCursor(databaseHelper.getAllRecords());

            }

        }
    }

}
