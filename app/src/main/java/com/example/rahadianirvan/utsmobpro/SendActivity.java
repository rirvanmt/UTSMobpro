package com.example.rahadianirvan.utsmobpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SendActivity extends AppCompatActivity {

    public static final String intent_nama_pengirim = "pengirim";
    public static final String intent_teman="penerima";
    public static final String intent_pesan="pesan";
    public static final Integer intent_gambar=0;

    EditText ePesan, ePengirim;
    Spinner SpTeman;
    Button bSubmit;
    TextView tNamaCake;
    String tCake, tPengirim, tPesan, tPenerima;
    Integer gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        tNamaCake=(TextView) findViewById(R.id.NamaCake);
        ePengirim=(EditText) findViewById(R.id.NamaPengirim);
        ePesan=(EditText) findViewById(R.id.EdPesan);
        bSubmit=(Button) findViewById(R.id.BtnSubmit);
        SpTeman=(Spinner) findViewById(R.id.SpTeman);

        final Intent intent=getIntent();
        tCake=intent.getStringExtra(MainActivity.intent_cake);
        gambar=intent.getIntExtra(String.valueOf(MainActivity.intent_gambar),0);

        tNamaCake.setText(tCake);

        bSubmit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPenerima=String.valueOf(SpTeman.getSelectedItem());
                tPesan=String.valueOf(ePesan.getText());
                tPengirim=String.valueOf(ePengirim.getText());

                Intent i = new Intent(SendActivity.this, GiftActivity.class);

                i.putExtra(intent_teman, tPenerima);
                i.putExtra(intent_nama_pengirim, tPengirim);
                i.putExtra(intent_pesan, tPesan);
                i.putExtra(String.valueOf(intent_gambar), gambar);

                startActivity(i);
            }
        });
    }
}
