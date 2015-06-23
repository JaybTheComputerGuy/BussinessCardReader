package com.example.jayb.bizcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by jayb on 6/23/15.
 */
public class AddContacts extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
    }

    public void onCancel(View view){
        finish();
    }

    public void onSave(View view){
        Intent intent = getIntent();

        EditText first_name = (EditText)findViewById(R.id.edit_first_name);
        intent.putExtra("first_name",first_name.getText().toString());

        EditText last_name = (EditText)findViewById(R.id.edit_last_name);
        intent.putExtra("last_name",last_name.getText().toString());

        EditText email = (EditText)findViewById(R.id.edit_email);
        intent.putExtra("email",email.getText().toString());

        EditText title = (EditText)findViewById(R.id.edit_title);
        intent.putExtra("title",title.getText().toString());

        EditText url = (EditText)findViewById(R.id.edit_url);
        intent.putExtra("url",url.getText().toString());

        this.setResult(RESULT_OK,intent);
        finish();
    }
}
