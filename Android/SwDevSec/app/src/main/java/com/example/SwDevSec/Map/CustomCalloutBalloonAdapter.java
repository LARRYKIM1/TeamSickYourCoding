package com.example.SwDevSec.Map;

import android.view.View;

import net.daum.mf.map.api.CalloutBalloonAdapter;
import net.daum.mf.map.api.MapPOIItem;

public class CustomCalloutBalloonAdapter implements CalloutBalloonAdapter {
    private final View mCalloutBalloon = null;

    public CustomCalloutBalloonAdapter() {
    }

    @Override
    public View getCalloutBalloon(MapPOIItem poiItem) {
        return null;
    }

    @Override
    public View getPressedCalloutBalloon(MapPOIItem poiItem) {
        return null;
    }
}
