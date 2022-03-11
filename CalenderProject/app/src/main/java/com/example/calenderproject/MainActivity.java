package com.example.calenderproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btn;
    private RecyclerView recyclerView;
    private RecycleViewAdapter adapter;

    private static ArrayList<Alarm> allAlarms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //allAlarms=new ArrayList<>();
        // we don't need to initialise as it is static so it will automatically get initialised

        if(allAlarms==null)
        {
            allAlarms=new ArrayList<>();
        }

        btn=findViewById(R.id.btnAddAlarm);
        recyclerView =findViewById(R.id.recyclerView);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAlarms(allAlarms);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AlarmActivity.class);
                startActivity(intent);

            }
        });
        try{
            Intent intent=getIntent();
            Bundle bundle=intent.getBundleExtra(getString(R.string.bundle));
            if(bundle!=null){
                int hours=bundle.getInt(getString(R.string.hours),-1);
                int min=bundle.getInt(getString(R.string.minutes),-1);

                if(hours!=-1){
                    if(min!=-1){
                        Intent alarmIntent=new Intent(AlarmClock.ACTION_SET_ALARM);
                        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hours);
                        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES,min);

                        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE,"Hello from other side");

                        Alarm alarm = new Alarm(hours,min,"Hello from other side");
                        allAlarms.add((alarm));
                        adapter.setAlarms(allAlarms);
                        startActivity(alarmIntent);
                    }
                 }
            }
        }catch(Exception e){
            Log.d(TAG, "onCreate: Something happened");
            e.printStackTrace();
        }

    }
}