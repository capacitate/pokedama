package com.madcamp.pokedamalib;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import com.unity3d.player.UnityPlayer;
import com.unity3d.player.UnityPlayerActivity;

import java.util.logging.LogRecord;


public class BridgeActivity extends UnityPlayerActivity {

    private static String TAG = "Unity";
    private Handler mHandler;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "BridgeActivity onCreate");
        setContentView(R.layout.activity_bridge);

        Intent mapIntent = new Intent(this, MapActivity.class);
        startActivityForResult(mapIntent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bridge, menu);
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


    public static void makeLog(String str, Context ctx){
        if(null == Looper.myLooper()){
            Looper.prepare();
        }
        if(null == ctx){
            Log.i(TAG, "Unity ctx is not null");
        }

        Log.i(TAG, "Unity BridgeActivity makeLog");
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);

        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, str);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, str);

        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(sharingIntent);
        Log.i(TAG, "Unity BridgeActivity makeLog 뭐야?");
    }

    public static void shareText(String subject, String body, Context ctx) {
        Log.i(TAG, "BridgeActivity shareText begin");
        if(null == Looper.myLooper()){
            Looper.prepare();
        }
        if(null == ctx){
            Log.i(TAG, "Unity ctx is not null");
        }

        Intent helloIntent = new Intent(ctx.getApplicationContext(), HelloActivity.class);
        helloIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        ctx.startActivity(helloIntent);
        Log.i(TAG, "BridgeActivity shareText after");
    }

    public void makeHandler(){
        if(null == Looper.myLooper()){
            Looper.prepare();
        }
        Log.i(TAG, "Unity makeHandler");
        mHandler = new SendMessageHandler();
        mHandler.sendEmptyMessage(2);
    }

    class SendMessageHandler extends Handler {
        public void handleMessage(Message msg){
            super.handleMessage(msg);

            Log.i(TAG, "Unity SendMessageHandler");
            switch(msg.what){
                case 2:
                    Log.i(TAG, "Unity Handler got " + 2);
            }
        }
    }

    public static void callMap(Context ctx, String uuid){
        Log.i(TAG, "BridgeActivity callMap begin");
        if(null == Looper.myLooper()){
            Looper.prepare();
        }
        if(null == ctx){
            Log.i(TAG, "Unity ctx is not null");
        }

        Intent mapIntent = new Intent("com.madcamp.myapplication.MapsActivity");
        mapIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mapIntent.putExtra("UUID", uuid);
        ctx.startActivity(mapIntent);
//        ctx.startActivityForResult(mapIntent, 0);
        UnityPlayer.UnitySendMessage("MapLogic", "called", "yes");
        Log.i(TAG, "BridgeActivity callMap after");
    }
}
