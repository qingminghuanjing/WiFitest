package com.example.asus.wifitest;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends MPermissionsActivity {

    Button button;
    WifiManager WM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.bt);
         WM= (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);//朱凤杰：我给此处添加了getApplicationContext().方法否则会报错
      //  requestPermission(new String[]{Manifest.permission.CHANGE_WIFI_STATE}, 0x003);
       // checkPermission(Manifest.permission.CHANGE_WIFI_STATE, 1, 3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 标准流程，连接wapi网络
                try {


                    if (!WM.isWifiEnabled())
                        WM.setWifiEnabled(true);

                    Intent intent = new Intent();
                    intent.setAction("android.net.wifi.PICK_WIFI_NETWORK");

                    startActivity(intent);
                } catch (Exception e) {
                   // onInstallDialog("请检查WIFI是否打开？");
                    e.printStackTrace();
                    Log.e("朱凤杰：","有没有问题啊？");

                }
            }
        });
    }



}
