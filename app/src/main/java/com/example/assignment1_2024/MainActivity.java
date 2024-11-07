package com.example.assignment1_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioG;
    private RadioButton rb;
    private CheckBox chkMin;
    private CheckBox chkMid;
    private CheckBox chkMax;
    private Button btnSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
        onClickSelect();
    }

    private void setUpViews(){
        radioG= findViewById(R.id.radioG);
        chkMin= findViewById(R.id.chkMin);
        chkMid= findViewById(R.id.chkMid);
        chkMax= findViewById(R.id.chkMax);
        btnSelect= findViewById(R.id.btnSelect);
    }

    private void onClickSelect(){
        Intent intent = new Intent(this, TipsActivity.class);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb = findViewById(radioG.getCheckedRadioButtonId());
                String gender= rb.getText().toString();
                intent.putExtra("gender", gender);

                String age= getSelectedAgeGroup();
                intent.putExtra("age", age);

                startActivity(intent);
            }
        });
    }

    private String getSelectedAgeGroup() {
        if (chkMin.isChecked()) return "Under 18";
        if (chkMid.isChecked()) return "18-40";
        if (chkMax.isChecked()) return "Over 40";
        return "";
    }
}