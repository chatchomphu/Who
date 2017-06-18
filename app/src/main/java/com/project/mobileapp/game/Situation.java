package com.project.mobileapp.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Situation extends AppCompatActivity {

    private ArrayList<String> friendList;
    private Random rand;
    private String who;
    private static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // define file had saved
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("status","unfrom2");
        editor.commit();

        // read value from file for add to friendList
        friendList = new ArrayList<String>();
        String filename = "info.txt";
        String inputString;
        try
        {
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(openFileInput(filename)));
            while((inputString = inputReader.readLine()) != null)
            {
                friendList.add(inputString);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        // random who from friendList
        try
        {
            rand = new Random();
            who = friendList.get(rand.nextInt(friendList.size())).toString();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


        final ImageButton img_btn = (ImageButton) findViewById(R.id.imageButton);

        // show situation depend on categorise
        if(getIntent().getStringExtra("situation").equals("OnTheWay"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta1_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta1_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta1_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta1_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta1_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta1_6);
                textView.append(who);
            }
            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","OnTheWay");
                    startActivity(intent);
                }
            });
        }

        else if(getIntent().getStringExtra("situation").equals("GasStation"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta2_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta2_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta2_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta2_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta2_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta2_6);
            }

            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","GasStation");
                    startActivity(intent);

                }
            });
        }
        else if(getIntent().getStringExtra("situation").equals("EatFood"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta3_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta3_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta3_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta3_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta3_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta3_6);
            }

            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","EatFood");
                    startActivity(intent);
                }
            });
        }
        else if(getIntent().getStringExtra("situation").equals("Place"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta4_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta4_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta4_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta4_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta4_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta4_6);
            }

            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","Place");
                    startActivity(intent);
                }
            });
        }
        else if(getIntent().getStringExtra("situation").equals("OnCar"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta5_1);
                textView.append(who);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta5_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta5_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta5_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta5_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta5_6);
            }
            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","OnCar");
                    startActivity(intent);
                }
            });
        }
        else if(getIntent().getStringExtra("situation").equals("ArriveHome"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta6_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta6_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta6_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta6_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta6_5);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta6_6);
            }

            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","ArriveHome");
                    startActivity(intent);
                }
            });
        }
        else if(getIntent().getStringExtra("situation").equals("Stay"))
        {
            rand = new Random();
            int num = rand.nextInt(5);
            TextView textView = (TextView) findViewById(R.id.textView2);
            if(num==0)
            {
                textView.setText(R.string.sta7_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.sta7_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.sta7_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.sta7_4);
                textView.append(who);
            }
            else if(num==4)
            {
                textView.setText(R.string.sta7_5);
                textView.append(who);
            }
            else if(num==5)
            {
                textView.setText(R.string.sta7_6);
            }

            img_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Situation.this,Inflict.class);
                    intent.putExtra("situation","Stay");
                    startActivity(intent);
                }
            });
        }
    }

    /// go to back ManageMember you want
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(Situation.this, ManageMember.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        startActivity(myIntent);
        finish();
        return;
    }
}
