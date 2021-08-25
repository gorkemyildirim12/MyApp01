package com.capstone.myapp01;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.capstone.entity.FootType;
import com.capstone.entity.Patient;
import com.capstone.entity.Record;
import com.capstone.repositories.LeftFootRepository;
import com.capstone.repositories.PatientRepository;
import com.capstone.repositories.RightFootRepository;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Random;

public class PatientListActivity extends AppCompatActivity {
    private ListView patientListView;
    private PatientRepository patientRepository;
    private LeftFootRepository leftFootRepository;
    private RightFootRepository rightFootRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);
        patientListView = findViewById(R.id.patientListView);
        patientRepository = new PatientRepository(this);
        leftFootRepository = new LeftFootRepository(this);
        rightFootRepository = new RightFootRepository(this);
        showPatientList();

    }

      private void showPatientList(){
        Cursor cursor = patientRepository.list();
        int[] to ={R.id.patientIdView , R.id.patientNameView , R.id.patientSurnameView , R.id.patientGenderView ,
                R.id.emailView , R.id.patientAgeView , R.id.patientHeightView , R.id.patientWeightView ,R.id.shoeNumberView};
        final SimpleCursorAdapter adapter = new SimpleCursorAdapter(this , R.layout.row_layout ,cursor ,PatientRepository.PATIENT_COLUMNS ,to);
        patientListView.setAdapter(adapter);

        patientListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Record record = new Record();


                double lowGRF = 150.0;
                double highGRF = 300.0;
                double lowST = 0.2;
                double highST = 1.1;

                for(int i = 0; i<=5; i++){
                    double groundReactionForce = lowGRF + (Math.random() * (highGRF - lowGRF));
                    record.setGroundReactForce(groundReactionForce);

                    double strideTime = lowST + (Math.random() * (highST - lowST));
                    record.setStrideTime(strideTime);

                    FootType footType = new FootType();
                    footType.setLeftFoot(record);

                    leftFootRepository.insert(footType);
                }

                for(int i = 0; i<= 5; i++){
                    double groundReactionForce = lowGRF + (Math.random() * (highGRF - lowGRF));
                    record.setGroundReactForce(groundReactionForce);

                    double strideTime = lowST + (Math.random() * (highST - lowST));
                    record.setStrideTime(strideTime);

                    FootType footType = new FootType();
                    footType.setRightFoot(record);

                    rightFootRepository.insert(footType);
                }


                Patient patient = new Patient();
                patient.setPatientId(id);
                Cursor patientCursor = patientRepository.find(patient);

                int idIndex = patientCursor.getColumnIndex("_id");
                int nameIndex = patientCursor.getColumnIndexOrThrow("patientName");
                int surnameIndex = patientCursor.getColumnIndexOrThrow("patientSurname");
                int patientGenderIndex = patientCursor.getColumnIndexOrThrow("patientGender");
                int emailIndex = patientCursor.getColumnIndexOrThrow("email");
                int patientAgeIndex = patientCursor.getColumnIndexOrThrow("patientAge");
                int patientHeightIndex = patientCursor.getColumnIndexOrThrow("patientHeight");
                int patientWeightIndex = patientCursor.getColumnIndexOrThrow("patientWeight");
                int shoeNumberIndex = patientCursor.getColumnIndexOrThrow("patientShoeNumber");

                long patientId = patientCursor.getLong(idIndex);
                String patientName = patientCursor.getString(nameIndex);
                String patientSurname = patientCursor.getString(surnameIndex);
                String patientGender = patientCursor.getString(patientGenderIndex);
                String email = patientCursor.getString(emailIndex);
                int patientAge = patientCursor.getInt(patientAgeIndex);
                double patientHeight = patientCursor.getDouble(patientHeightIndex);
                double patientWeight = patientCursor.getDouble(patientWeightIndex);
                int shoeNumber = patientCursor.getInt(shoeNumberIndex);


                Patient newPatient = new Patient(patientId , patientName , patientSurname ,patientGender , email , patientAge , patientHeight , patientWeight, shoeNumber);

                Intent intent = new Intent(PatientListActivity.this,LeftFootDataListActivity.class);
                intent.putExtra("patient" , newPatient);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        leftFootRepository.close();
    }
}
