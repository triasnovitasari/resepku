package com.example.nigma.resepmakanan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ResepPreview extends AppCompatActivity {
    TextView titleV;
    TextView bahanV;
    TextView tahapanV;
    ImageView imageV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_preview);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        String bahan = "";
        String tahap = "";
        int n;

        titleV = (TextView)findViewById(R.id.title);
        bahanV = (TextView) findViewById(R.id.bahan);
        tahapanV = (TextView) findViewById(R.id.tahap);
        imageV = (ImageView) findViewById(R.id.image);


        int id = getResources().getIdentifier("com.example.nigma.resepmakanan:drawable/" + image, null, null);

        titleV.setText(title);
        imageV.setImageResource(id);

        n=1;
        for(String bahans : intent.getStringArrayExtra("bahan")){
            bahan += n+". " + bahans + "\n";
            n++;
        }
        n=1;
        for(String tahaps : intent.getStringArrayExtra("tahap")){
            tahap += n+". " + tahaps + "\n";
            Log.d("Word list", tahap);
            n++;
        }
        bahanV.setText(bahan);
        tahapanV.setText(tahap);

    }
}
