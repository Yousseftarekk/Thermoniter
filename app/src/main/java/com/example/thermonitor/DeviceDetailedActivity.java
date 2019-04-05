package com.example.thermonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.FirebaseApp;

public class DeviceDetailedActivity extends AppCompatActivity {

    Firebase myFirebase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_detailed);
        final TextView myTextview=(TextView) findViewById(R.id.textView7);

        Firebase.setAndroidContext(getApplicationContext());

        myFirebase= new Firebase("https://thermonitor-69fc9.firebaseio.com/");
        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Integer myChildText= dataSnapshot.getValue(Integer.class);
                myTextview.setText(myChildText);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                myTextview.setText("Error Found");

            }
        });



    }
}
