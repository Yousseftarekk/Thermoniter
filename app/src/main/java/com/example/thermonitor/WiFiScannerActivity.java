package com.example.thermonitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WiFiScannerActivity extends AppCompatActivity {
    private WifiManager wifiManager;
    private ListView listVieww;
    private Button buttonScan;
    private List<ScanResult> results;
    private ArrayList<String> arrayList=new ArrayList<>();
   // private ArrayAdapter adapter;
    private ArrayList<Integer> images=new ArrayList<>();
    private ArrayList<String> mac=new ArrayList<>();
    private ArrayList<String> SSID=new ArrayList<>();
    private CustomAdapter customAdapterr;
   // private ArrayList<String> bye=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wi_fi_scanner);
        buttonScan = findViewById(R.id.button2);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.click);

        buttonScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanWifi();
                mp.start();


            }

        });




        /*if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {

            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    LocationService.MY_PERMISSION_ACCESS_COURSE_LOCATION );
        }*/
        listVieww=findViewById(R.id.listView20);
         customAdapterr=new CustomAdapter();
        listVieww.setAdapter(customAdapterr);
        listVieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent x=new Intent(WiFiScannerActivity.this,DeviceDetailedActivity.class);
                startActivity(x);
            }
        });


        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        if(!wifiManager.isWifiEnabled()){
            Toast.makeText(this, "WiFi is Disabled.. We'll take care of this :) ",Toast.LENGTH_SHORT).show();
            wifiManager.setWifiEnabled(true);

        }
        //adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrayList);
        //listVieww.setAdapter(adapter);
        scanWifi();



    }

    private void scanWifi(){
        arrayList.clear();
        registerReceiver(wifiReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        wifiManager.startScan();
        Toast.makeText(this,"Scanning WiFi, Please Wait!",Toast.LENGTH_SHORT).show();

        }
            BroadcastReceiver wifiReceiver= new BroadcastReceiver() {
                @Override
                public void onReceive(Context context, Intent intent) {
                    results= wifiManager.getScanResults();

                    unregisterReceiver(this);


                    for(ScanResult scanResult:results){
                       // arrayList.add(scanResult.SSID);
                       // adapter.notifyDataSetChanged();
                      //  Log.d("joe","size of wifi "+results);
                        if(scanResult.SSID.equals("ESP1")||scanResult.SSID.equals("ESP2")){
                            SSID.add(scanResult.SSID);
                            images.add(R.drawable.esp);
                            mac.add(scanResult.BSSID);
                            customAdapterr.notifyDataSetChanged();

                        }
                        if(scanResult.SSID.equals("NETGEAR20")){
                            SSID.add(scanResult.SSID);
                            images.add(R.drawable.unnamed);
                            mac.add(scanResult.BSSID);
                            customAdapterr.notifyDataSetChanged();
                        }
                        
                    }
                }
            };
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.size();
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
            if(SSID!=null&&SSID.size()!=0&&position<SSID.size()) {
                View view=getLayoutInflater().inflate(R.layout.row,null);
                //convertView = getLayoutInflater().inflate(R.layout.row, null);
                ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
                TextView textView4 = (TextView) view.findViewById(R.id.textView10);
                TextView textView5 = (TextView) view.findViewById(R.id.textView20);
                imageView.setImageResource(images.get(position));
                textView4.setText(mac.get(position));
                textView5.setText(SSID.get(position));
                return view;
            }
            else{
                return null;}
        }
    }
}
