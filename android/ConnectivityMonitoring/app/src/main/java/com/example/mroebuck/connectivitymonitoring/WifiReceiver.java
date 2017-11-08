package com.example.mroebuck.connectivitymonitoring;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import java.util.Locale;

import static android.net.wifi.WifiManager.WIFI_STATE_DISABLED;
import static android.net.wifi.WifiManager.WIFI_STATE_DISABLING;
import static android.net.wifi.WifiManager.WIFI_STATE_ENABLED;
import static android.net.wifi.WifiManager.WIFI_STATE_ENABLING;
import static android.net.wifi.WifiManager.WIFI_STATE_UNKNOWN;

/**
 * Created by mroebuck on 11/8/17.
 */

public class WifiReceiver extends BroadcastReceiver {
  private static final String WIFI_TEXT_DISABLED = "Disabled";
  private static final String WIFI_TEXT_DISABLING = "Disabling";
  private static final String WIFI_TEXT_ENABLED = "Enabled";
  private static final String WIFI_TEXT_ENABLING = "Enabling";
  private static final String WIFI_TEXT_UNKNOWN = "Unknown";
  private String statusText = WIFI_TEXT_UNKNOWN;
  private int wifiState = WIFI_STATE_UNKNOWN;
  private boolean isWifiEnabled = false;
  private IWifiReceiverCallback callback;

  public void bind(final IWifiReceiverCallback callback) {
    this.callback = callback;
  }

  public void unbind() {
    this.callback = null;
  }

  public String getStatusText() {
    return statusText;
  }

  public int getWifiState() {
    return wifiState;
  }

  public boolean isWifiEnabled() {
    return isWifiEnabled;
  }

  @Override public void onReceive(Context context, Intent intent) {

    isWifiEnabled = false;
    wifiState = WIFI_STATE_UNKNOWN;
    statusText = WIFI_TEXT_UNKNOWN;

    NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
    if(info != null && info.isConnected()) {
      WifiManager wifiManager = (WifiManager)context
          .getApplicationContext().getSystemService(Context.WIFI_SERVICE);
      if(wifiManager != null) {
        isWifiEnabled = wifiManager.isWifiEnabled();
        wifiState = wifiManager.getWifiState();

        switch (wifiState) {
          case WIFI_STATE_DISABLED:
            statusText = WIFI_TEXT_DISABLED;
            break;
          case WIFI_STATE_DISABLING:
            statusText = WIFI_TEXT_DISABLING;
            break;
          case WIFI_STATE_ENABLED:
            statusText = WIFI_TEXT_ENABLED;
            break;
          case WIFI_STATE_ENABLING:
            statusText = WIFI_TEXT_ENABLING;
            break;
          case WIFI_STATE_UNKNOWN:
            statusText = WIFI_TEXT_UNKNOWN;
            break;
        }
        //WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        //String ssid = wifiInfo.getSSID();

        Log.i(this.getClass().getCanonicalName(),
            String.format(Locale.getDefault(),
                "enabled=[%b] status=[%s]", isWifiEnabled, statusText));
      }
    }

    if(callback != null) {
      callback.onWifiStatusChanged(isWifiEnabled, wifiState, statusText);
    }
  }

  public interface IWifiReceiverCallback {
    void onWifiStatusChanged(final boolean isWifiEnabled,
        final int wifiState,
        final String statusText);
  }
}
