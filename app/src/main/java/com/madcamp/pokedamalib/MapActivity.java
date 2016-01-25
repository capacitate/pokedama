    package com.madcamp.pokedamalib;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Junhong on 2016-01-11.
 */
public class MapActivity extends Activity {
    static final LatLng SEOUL = new LatLng(37.56, 126.97);
    private GoogleMap map;

    private MapFragment mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_fragment);

        /*map = ((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        Marker seoul = map.addMarker(new MarkerOptions().position(SEOUL).title("Seoul"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SEOUL, 15));*/

        FragmentManager fm = getFragmentManager();
        mMap = (MapFragment)fm.findFragmentById(R.id.map);
        if(mMap == null){
            mMap = MapFragment.newInstance();
            fm.beginTransaction().replace(R.id.map, mMap).commit();
        }

    }
}
