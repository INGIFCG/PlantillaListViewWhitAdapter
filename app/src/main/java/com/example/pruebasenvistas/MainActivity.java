package com.example.pruebasenvistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pruebasenvistas.adapter.CustomAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Model> modelArrayList;
    private static CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listview);

        modelArrayList = new ArrayList<>();

        Model model1 = new Model("Carlos","Ingeniero en informatica",R.drawable.ic_launcher_background);
        Model model2 = new Model("Juan","Ingeniero en Sistema",R.drawable.ic_launcher_background);
        Model model3 = new Model("Pedro","Ingeniero en Mantenimiento de obras",R.drawable.ic_launcher_background);
        Model model4 = new Model("Jose","Ingeniero en Desarrollo de software",R.drawable.ic_launcher_background);
        Model model5 = new Model("Luis","Ingeniero en Sistemas",R.drawable.ic_launcher_background);

        modelArrayList.add(model1);
        modelArrayList.add(model2);
        modelArrayList.add(model3);
        modelArrayList.add(model4);
        modelArrayList.add(model5);

        customAdapter = new CustomAdapter(modelArrayList,getApplicationContext());

        listView.setAdapter(customAdapter);

        //busqueda del id al tocar el elemnto en pantalla
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "name:"+customAdapter.getItem(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}