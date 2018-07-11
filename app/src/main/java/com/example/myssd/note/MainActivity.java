package com.example.myssd.note;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;
public class MainActivity extends AppCompatActivity {
    final String[] catNames = new String[] {
            "Рыжик", "Барсик", "Мурзик", "Мурка", "Васька"
    };
    ListView listView;
    Context x = this;

    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, catNames);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(), "Everything is working fine ", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(x, Second.class);
                startActivity(i);
            }
        });
        toolbar = findViewById(R.id.my_toolbar);
       // toolbar.setBackgroundColor(Color.parseColor("#80000000"));
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sort_date:
                Toast.makeText(getApplicationContext(), "Everything is working fine ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sort_alphabetically:
                Toast.makeText(getApplicationContext(), "Everything is working fine ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_add:
                Toast.makeText(getApplicationContext(), "Everything is working fine ", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }


}
