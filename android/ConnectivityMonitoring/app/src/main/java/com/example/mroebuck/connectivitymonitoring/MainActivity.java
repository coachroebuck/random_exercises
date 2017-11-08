package com.example.mroebuck.connectivitymonitoring;

import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements WifiReceiver.IWifiReceiverCallback {

  private WifiReceiver wifiReceiver;
  private TextView textView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = findViewById(R.id.textView);
    wifiReceiver = new WifiReceiver();
    wifiReceiver.bind(this);
  }

  @Override public void onStart() {
    super.onStart();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
    registerReceiver(wifiReceiver, intentFilter);
  }

  @Override public void onStop() {
    super.onStop();
    unregisterReceiver(wifiReceiver);
    wifiReceiver.unbind();
  }

  @Override
  public void onWifiStatusChanged(boolean isWifiEnabled, int wifiState, String statusText) {
    textView.setText(String.format(Locale.getDefault(),
        "enabled=[%b] status=[%s]", isWifiEnabled, statusText));
  }
}
