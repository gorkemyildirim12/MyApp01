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
import com.capstone.repositories.RightFootRepository;

public class RightFootDataListActivity extends AppCompatActivity {
    private ListView rightFootDataListView;
    private RightFootRepository rightFootRepository;
    private TextView patientName;
    private TextView patientAge;
    private TextView patientHeight;
    private TextView patientWeight;
    private TextView shoeNumber;
    private Patient patient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_foot_data_list);
        rightFootDataListView = findViewById(R.id.rightFootDataList);
        patientName = findViewById(R.id.patientNameView);
        patientAge = findViewById(R.id.patientAgeView);
        patientHeight = findViewById(R.id.patientHeightView);
        patientWeight = findViewById(R.id.patientWeightView);
        shoeNumber = findViewById(R.id.patientShoeView);

        rightFootRepository = new RightFootRepository(this);
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
        rightFootRepository.close();
    }

    public void showData(){
        Cursor cursor = rightFootRepository.list();
        int to[] = {R.id.footTypeIdView , R.id.groundReactForceView , R.id.strideTimeView};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this , R.layout.row_layout_foot , cursor , rightFootRepository.FOOT_COLUMNS , to);
        rightFootDataListView.setAdapter(adapter);
    }

    public void onClickPatientInfoButton(View view) {
        Intent intent = new Intent(this,PatientInfoActivity.class);
        startActivity(intent);

    }

    public void onClickLeftFootButton(View view) {
        Intent intent = new Intent(this,LeftFootDataListActivity.class);
        intent.putExtra("patient" , patient);
        startActivity(intent);

    }
}
