package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Button plusBtn;
    private Button minuszBtn;
    private Button tippBtn;
    private ImageView h1;
    private ImageView h2;
    private ImageView h3;
    private ImageView h4;
    private  ImageView[] hpTomb;
    private TextView tippErtek;
    private int tipp;
    private int gondolt;
    private Random rnd;
    private int elet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();


    }

    private void addListener()
    {
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (tipp < 10)
                {
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "A gondolt szam nem lehet nagyobb mint 10", Toast.LENGTH_LONG).show();
                }

            }
        });

        minuszBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (tipp > 10)
                {
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                }
                else
                {
                    Toast.makeText(MainActivity.this,
                            "A gondolt szam nem lehet kisebb mint 10", Toast.LENGTH_LONG).show();
                }

            }
        });

        tippBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (tipp < gondolt)
                {
                    Toast.makeText(MainActivity.this,
                            "A gondolt szam nagyobb", Toast.LENGTH_SHORT).show();

                }
                else if (tipp > gondolt)
                {
                    elet--;
                    Toast.makeText(MainActivity.this,
                            "A gondolt szam kisebb", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    // TODO: gyozelem
                }
            }


        });
    }
    private void eletCsokkentSwitchCase()
    {
        elet--;
        switch (elet)
        {
            case 3:
                h4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                h3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                h2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                h1.setImageResource(R.drawable.heart1);
                break;
        }
        if (elet == 0)
        {
            // TODO: jatek veget ert
        }
    }

    private void EletCsokken()
    {
        if (elet > 0)
        {
            elet--;
            hpTomb[elet].setImageResource(R.drawable.heart1);
        }

        if (elet == 0)
        {
            // TODO: jatek veget ert
        }
    }

    private void init()
    {
        plusBtn = findViewById(R.id.plus_btn);
        minuszBtn = findViewById(R.id.minusz_btn);
        tippBtn = findViewById(R.id.tipp_btn);
        h1 = findViewById(R.id.hp_1);
        h2 = findViewById(R.id.hp_2);
        h3 = findViewById(R.id.hp_3);
        h4 = findViewById(R.id.hp_4);
        hpTomb = new ImageView[] {h1, h2 ,h3 ,h4};
        tippErtek = findViewById(R.id.tipp_ertek);
        tipp = 1;
        rnd = new Random();
        gondolt = rnd.nextInt(10) + 1;
        Log.d("gondolt", String.valueOf(gondolt));
        elet = 4;
    }
}