package com.msrit.icucs.msrit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] mListArray={
                "MSRIT",
                "Magazine",
                "Club",
                "Gallery",
                "SIS",
                "Notice Board",
                "Location"
        };
        final ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_layout,
                mListArray);
        ListView theListView = (ListView) findViewById(R.id.list);

        theListView.setAdapter(adapter);

        theListView.setOnItemClickListener(new
                 AdapterView.OnItemClickListener() {
                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                      String select = "U selected " +
                              String.valueOf(parent.getItemAtPosition(position));

                    String pos1 =String.valueOf(parent.getItemAtPosition(position));

                     //Toast.makeText(MainActivity.this,pos1,Toast.LENGTH_SHORT).show();
                     if(pos1.equals("MSRIT")){
                         Toast.makeText(MainActivity.this, select, Toast.LENGTH_SHORT).show();
                         String url = "http://www.msrit.edu";
                         Intent intent = new Intent(view.getContext(), WebViewActivity.class);
                         intent.putExtra("name",url);
                         startActivity(intent);


                     }
                 }
             }

        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
