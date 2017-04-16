package com.example.dexing.electric;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.LatLngBounds;
import com.amap.api.maps2d.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

public class DrawLineActivity extends AppCompatActivity {

    private String line1 = "37.060657,118.450843;37.060531,118.451713;37.060348,118.452384;37.060119,118.453155;37.060016,118.454132;37.05986,118.455314;37.059757,118.456245;37.059688,118.457252;37.059585,118.457824;37.059276,118.459197;";
    private String line2 = "37.061122,118.453742;37.06105,118.454483;37.060977,118.455276;37.060916,118.456192;37.060825,118.456901;37.060783,118.45758;37.06071,118.458251;";
    private String line3 = "37.063777,118.455932;37.063034,118.455856;37.061832,118.455696;37.060997,118.455551;";
    private String line4 = "37.06356,118.45684;37.062919,118.456787;37.062034,118.456657;37.061355,118.456581;37.060894,118.456512;";
    private String line5 = "37.063297,118.45877;37.06274,118.458572;37.062122,118.45832;37.061389,118.458038;37.060813,118.457801;";
    private String line6 = "37.060859,118.456512;37.060321,118.456459;37.05978,118.456382;";
    private String line7 = "37.060733,118.457473;37.060207,118.457412;37.059665,118.457359;";
    private String line8 = "37.060707,118.457939;37.060119,118.457908;37.059635,118.457847;";
    private String line9 = "37.064517,118.453277;37.063644,118.452896;37.062934,118.452651;37.061775,118.452186;37.060516,118.451721;";
    private String line10 = "37.064952,118.451881;37.064575,118.453269;37.064186,118.454551;37.063835,118.455902;37.063594,118.456802;37.06332,118.458702;";
//    private String line11 = "";

    private List<String> allLines = new ArrayList<>();
    private AMap aMap;
    private MapView mapView;
    private int lineWith = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_line);
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        drawLine();
    }

    private void drawLine() {
        if (aMap == null) {
            aMap = mapView.getMap();
        }

        allLines.add(line1);
        allLines.add(line2);
        allLines.add(line3);
        allLines.add(line4);
        allLines.add(line5);
        allLines.add(line6);
        allLines.add(line7);
        allLines.add(line8);
        allLines.add(line9);
        allLines.add(line10);

        LatLngBounds.Builder bounds = LatLngBounds.builder();

        for (int i = 0; i < allLines.size(); i++) {
            String[] lines1 = allLines.get(i).split(";");
            PolylineOptions polyline1 = new PolylineOptions();
            for (int j = 0; j < lines1.length; j++) {
                if (lines1[j].contains(",")) {
                    double lat = Double.parseDouble(lines1[j].split(",")[0]);
                    double lng = Double.parseDouble(lines1[j].split(",")[1]);
                    LatLng latLng = new LatLng(lat, lng);
                    polyline1.add(latLng);
                    bounds.include(latLng);
                }
            }
            aMap.addPolyline(polyline1.color(Color.RED).width(lineWith));
        }

        aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 45));

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
