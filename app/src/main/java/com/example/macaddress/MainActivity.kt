package com.example.macaddress

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Formatter
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val wInfo = wifiManager.connectionInfo


        val ipAddress = Formatter.formatIpAddress(wInfo.ipAddress)
        val linkSpeed = wInfo.linkSpeed
        val networkID =wInfo.networkId
        val ssid = wInfo.ssid
        val hssid = wInfo.hiddenSSID
        val bssid = wInfo.bssid

        val wifiInformationTv = findViewById<TextView>(R.id.wifiInfo)
        wifiInformationTv.text =

                "IP Address:\t$ipAddress\n" +
                "Link Speed:\t$linkSpeed\n" +
                "Network ID:\t$networkID\n" +
                "SSID:\t$ssid\n" +
                "Hidden SSID:\t$hssid\n" +
                "BSSID:\t$bssid\n"


    }
}