package com.example.nigma.resepmakanan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private LinkedList<ModelMasakan> listResep = new LinkedList<>();
    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Panggil fungsi untuk mendapat data resep makanan
        listResep = kumpulanResep();

        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, listResep);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    // fungsi untuk mendata resep makanan secara statis
    private LinkedList<ModelMasakan> kumpulanResep(){
        LinkedList<ModelMasakan> listMasakan = new LinkedList<>();
        String[] bahan;
        String[] tahap;

        bahan = new String[]{
                "Minyak Goreng",
                "Krupuk Mentah"
        };
        tahap = new String[]{
                "Siapkan alat dan bahan.",
                "Panaskan minyak dalam wajan.",
                "Masukkan krupuk mentah ke dalam minyak yang sudah dipanaskan.",
                "Aduk-aduk sampai mengembang.",
                "Tiriskan krupuk.",
                "Pindah krupuk ke toples, krupuk siap disantap."
        };
        listMasakan.addLast(new ModelMasakan("Krupuk Goreng","kerupuk","Bergizi tinggi, ringan, dan tahan lama. Tidak mudah patah dan kriuk kriuk",bahan,tahap));

        bahan = new String[]{
                "1 kantung Teh Celup",
                "2 sdt Gula",
                "50 ml air panas",
                "100 ml air dingin",
                "Es Batu secukupnya"
        };
        tahap = new String[]{
                "Siapkan teh celup kedalam mug, tambahkan gula pasir, tuangi air panas, lalu aduk sampai gula larut.",
                "Tambahkan air dingin kedalam campuran teh tadi, aduk rata, tambahkan es batu sesuai selera.",
                "Duduk manis dan siap dinikmati."
        };
        listMasakan.addLast(new ModelMasakan("Es Teh Manis","teh","Es teh dengan kesegaran tiada duanya, manisnya bikin jeger. mudah dibuat dan cocok untuk mahasiswa.",bahan,tahap));

        bahan = new String[]{
                "Air",
                "1 buah sosis kimbo beef (uk. Besar, potong dadu)",
                "1 buah tahu (potong dadu)",
                "Garam",
                "Gula pasir",
                "Kaldu jamur",
                "1 siung bawang putih (iris tipis)",
                "1 lembar daun bawang (iris)",
                "Merica"

        };
        tahap = new String[]{
                "Tumis bawang putih & bawang daun sebentar di panci.",
                "Masukkan air secukupnya (±2,5 mangkok).",
                "Masukkan bumbu garam : gula : kaldu jamur dengan perbandingan (1:1:2,5 jumput).",
                "Aduk-aduk air yang sudah dibumbui. Masukkan sosis & tahu. Masukkan merica. Didihkan."
        };
        listMasakan.addLast(new ModelMasakan("Sop Sosis Tahu","sop","Sop sosis tahu, mudah dibuat dan harga terjangkau, cocok untuk anak kos. Bergizi dan tidak tahan lama",bahan,tahap));


        bahan = new String[]{
                "1 buah jagung di sisirin",
                "1 butir Telur",
                "Daun bawang yg udh di potong",
                "2 sdm tepung terigu",
                "1 sdm tepung beras",
                "4 siung bawang putih",
                "1 sdt garam",
                "1/2 sdt masako",
                "1/2 sdt lada",
                "Minyak"

        };
        tahap = new String[]{
                "Sediakan baskom, masukan jagung yang udah di sisirin dan daun bawangnya.",
                "Masukan bumbu ulek (bawang putih dan lada) ke dalam baskom. Aduk-aduk sampai merata.",
                "Masukan tepung terigu dan tepung beras. Lalu masukan telur. Kemudian aduk-aduk sampai merata.",
                "Masukan garam, lada, masako ke dalam baskom tsb. Lalu aduk-aduk sampai merata.",
                "Panaskan minyak. Lalu saat minyaknya mulai panas, masukan adonan bakwan jagung ke dalam wajan",
                "Balikin bakwannya biar merata matangnya. Jika bakwan sudah berwarna kecoklatan. Matikan kompor dan tiriskan bakwannya",
                "Lalu sajikan ke dalam piring dan siap di makan"
        };
        listMasakan.addLast(new ModelMasakan("Bakwan Jagung","bakwan","Bakwan jagung hangat, mudah dibuat. Rasa tiada duanya, resep gila tiada tanding. Bergizi tinggi, kaya akan protein",bahan,tahap));
        return listMasakan;
    }
}
