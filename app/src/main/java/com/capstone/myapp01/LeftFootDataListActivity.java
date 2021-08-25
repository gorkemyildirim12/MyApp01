package com.capstone.myapp01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;


import com.capstone.entity.Patient;
import com.capstone.repositories.LeftFootRepository;

public class LeftFootDataListActivity extends AppCompatActivity {
    private ListView leftFootDataView;
    private LeftFootRepository leftFootRepository;
    private TextView patientName;
    private TextView patientAge;
    private TextView patientHeight;
    private TextView patientWeight;
    private TextView shoeNumber;
    private Patient patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_foot_data_list);

        patientName = findViewById(R.id.patientNameView);
        patientAge = findViewById(R.id.patientAgeView);
        patientHeight = findViewById(R.id.patientHeightView);
        patientWeight = findViewById(R.id.patientWeightView);
        shoeNumber = findViewById(R.id.patientShoeView);

        leftFootDataView = findViewById(R.id.leftFootDataList);
        leftFootRepository = new LeftFootRepository(this);

        showData();

       Intent i = getIntent();
       patient = (Patient) i.getSerializableExtra("patient");

       patientName.setText(patient.fullName());
       patientAge.setText(String.valueOf(patient.getPatientAge()));
       patientHeight.setText(String.valueOf(patient.getPatientHeight()));
       patientWeight.setText(String.valueOf(patient.getPatientWeight()));
       shoeNumber.setText(String.valueOf(patient.getShoeNumber()));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        leftFootRepository.close();
    }

    public void showData(){
        Cursor cursor = leftFootRepository.list();
        int to[] = {R.id.footTypeIdView , R.id.groundReactForceView , R.id.strideTimeView};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this , R.layout.row_layout_foot , cursor , leftFootRepository.FOOT_COLUMNS , to);
        leftFootDataView.setAdapter(adapter);
    }

    public void onClickPatientInfoButton(View view) {
        Intent intent = new Intent(this,PatientInfoActivity.class);
        startActivity(intent);

    }

    public void onClickRightFootButton(View view) {
        Intent intent = new Intent(this,RightFootDataListActivity.class);
        intent.putExtra("patient" , patient);
        startActivity(intent);
    }
}
