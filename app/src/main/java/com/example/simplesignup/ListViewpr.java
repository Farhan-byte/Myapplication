package com.example.simplesignup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewpr extends AppCompatActivity {
    private TextView tv;
    private ListView lv;
    private ArrayList listt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewpr);

        listt=new ArrayList<String>();
        listt.add("Android");
        listt.add("ios");
        listt.add("Android");
        listt.add("ios");
        listt.add("Android");
        listt.add("ios");
        listt.add("Android");
        listt.add("ios");
        listt.add("Android");
        listt.add("ios");
        listt.add("Android");
        listt.add("ios");
        lv=findViewById(R.id.lv1);
        tv=findViewById(R.id.tv1);
        ArrayAdapter arrayAdapter=new ArrayAdapter(ListViewpr.this, R.layout.list_item,R.id.tv1, listt);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,final int position, long id) {
                AlertDialog.Builder builder=new AlertDialog.Builder(ListViewpr.this);
                builder.setTitle("Delete")
                        .setMessage("SURE WANNA DELETE")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                listt.remove(position);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ListViewpr.this, "User Not deleted",Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog=builder.create();
                alertDialog.show();
                return false;
            }
        });

        }
    }
