package com.otb.strawberryroad;

import android.content.Intent;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.options_update_location:
                updateLocation();
                return true;
            case R.id.options_share_app:
                share();
                return true;
            case R.id.options_update_mobile_number:
                updateMobile();
                return true;
            case R.id.options_contact_us:
                chat();
                return true;
            case R.id.options_my_orders:
                orders();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void updateLocation(){
        Intent intent = new Intent(this,activity_location_2.class);
        startActivity(intent);

    }

    private void updateMobile(){
        Intent intent = new Intent(this,activity_mobile.class);
        startActivity(intent);
    }

    private void chat(){
        Intent intent = new Intent(this,activity_chat.class);
        startActivity(intent);
    }

    private void orders(){
        Intent intent = new Intent(this,activity_orders.class);
        startActivity(intent);
    }

    private void share(){
        Intent intent = new Intent(this,activity_share.class);
        startActivity(intent);
    }
}
