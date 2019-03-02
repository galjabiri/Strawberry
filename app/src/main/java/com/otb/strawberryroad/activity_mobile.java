package com.otb.strawberryroad;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class activity_mobile extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton buttonAddMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile);

        // List All mobile numbers
        recyclerView = findViewById(R.id.recyclerview_mobiles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        buttonAddMobile = findViewById(R.id.floatingActionButton_Add_Mobile);
        buttonAddMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_mobile.this, activity_add_mobile.class);
                startActivity(intent);
            }
        });


        getMobiles();
    }
    private void getMobiles() {
        class GetMobiles extends AsyncTask<Void, Void, List<Mobile>> {

            @Override
            protected List<Mobile> doInBackground(Void... voids) {
                return DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .mobileDao()
                        .getAll();
            }

            @Override
            protected void onPostExecute(List<Mobile> mobiles) {
                super.onPostExecute(mobiles);
                MobilesAdapter adapter = new MobilesAdapter(activity_mobile.this, mobiles);
                recyclerView.setAdapter(adapter);
            }
        }

        GetMobiles gt = new GetMobiles();
        gt.execute();
    }

}
