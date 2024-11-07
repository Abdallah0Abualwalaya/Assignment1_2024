package com.example.assignment1_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TipsActivity extends AppCompatActivity {
    private TextView txtInfo;
    private EditText edtName;
    private Spinner spnWeight;
    private Button btnShow;
    private ListView lstTips;
    private FloatingActionButton fabBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        setUpViews();
        bindSpinner();
        onClickShow();
        onClickBack();

        Intent intent = getIntent();
        String gender = intent.getStringExtra("gender");
        String age = intent.getStringExtra("age");
        txtInfo.setText(gender + "\n" + age);
    }

    private void setUpViews(){
        txtInfo= findViewById(R.id.txtInfo);
        edtName= findViewById(R.id.edtName);
        spnWeight= findViewById(R.id.spnWeight);
        btnShow= findViewById(R.id.btnShow);
        lstTips= findViewById(R.id.lstTips);
        fabBack= findViewById(R.id.fabBack);
    }

    private void bindSpinner(){
        String[] arr= Tips.getWeightTypes();
        ArrayAdapter<String> spnAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arr);
        spnWeight.setAdapter(spnAdapter);
    }

    private void onClickShow(){
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weightType = spnWeight.getSelectedItem().toString();
                List<Tips> tips = Tips.getTipsByType(weightType);
                Tips[] arr = tips.toArray(new Tips[tips.size()]);
                ArrayAdapter<Tips> adapter = new ArrayAdapter<>(TipsActivity.this, android.R.layout.simple_list_item_1, arr);
                lstTips.setAdapter(adapter);

                String name = getUserName(edtName.getText().toString());

                AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(TipsActivity.this, DetailTipActivity.class);
                        intent.putExtra("tip_index", position); // Pass the position of the tip
                        intent.putExtra("weight_type", weightType); // Pass the selected weight type
                        intent.putExtra("name", name);
                        startActivity(intent);
                    }
                };
                lstTips.setOnItemClickListener(itemClickListener);
            }
        });
    }


    private String getUserName(String name){
        if(name.trim().isEmpty()){
            Toast.makeText(TipsActivity.this, "Should Enter Your Name!", Toast.LENGTH_SHORT).show();
        }
        return name;
    }

    private void onClickBack(){
        Intent intent2 = new Intent(this, MainActivity.class);
        fabBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent2);
            }
        });
    }
}