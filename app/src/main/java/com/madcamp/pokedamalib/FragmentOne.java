package com.madcamp.pokedamalib;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Junhong //
 // Source code recreated from a .class file by IntelliJ IDEA
 // (powered by Fernflower decompiler)
 //

 package com.google.android.gms.maps;

 import android.app.Activity;
 import android.app.Fragment;
 import android.os.Bundle;
 import android.os.RemoteException;
 import android.util.AttributeSet;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
 import com.google.android.gms.dynamic.LifecycleDelegate;
 import com.google.android.gms.internal.ap;
 import com.google.android.gms.internal.aw;
 import com.google.android.gms.internal.cj;
 import com.google.android.gms.internal.e;
 import com.google.android.gms.internal.f;
 import com.google.android.gms.internal.g;
 import com.google.android.gms.internal.o;
 import com.google.android.gms.maps.GoogleMap;
 import com.google.android.gms.maps.GoogleMapOptions;
 import com.google.android.gms.maps.MapsInitializer;
 import com.google.android.gms.maps.internal.IGoogleMapDelegate;
 import com.google.android.gms.maps.internal.IMapFragmentDelegate;
 import com.google.android.gms.maps.model.RuntimeRemoteException;

 public class MapFragment extends Fragment {
 private final MapFragment.a ga = new MapFragment.a(this);
 private GoogleMap bw;

 public static MapFragment newInstance() {
 return new MapFragment();
 }

 public static MapFragment newInstance(GoogleMapOptions var0) {
 MapFragment var1 = new MapFragment();
 Bundle var2 = new Bundle();
 var2.putParcelable("MapOptions", var0);
 var1.setArguments(var2);
 return var1;
 }

 public MapFragment() {
 }

 protected IMapFragmentDelegate m() {
 this.ga.a();
 return this.ga.bp() == null?null:((MapFragment.b)this.ga.bp()).m();
 }

 public final GoogleMap getMap() {
 IMapFragmentDelegate var1 = this.m();
 if(var1 == null) {
 return null;
 } else {
 IGoogleMapDelegate var2;
 try {
 var2 = var1.getMap();
 } catch (RemoteException var4) {
 throw new RuntimeRemoteException(var4);
 }

 if(var2 == null) {
 return null;
 } else {
 if(this.bw == null || this.bw.bB().asBinder() != var2.asBinder()) {
 this.bw = new GoogleMap(var2);
 }

 return this.bw;
 }
 }
 }

 public void onAttach(Activity var1) {
 super.onAttach(var1);
 this.ga.setActivity(var1);
 }

 public void onInflate(Activity var1, AttributeSet var2, Bundle var3) {
 super.onInflate(var1, var2, var3);
 this.ga.setActivity(var1);
 GoogleMapOptions var4 = GoogleMapOptions.createFromAttributes(var1, var2);
 Bundle var5 = new Bundle();
 var5.putParcelable("MapOptions", var4);
 this.ga.onInflate(var1, var5, var3);
 }

 public void onCreate(Bundle var1) {
 super.onCreate(var1);
 this.ga.onCreate(var1);
 }

 public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
 return this.ga.onCreateView(var1, var2, var3);
 }

 public void onResume() {
 super.onResume();
 this.ga.onResume();
 }

 public void onPause() {
 this.ga.onPause();
 super.onPause();
 }

 public void onDestroyView() {
 this.ga.onDestroyView();
 super.onDestroyView();
 }

 public void onDestroy() {
 this.ga.onDestroy();
 super.onDestroy();
 }

 public void onLowMemory() {
 this.ga.onLowMemory();
 super.onLowMemory();
 }

 public void onSaveInstanceState(Bundle var1) {
 this.ga.onSaveInstanceState(var1);
 super.onSaveInstanceState(var1);
 }

 public void setArguments(Bundle var1) {
 super.setArguments(var1);
 }

 static class a extends e<MapFragment.b> {
 private final Fragment f;
 protected aw<MapFragment.b> g;
 private Activity h;

 a(Fragment var1) {
 this.f = var1;
 }

 protected void a(aw<MapFragment.b> var1) {
 this.g = var1;
 this.a();
 }

 public void a() {
 if(this.h != null && this.g != null && this.bp() == null) {
 try {
 MapsInitializer.initialize(this.h);
 IMapFragmentDelegate var1 = o.a(this.h).d(ap.d(this.h));
 this.g.b(new MapFragment.b(this.f, var1));
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 } catch (GooglePlayServicesNotAvailableException var3) {
 ;
 }
 }

 }

 private void setActivity(Activity var1) {
 this.h = var1;
 this.a();
 }
 }

 static class b implements LifecycleDelegate {
 private final Fragment f;
 private final IMapFragmentDelegate aD;

 public b(Fragment var1, IMapFragmentDelegate var2) {
 this.aD = (IMapFragmentDelegate)cj.e(var2);
 this.f = (Fragment)cj.e(var1);
 }

 public void onInflate(Activity var1, Bundle var2, Bundle var3) {
 GoogleMapOptions var4 = (GoogleMapOptions)var2.getParcelable("MapOptions");

 try {
 this.aD.onInflate(ap.d(var1), var4, var3);
 } catch (RemoteException var6) {
 throw new RuntimeRemoteException(var6);
 }
 }

 public void onCreate(Bundle var1) {
 try {
 if(var1 == null) {
 var1 = new Bundle();
 }

 Bundle var2 = this.f.getArguments();
 if(var2 != null && var2.containsKey("MapOptions")) {
 g.a(var1, "MapOptions", var2.getParcelable("MapOptions"));
 }

 this.aD.onCreate(var1);
 } catch (RemoteException var3) {
 throw new RuntimeRemoteException(var3);
 }
 }

 public View onCreateView(LayoutInflater var1, ViewGroup var2, Bundle var3) {
 f var4;
 try {
 var4 = this.aD.onCreateView(ap.d(var1), ap.d(var2), var3);
 } catch (RemoteException var6) {
 throw new RuntimeRemoteException(var6);
 }

 return (View)ap.b(var4);
 }

 public void onResume() {
 try {
 this.aD.onResume();
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 }
 }

 public void onPause() {
 try {
 this.aD.onPause();
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 }
 }

 public void onDestroyView() {
 try {
 this.aD.onDestroyView();
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 }
 }

 public void onDestroy() {
 try {
 this.aD.onDestroy();
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 }
 }

 public void onLowMemory() {
 try {
 this.aD.onLowMemory();
 } catch (RemoteException var2) {
 throw new RuntimeRemoteException(var2);
 }
 }

 public void onSaveInstanceState(Bundle var1) {
 try {
 this.aD.onSaveInstanceState(var1);
 } catch (RemoteException var3) {
 throw new RuntimeRemoteException(var3);
 }
 }

 public IMapFragmentDelegate m() {
 return this.aD;
 }
 }
 }
 on 2016-01-11.
 */
public class FragmentOne extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        return inflater.inflate(R.layout.fragment, container, false);
    }
}
