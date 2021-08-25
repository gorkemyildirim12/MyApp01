package com.capstone.myapp01;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.capstone.entity.Patient;
import com.capstone.repositories.PatientRepository;

public class    PatientInfoActivity extends AppCompatActivity {
    private Patient patient;
    private EditText patientName;
    private EditText patientSurname;
    private Spinner gender;
    private EditText email;
    private EditText patientAge;
    private EditText patientHeight;
    private EditText patientWeight;
    private EditText patientShoeNumber;
    private PatientRepository patientRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        patientName =findViewById(R.id.patientName);
        patientSurname =findViewById(R.id.patientSurname);
        gender = findViewById(R.id.gender);
        email =findViewById(R.id.email);
        patientAge =findViewById(R.id.patientAge);
        patientHeight = findViewById(R.id.patientHeight);
        patientWeight = findViewById(R.id.patientWeight);
        patientShoeNumber = findViewById(R.id.shoeNumber);

        patientRepository = new PatientRepository(this);


        String[] arraySpinner = new String[]{"Male" , "Female"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.style_spinner, arraySpinner);
        gender.setAdapter(adapter);
    }

    public void onClickSave(View view){
        long patientId = 1;
        String message = "Form should be full filled";
        String name = patientName.getText().toString();
        String surname = patientSurname.getText().toString();
        String patientGender = gender.getSelectedItem().toString();
        String patientEmail = email.getText().toString();
        String age = patientAge.getText().toString();
        String height = patientHeight.getText().toString();
        String weight = patientWeight.getText().toString();
        String shoeNumber = patientShoeNumber.getText().toString();

        if(isEmpty(name) || isEmpty(surname) || isEmpty(patientGender) || isEmpty(patientEmail) || isEmpty(age) || isEmpty(height) ||
                isEmpty(height) || isEmpty(weight) || isEmpty(shoeNumber)){
            Toast.makeText(this , message , Toast.LENGTH_LONG).show();
        }else{
            int patientAge = Integer.parseInt(age);
            int patientHeight = Integer.parseInt(height);
            int patientWeight = Integer.parseInt(weight);
            int ShoeNumber = Integer.parseInt(shoeNumber);

            if (validateEmail()) {
                patient = new Patient(patientId, name , surname , patientGender , patientEmail , patientAge , patientHeight, patientWeight, ShoeNumber);

                patientRepository.insert(patient);


                Intent intent = new Intent(this,PatientListActivity.class);
                startActivity(intent);
                finish();
            }
            else{
                Toast.makeText(this,"E-mail is not valid",Toast.LENGTH_SHORT).show();
            }
        }

    }
    private boolean validateEmail() {
        String emailInput = email.getText().toString().trim();
        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            return false;
        } else {
            return true;
        }
    }
    private boolean isEmpty(String string){
        return TextUtils.isEmpty(string);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        patientRepository.close();
    }
}
