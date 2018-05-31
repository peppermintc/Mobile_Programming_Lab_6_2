package org.androidtown.lab_6_2;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText student_number;
    EditText student_name;
    Button load_button;
    Button save_button;
    Button reset_button;

    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student_number = findViewById(R.id.sn);
        student_name = findViewById(R.id.name);
        load_button = findViewById(R.id.load_btn);
        save_button = findViewById(R.id.save_btn);
        reset_button = findViewById(R.id.reset_btn);

        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //불러오기
                applySharedPreference();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //저장하기
                sharedPrefernces();
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //초기화
                clearSharedPreference();
            }
        });
    }

    //shared preference 저장하기
    public void sharedPrefernces() {
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("Student Number", student_number.getText().toString());
        toEdit.putString("Student Name", student_name.getText().toString());
        toEdit.commit();
    }

    //shared preference 불러오기
    public void applySharedPreference(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("Student Number")) {
            String number = sh_Pref.getString("Student Number","...");
            student_number.setText(number);
            String name = sh_Pref.getString("Student Name","...");
            student_name.setText(name);
        }
    }

    //edittext 초기화
    public void clearSharedPreference() {
        student_number.getText().clear();
        student_name.getText().clear();
    }
}
