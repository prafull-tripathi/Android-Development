package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private ImageView img, imgView;
    private TextView txt;
    Animation animRotate, animSlideUp,animSlideDown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initwidgets();

        Handler handler = new Handler();

        animSlideUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        animSlideDown = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        btn.startAnimation(animSlideDown);
        img.startAnimation(animSlideDown);
        txt.startAnimation(animSlideDown);



        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);
        img.startAnimation(animRotate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand= new Random();
                int rollBack= rand.nextInt(6)+1;

                switch (rollBack){
                    case 1:
                        img.startAnimation(animRotate);
                        imgView.setImageResource(R.drawable.dice1);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("1");
                            }
                        },2000);

                        break;
                    case 2:
                        img.startAnimation(animRotate);
                        img.setVisibility(View.GONE);
                        imgView.setImageResource(R.drawable.dice2);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("2");
                            }
                        },2000);
                        break;
                    case 3:
                        img.startAnimation(animRotate);
                        img.setVisibility(View.GONE);
                        imgView.setImageResource(R.drawable.dice3);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("3");
                            }
                        },2000);
                        break;
                    case 4:
                        img.startAnimation(animRotate);
                        imgView.setVisibility(View.VISIBLE);
                        imgView.setImageResource(R.drawable.dice4);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("4");
                            }
                        },2000);
                        break;
                    case 5:
                        img.startAnimation(animRotate);
                        imgView.setVisibility(View.VISIBLE);
                        imgView.setImageResource(R.drawable.dice5);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("5");
                            }
                        },2000);
                        break;
                    case 6:
                        img.startAnimation(animRotate);
                        imgView.setVisibility(View.VISIBLE);
                        imgView.setImageResource(R.drawable.dice6);
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                txt.setText("6");
                            }
                        },2000);
                        break;
                    default:
                        break;



                }


            }
        });

    }

    private void initwidgets() {
        btn=(Button) findViewById(R.id.btnRoll);
        img=findViewById(R.id.imageDice);
        imgView=findViewById(R.id.permanentDice);
        txt=findViewById(R.id.txtDice);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_up,R.anim.slide_down);
    }
}