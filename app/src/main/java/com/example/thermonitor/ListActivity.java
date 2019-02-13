package com.example.thermonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
            int[] IMAGES= {R.drawable.sql,R.drawable.java,R.drawable.javascript,R.drawable.c,R.drawable.python,R.drawable.cc,R.drawable.php};
            String [] NAMES={"SQL","JAVA","JAVA SCRIPT","C#","PYTHON","C++","PHP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView listView=(ListView) findViewById(R.id.listView);
        //ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,IMAGES);
        //listView.setAdapter(adapter);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i= new Intent(ListActivity.this,DeviceDetailedActivity.class);
                startActivity(i);
            }
        });



    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
            TextView textView_name=(TextView)convertView.findViewById(R.id.textView_name);

            imageView.setImageResource(IMAGES[position]);
            textView_name.setText(NAMES[position]);
            return convertView;
        }
    }
}
