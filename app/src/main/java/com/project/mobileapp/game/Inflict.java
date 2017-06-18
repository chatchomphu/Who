package com.project.mobileapp.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Inflict extends AppCompatActivity {
    private ArrayList<String> friendList;
    private Random rand;
    private String who;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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
        catch (Exception e)
        {
            e.printStackTrace();
        }

        // show inflict depend on categorise
        if(getIntent().getStringExtra("situation").equals("OnTheWay"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict1_1);
                textView.append(" "+who+ " 10 บาท");
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict1_2);
                textView.append(who);
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict1_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict1_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict1_5);
            }
        }
        else if(getIntent().getStringExtra("situation").equals("GasStation"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict1_1);
                textView.append(" "+who+ " 10 บาท");
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict1_2);
                textView.append(who);
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict2_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict2_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict2_5);
            }
        }
        else if(getIntent().getStringExtra("situation").equals("EatFood"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict3_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict3_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict3_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict3_4);
                textView.append(who);

            }
            else if(num==4)
            {
                textView.setText(R.string.inflict3_5);
                textView.append(who);

            }
        }
        else if(getIntent().getStringExtra("situation").equals("Place"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict4_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict4_2);

            }
            else if(num==2)
            {
                textView.setText(R.string.inflict4_3);
                textView.append(who);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict4_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict4_5);
                textView.append(who+"ทำอะไรก็ได้");
            }
        }
        else if(getIntent().getStringExtra("situation").equals("OnCar"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict5_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict5_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict5_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict5_4);
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict5_5);
            }
        }
        else if(getIntent().getStringExtra("situation").equals("ArriveHome"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict6_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict6_2);
                textView.append(who+"ขาแด๊นซ์");
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict6_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict6_4);
                textView.append("ซิส"+who);
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict6_5);
                textView.append(who+"ขำ");
            }
        }
        else if(getIntent().getStringExtra("situation").equals("Stay"))
        {
            TextView textView = (TextView) findViewById(R.id.textView_inflict);
            rand = new Random();
            int num = rand.nextInt(4);
            if(num==0)
            {
                textView.setText(R.string.inflict7_1);
            }
            else if(num==1)
            {
                textView.setText(R.string.inflict7_2);
            }
            else if(num==2)
            {
                textView.setText(R.string.inflict7_3);
            }
            else if(num==3)
            {
                textView.setText(R.string.inflict7_4);
                textView.append(who+"เพื่อนรัก");
            }
            else if(num==4)
            {
                textView.setText(R.string.inflict7_5);
                textView.append(who+"เพื่อนรัก");
            }
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
        Intent myIntent = new Intent(Inflict.this, Categorise.class);
        myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);// clear back stack
        startActivity(myIntent);
        finish();
        return;
    }
}
