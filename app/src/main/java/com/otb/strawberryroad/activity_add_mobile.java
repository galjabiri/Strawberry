package com.otb.strawberryroad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class activity_add_mobile extends AppCompatActivity {

    private EditText editTextNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mobile);

        editTextNumber=findViewById(R.id.editText_number);

        findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMobile();
            }
        });
    }

    private void saveMobile() {

        final String sNumber = editTextNumber.getText().toString().trim();
        if (sNumber.isEmpty()) {
            editTextNumber.setError("Number required");
            editTextNumber.requestFocus();
            return;
        }

        class SaveMobile extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                //creating a mobile
                Mobile mobile = new Mobile();
                mobile.setNumber(sNumber);
                mobile.setDefault_one(false);
                mobile.setVerified(false);
                //adding to database
                DatabaseClient.getInstance(getApplicationContext()).getAppDatabase()
                        .mobileDao()
                        .insert(mobile);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                finish();
                startActivity(new Intent(getApplicationContext(), activity_mobile.class));
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();
            }
        }

        SaveMobile sm = new SaveMobile();
        sm.execute();
    }
}
