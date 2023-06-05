package com.example.quranpakapp522;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class SurahPage extends AppCompatActivity {

    TextView AyatsView;
    TextView SurahName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_page);
        AyatsView = findViewById(R.id.textView2);
        SurahName = findViewById(R.id.SurahName);


        AyatsView.setText("");
        Intent I = getIntent();

        try {
            QDH QDHObject = new QDH();
            QuranArabicText Arabic = new QuranArabicText();
            I.getStringExtra("surahIndex");
            int surahIndex = I.getIntExtra("surahIndex", -1);
            if(surahIndex==-1)
                throw new Exception();


            SurahName.setText(QDHObject.urduSurahNames[surahIndex]);
            String[] Ayat = Arabic.GetData(QDHObject.SSP[surahIndex],QDHObject.surahAyatCount[surahIndex]+QDHObject.SSP[surahIndex]);
            String tmp = "";

            for (int i = 0; i <Ayat.length-1; i++) {
                tmp+=Ayat[i];
//                AyatsView.setText(AyatsView.getText().toString()+Ayat[i] + "\t\t");
            }

            AyatsView.setText(tmp);

           // Ayats.setText(Arabic.GetData(QDHObject.SSP[surahIndex],QDHObject.surahAyatCount[surahIndex]+QDHObject.SSP[surahIndex]).toString());
        }

        catch (Exception E)
        {
            Toast.makeText(this, E.toString(), Toast.LENGTH_LONG).show();
        }

    }
}