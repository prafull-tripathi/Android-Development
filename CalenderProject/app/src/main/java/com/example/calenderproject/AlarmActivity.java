package com.example.calenderproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlarmActivity extends AppCompatActivity {

    private static final String TAG = "Alarm Activity";
    private EditText edHr, edMin;
    private Button btnAddAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        btnAddAlarm =findViewById(R.id.btnAddNewAlarm);
        edHr=findViewById(R.id.editTxtHr);
        edMin=findViewById(R.id.editTxtMin);

        btnAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewAlarm();
            }
        });
    }

    private void addNewAlarm() {
        Log.d(TAG, "addNewAlarm: started");
        int hours= Integer.valueOf(edHr.getText().toString());
        int min=Integer.valueOf(edMin.getText().toString());

        Bundle bundle=new Bundle();
        bundle.putInt(getString(R.string.hours),hours);
        bundle.putInt(getString(R.string.minutes), min);

        Intent intent=new Intent(AlarmActivity.this,MainActivity.class);
        //we don't want user to come back to this activity so we use flags:
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(getString(R.string.bundle), bundle);
        startActivity(intent);

    }
}