package com.example.SwDevSec.Map;

import com.example.SwDevSec.ServerRest.ContentList;
import com.example.SwDevSec.kakaoRest.RestaurantList;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.Locale;

public class DrawMarker {
    private MapPOIItem mDefaultMarker;
    private String langs = "en";


    public DrawMarker() {
    }

    public void makeMarker(ContentList contentList, MapView mapView){
        MapPoint DEFAULT_MARKER_POINT;
        int i = 0;

        String name = "Default";

        langs = Locale.getDefault().getLanguage(); //기기 언어 가져오기
        while (i < contentList.getResponse().getBody().getItems().getList().size()) {
            mDefaultMarker = new MapPOIItem();
            name = contentList.getResponse().getBody().getItems().getList().get(i).getTitle();
            DEFAULT_MARKER_POINT = MapPoint.mapPointWithGeoCoord(Double.parseDouble(contentList.getResponse().getBody().getItems().getList().get(i).getMapy()), Double.parseDouble(contentList.getResponse().getBody().getItems().getList().get(i).getMapx()));
            if (!langs.equals("ko")) {//한국어가 아니면
                if (langs.equals("zh")){//기기에서 중국어는 간체자 번체자 구분이 없어서 간체자로 설정해줬음
                    langs="zh-CN";
                }
                try {
                    name = new Papago().execute(name, langs).get();//번역

                } catch (Exception e) {

                }
            }
            //마커 세팅
            mDefaultMarker.setItemName(name);
            mDefaultMarker.setTag(0);
            mDefaultMarker.setMapPoint(DEFAULT_MARKER_POINT);
            mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
            mDefaultMarker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

            //마커 그리기
            mapView.addPOIItem(mDefaultMarker);
            mapView.selectPOIItem(mDefaultMarker, true);
            mapView.setMapCenterPoint(DEFAULT_MARKER_POINT, false);
            i++;
        }


    }
    public void makeMarker(RestaurantList restaurantList, MapView mapView) {
        MapPoint DEFAULT_MARKER_POINT;
        int i = 0;

        String name = "Default";

        langs = Locale.getDefault().getLanguage(); //기기 언어 가져오기
        while (i < restaurantList.getList().size()) {
            mDefaultMarker = new MapPOIItem();
            name = restaurantList.getList().get(i).getPlace_name();
            DEFAULT_MARKER_POINT = MapPoint.mapPointWithGeoCoord(Double.parseDouble(restaurantList.getList().get(i).getY()), Double.parseDouble(restaurantList.getList().get(i).getX()));
            if (!langs.equals("ko")) {//한국어가 아니면
                if (langs.equals("zh")){//기기에서 중국어는 간체자 번체자 구분이 없어서 간체자로 설정해줬음
                    langs="zh-CN";
                }
                try {
                    name = new Papago().execute(name, langs).get();//번역

                } catch (Exception e) {

                }
            }
            //마커 세팅
            mDefaultMarker.setItemName(name);
            mDefaultMarker.setTag(0);
            mDefaultMarker.setMapPoint(DEFAULT_MARKER_POINT);
            mDefaultMarker.setMarkerType(MapPOIItem.MarkerType.BluePin);
            mDefaultMarker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);

            //마커 그리기
            mapView.addPOIItem(mDefaultMarker);
            mapView.selectPOIItem(mDefaultMarker, true);
            mapView.setMapCenterPoint(DEFAULT_MARKER_POINT, false);
            i++;
        }


    }
}
