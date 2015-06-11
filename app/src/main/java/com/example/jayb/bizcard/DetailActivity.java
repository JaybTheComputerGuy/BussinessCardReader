package com.example.jayb.bizcard;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jayb on 6/11/15.
 */
public class DetailActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if(savedInstanceState == null){
            String name = getIntent().getStringExtra("name");
            String cell = getIntent().getStringExtra("cell_number");
            String job_title = getIntent().getStringExtra("job_title");
            String email = getIntent().getStringExtra("email");
            String url = getIntent().getStringExtra("url");

            TextView names = (TextView)findViewById(R.id.name);
            names.setText(name);
            TextView phone_number = (TextView)findViewById(R.id.phone_number);
            phone_number.setText(cell);
            TextView occupation = (TextView)findViewById(R.id.occupation);
            occupation.setText(job_title);
            TextView email_address = (TextView)findViewById(R.id.email_address);
            email_address.setText(email);
            TextView web_url = (TextView)findViewById(R.id.web_url);
            web_url.setText(url);

        }
    }
}
