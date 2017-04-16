package com.example.dexing.electric;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class GetPointActivity extends AppCompatActivity implements AMap.OnMapClickListener {

    private String TAG = GetPointActivity.class.getSimpleName();
    private AMap aMap;
    private MapView mapView;
    private Marker marker;
    private List<LatLng> listLatLng = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_point);

        Button btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ltlgs = "";
                for (int i = 0; i < listLatLng.size(); i++) {
                    LatLng latLng = listLatLng.get(i);
                    ltlgs += latLng.latitude + "," + latLng.longitude + ";";
                }
                listLatLng.clear();
                Log.i(TAG, "line: " + ltlgs);
            }
        });

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        init();
    }

    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        aMap.setOnMapClickListener(this);
        aMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(37.060657,118.450843), 45));

    }

    @Override
    public void onMapClick(LatLng arg0) {
        listLatLng.add(arg0);
//        Toast.makeText(this, arg0.longitude+" "+arg0.latitude, Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onMapClick: " + arg0.longitude + " " + arg0.latitude);
        if (marker != null) {
            marker.remove();
        }
        marker = aMap.addMarker(new MarkerOptions().position(arg0));
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    /**
     * 方法必须重写
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
