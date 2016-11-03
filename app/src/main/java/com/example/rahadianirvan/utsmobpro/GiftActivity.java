package com.example.rahadianirvan.utsmobpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
public class GiftActivity extends AppCompatActivity {

    TextView tPenerima, tPengirim, tPesan;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gift);

        tPenerima=(TextView) findViewById(R.id.NamaPenerima);
        tPengirim=(TextView) findViewById(R.id.NamaPengirim);
        tPesan=(TextView) findViewById(R.id.Pesan);
        img=(ImageView) findViewById(R.id.GambarCake);

        final Intent intent=getIntent();
        tPengirim.setText("From : "+intent.getStringExtra(SendActivity.intent_nama_pengirim));
        tPenerima.setText("To : "+intent.getStringExtra(SendActivity.intent_teman));
        tPesan.setText(intent.getStringExtra(SendActivity.intent_pesan));
        img.setImageResource(intent.getIntExtra(String.valueOf(SendActivity.intent_gambar),0));
    }
}
