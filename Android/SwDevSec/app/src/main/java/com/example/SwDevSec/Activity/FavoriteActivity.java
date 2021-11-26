package com.example.SwDevSec.Activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.SwDevSec.R;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class FavoriteActivity extends MapBaseActivity {
    private String language;
    private String type;
    private String areacode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        mMapView = (MapView) findViewById(R.id.map_view);
        //mMapView.setDaumMapApiKey(MapApiConst.DAUM_MAPS_ANDROID_APP_API_KEY);
        mMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mMapView.setMapRotationAngle(0,true);
        mMapView.setCurrentLocationEventListener(this);

        Intent preintent = getIntent();
        language=preintent.getExtras().getString("language");
        type=preintent.getExtras().getString("type");
        areacode=preintent.getExtras().getString("areacode");
    }
}
