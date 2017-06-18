package com.project.mobileapp.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Categorise extends AppCompatActivity {
    private ArrayList<String> friendList;
    private static final String PREFS_NAME = "MyPrefsFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // back to manage member
        ImageButton edit_btn = (ImageButton) findViewById(R.id.btn_edit_member);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try
                {
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("status","from2");
                    editor.commit();
                    Intent intent = new Intent(Categorise.this,ManageMember.class);
                    startActivity(intent);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

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

        // select categorise
        final ImageButton img_btn1 = (ImageButton) findViewById(R.id.imageButton1);
        img_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn1, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","OnTheWay");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn2 = (ImageButton) findViewById(R.id.imageButton2);
        img_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn2, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","GasStation");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn3 = (ImageButton) findViewById(R.id.imageButton3);
        img_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn3, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","EatFood");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn4 = (ImageButton) findViewById(R.id.imageButton4);
        img_btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn4, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","Place");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn5 = (ImageButton) findViewById(R.id.imageButton5);
        img_btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn5, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","OnCar");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn6 = (ImageButton) findViewById(R.id.imageButton6);
        img_btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn6, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","ArriveHome");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn7 = (ImageButton) findViewById(R.id.imageButton7);
        img_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(friendList.size()==0) // No member can not play
                {
                    Snackbar.make(img_btn7, R.string.edit_member, Snackbar.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Categorise.this,Countdown.class);
                    intent.putExtra("situation","Stay");
                    startActivity(intent);
                }
            }
        });
        final ImageButton img_btn8 = (ImageButton) findViewById(R.id.imageButton8);
        img_btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

    }

    /// close app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("status","unfrom2");
            editor.commit();
            onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//***Change Here***
        startActivity(intent);
        finish();
        System.exit(0);
    }

}
