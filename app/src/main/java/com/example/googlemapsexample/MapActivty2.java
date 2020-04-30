//package com.example.googlemapsexample;
//
//import android.Manifest;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.content.pm.PackageManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.content.ContextCompat;
//
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.GoogleApiAvailability;
//import com.google.android.gms.maps.CameraUpdate;
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.SupportMapFragment;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//public class MapActivty2 extends AppCompatActivity implements OnMapReadyCallback {
//
//    //+- button
//    // label
//    //map highlight when click on marker
//
//
//    public static final int PERMISSION_REQUEST_CODE = 9001;
//    private boolean mLocationPermissionGranted;
//    private int PLAY_SERVICE_ERROR_CODE = 9002;
//
//    private GoogleMap googleMap;
//    private MapView mapView;
//
//    double lat = 28.527582;
//    double lng = 77.0688961;
//    int ZOOM_LEVEL = 8;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map2);
//
//        initGoogleMap();
//
///*
//        SupportMapFragment supportMapFragment=(SupportMapFragment)getSupportFragmentManager()
//                .findFragmentById(R.id.map_fragment);
//
//*/
//        SupportMapFragment supportMapFragment = SupportMapFragment.newInstance();
//        getSupportFragmentManager().beginTransaction().add(R.id.map_fragment_container, supportMapFragment)
//                .commit();
//
//        supportMapFragment.getMapAsync(this);
//
//
//        isServiceOk();
//
//
//        if (mLocationPermissionGranted) {
//            Toast.makeText(this, "Ready to Map!", Toast.LENGTH_SHORT).show();
//        } else {
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
//                }
//            }
//        }
//
//    }
//
//    private void initGoogleMap() {
//        if (isServiceOk()) {
//            if (mLocationPermissionGranted) {
//                Toast.makeText(this, "Ready to map", Toast.LENGTH_SHORT).show();
//            } else {
//                requestLocationPermission();
//            }
//        }
//    }
//
//    private void requestLocationPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_CODE);
//            }
//        }
//    }
//
//    private boolean isServiceOk() {
//        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
//        int result = googleApiAvailability.isGooglePlayServicesAvailable(this);
//        if (result == ConnectionResult.SUCCESS) {
//            return true;
//        } else if (googleApiAvailability.isUserResolvableError(result)) {
//            Dialog dialog = googleApiAvailability.getErrorDialog(this,
//                    result, PLAY_SERVICE_ERROR_CODE,
//                    new DialogInterface.OnCancelListener() {
//                        @Override
//                        public void onCancel(DialogInterface task) {
//                            Toast.makeText(MapActivty2.this, "Dialog is cancelled by user", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//        } else {
//            Toast.makeText(this, "Play service are required by the application", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }
//
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == PERMISSION_REQUEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            mLocationPermissionGranted = true;
//            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    @Override
//    public void onMapReady(final GoogleMap googleMap) {
//        this.googleMap = googleMap;
//        gotoLocation(lat, lng);
//        googleMap.getUiSettings().setZoomControlsEnabled(true);
//        googleMap.getUiSettings().setMapToolbarEnabled(true);
//        googleMap.setBuildingsEnabled(true);
//
//
//
//
//        MarkerOptions markerOptions = new MarkerOptions()
//                .title("new title").position(new LatLng(lat, lng));
//        googleMap.addMarker(markerOptions);
//
//
//
//
//    }
//
//    private void gotoLocation(double lat, double lng) {
//        LatLng latLng = new LatLng(lat, lng);
//        CameraUpdate cameraUpdate= CameraUpdateFactory.newLatLng(latLng);
////        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, ZOOM_LEVEL);
//        googleMap.moveCamera(cameraUpdate);
//        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//
//
////        googleMap.getUiSettings().setZoomGesturesEnabled(true);
////        googleMap.getUiSettings().setScrollGesturesEnabled(true);
////        googleMap.getUiSettings().setTiltGesturesEnabled(true);
////        googleMap.getUiSettings().setRotateGesturesEnabled(true);
////        googleMap.getUiSettings().setAllGesturesEnabled(true);
////        googleMap.getUiSettings().setCompassEnabled(true);
////        googleMap.getUiSettings().setMapToolbarEnabled(true);
//
//
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.map_type_none:
//                googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
//                break;
//            case R.id.map_type_normal:
//                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//                break;
//            case R.id.map_type_satellite:
//                googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//                break;
//            case R.id.map_type_terrain:
//                googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//                break;
//            case R.id.map_type_hybrid:
//                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
//                break;
//        }
//
//        return true;
//    }
//}
//
