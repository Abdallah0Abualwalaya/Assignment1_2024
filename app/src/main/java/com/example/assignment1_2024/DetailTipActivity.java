package com.example.assignment1_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DetailTipActivity extends AppCompatActivity {
    private ImageView imgDetail;
    private TextView txtDetail;
    private ListView lstDetail;
    private FloatingActionButton fabBackDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tip);
        setUpViews();
        onClickBack();

        Intent intent = getIntent();
        int id = (int)intent.getExtras().get("tip_id");

        Tips tips= Tips.tips[id];

        imgDetail.setImageResource(tips.getImageID());

        String detailsText = "Tip1: " + tips.getTip1() + "\n\nTip2: " + tips.getTip2() + "\n\nTip3: " + tips.getTip3();
        txtDetail.setText(detailsText);

        String name= intent.getStringExtra("name");

        String[] locations = {name + " can going to Green Apple health center in Ramallah\n",
                              "\n" + name + " can going to TrustCare Medical Group health center in Jerusalem\n",
                              "\n" + name + " can going to Premier health center in Hebron\n",
                              "\n" + name + " can going to Harmony Women’s health center in Nablus\n",
                              "\n" + name + " can going to Serene Mental health center in Jenin\n",
                              "\n" + name + " can going to LifeLine Physical Therapy health center in Tolkarm\n",
                              "\n" + name + " can going to Wellness Path Chiropractic health center in Jerico\n",
                              "\n" + name + " can going to Peak Performance Sports Medicine health center in BeitLahm\n",
                              "\n" + name + " can going to Serene Mental health center in Safad\n"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locations);
        lstDetail.setAdapter(adapter);
    }

    private void setUpViews(){
        imgDetail= findViewById(R.id.imgDetail);
        txtDetail= findViewById(R.id.txtDetail);
        lstDetail= findViewById(R.id.lstDetail);
        fabBackDetail= findViewById(R.id.fabBackDetail);
    }

    private void onClickBack(){
        Intent intent4= new Intent(this, TipsActivity.class);
        fabBackDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(intent4);
            }
        });
    }
}