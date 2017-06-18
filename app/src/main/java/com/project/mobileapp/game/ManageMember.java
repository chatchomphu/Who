package com.project.mobileapp.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ManageMember extends AppCompatActivity  {

    private  ArrayList<String> friendList;
    private static final String PREFS_NAME = "MyPrefsFile";
    private ListView listView;
    private SimpleAdapter sAdap;
    private String toasts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        // get friendlist fromfile
        SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String status = sharedPreferences.getString("status","first");


        if(status.equals("first")) // first time in app
        {
            friendList = new ArrayList<String>();
        }
        else if(status.equals("from2")) // from page 2
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("status","unfrom2");
            editor.commit();
            readFile();
        }
        else if(status.equals("unfrom2")) // file have member
        {
            readFile();
            if(friendList.size()!=0)
            {
                Intent intent = new Intent(ManageMember.this,Categorise.class);
                startActivity(intent);
            }
        }



        final EditText editText = (EditText) findViewById(R.id.editText);

        // show list friend
        ImageButton bnt_add = (ImageButton) findViewById(R.id.imageButton_add);
        bnt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editText.getText().toString().equals("")&& !editText.getText().toString().equals(null)) // Can not add blank to friendlist
                {

                    friendList.add(editText.getText().toString());
                    editText.setText("");

                    listView = (ListView)findViewById(R.id.listView);
                    final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                    HashMap<String, String> map;

                    try
                    {
                        for(int i=0;i<friendList.size();i++)
                        {
                            map = new HashMap<String, String>();
                            map.put("name" ,friendList.get(i));

                            MyArrList.add(map);
                        }

                        sAdap = new SimpleAdapter(ManageMember.this, MyArrList, R.layout.activity_column,
                                new String[] {"name"}, new int[] {R.id.col_trans_id});

                        listView.setAdapter(sAdap);


                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
        listView = (ListView)findViewById(R.id.listView);
        final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;



        try
        {
            for(int i=0;i<friendList.size();i++)
            {
                map = new HashMap<String, String>();
                map.put("name" ,friendList.get(i));

                MyArrList.add(map);
            }

            sAdap = new SimpleAdapter(ManageMember.this, MyArrList, R.layout.activity_column,
                    new String[] {"name"}, new int[] {R.id.col_trans_id});

            listView.setAdapter(sAdap);

            // delete listview
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    AlertDialog.Builder adb = new AlertDialog.Builder(ManageMember.this);
                    adb.setTitle("ลบสมาชิก");
                    adb.setMessage("คุณต้องการที่จะลบ "+friendList.get(i).toString()+" ออกใช่มั้ย");
                    final int positionToRemove = i;
                    adb.setNegativeButton("ยกเลิก",null);
                    adb.setPositiveButton("ตกลง",new AlertDialog.OnClickListener(){
                        public void onClick(DialogInterface dialog, int which) {
                            friendList.remove(positionToRemove);

                            listView = (ListView)findViewById(R.id.listView);
                            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
                            HashMap<String, String> map;
                            for(int i=0;i<friendList.size();i++)
                            {
                                map = new HashMap<String, String>();
                                map.put("name" ,friendList.get(i));

                                MyArrList.add(map);
                            }


                            sAdap = new SimpleAdapter(ManageMember.this, MyArrList, R.layout.activity_column,
                                    new String[] {"name"}, new int[] {R.id.col_trans_id});

                            listView.setAdapter(sAdap);
                            sAdap.notifyDataSetChanged();
                            writeFile("ลบสมาชิก");

                        }});
                    adb.show();
            }
        });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



        ImageButton bnt_suc = (ImageButton) findViewById(R.id.imageButton_success);
        bnt_suc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeFile("บันทึกสำเร็จ");
                Intent intent = new Intent(ManageMember.this,Categorise.class);
                startActivity(intent);
            }
        });
}

    /// close app
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
           onBackPressed();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if(friendList.size()==0)
        {
            // define file null
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("status","first");
            editor.commit();
        }
        else
        {
            // define file had saved
            SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("status","unfrom2");
            editor.commit();
            writeFile("บันทึกสำเร็จ");
        }
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
        finish();
        System.exit(0);
    }

    public void readFile()
    {
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

    }

    public void writeFile(String t)
    {
        toasts = t;
        String filename = "info.txt";
        FileOutputStream outputStream;
        String write="";
        for(int i=0;i<friendList.size();i++)
        {
            write = write + friendList.get(i).toString()+"\n";
        }
        try
        {
            outputStream = openFileOutput(filename,MODE_PRIVATE);
            outputStream.write(write.getBytes());
            outputStream.close();
            Toast toast = Toast.makeText(getApplicationContext(),toasts,Toast.LENGTH_LONG);
            toast.show();
        }
        catch (Exception ex)
        {
            Toast toast = Toast.makeText(getApplicationContext(),R.string.save_failed,Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
