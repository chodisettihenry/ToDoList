package com.example.todolist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText text;
    Button button;
    ListView listView;
    ArrayList<String> itemlist =new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        listView=findViewById(R.id.ListView);
        itemlist=FileHelper.readData(this);

        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1,itemlist);

        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result= text.getText().toString();
                itemlist.add(result);
                text.setText("");
                FileHelper.writeData(itemlist,getApplicationContext());
                adapter.notifyDataSetChanged();
            }
        });

    }
}