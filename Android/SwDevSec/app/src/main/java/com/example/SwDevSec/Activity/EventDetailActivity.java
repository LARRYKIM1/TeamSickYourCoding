package com.example.SwDevSec.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SwDevSec.Activity.DTO.DetSerDTO;
import com.example.SwDevSec.R;

import net.daum.mf.map.api.CameraUpdateFactory;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Locale;

import static android.speech.tts.TextToSpeech.ERROR;

public class EventDetailActivity extends MapBaseActivity {
    DetSerDTO bf;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
//    private TextView textView8;
//    private MapView mMapView;
    private TextToSpeech tts;
    private Button TTSbutton1;
    private ToggleButton TTSbutton2;
    private Button Zzimbutton;
    

    Intent intent;
    String contentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);


        intent = getIntent();
        //String contentId = getIntent().getParcelableExtra("contentId");

        contentId  = intent.getStringExtra("contentId");
        System.out.println("@@@@@@@@@+++@@@@@@@+++@@@@@@@@@+++@@@@@@@@@@@@@");
        System.out.println("넘어온 contentId:"+contentId);
        System.out.println("@@@@@@@@@+++@@@@@@@@@@+++@@@@@@@@@@@@@@+++@@@@@");
        /*System.out.println("#############################################");
        System.out.println("contentId: "+contentId);
        System.out.println("#############################################");*/

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
//        textView8 = findViewById(R.id.textView8);
        TTSbutton1 = findViewById(R.id.TTSbutton1);
        TTSbutton2 = findViewById(R.id.TTSbutton2);
        Zzimbutton = findViewById(R.id.Zzimbutton);
        ////mapView = findViewById(R.id.mapView1);
        getFestivalDetailData();
        ////mapView.getMapAsync(this);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != ERROR) {
                    // 언어를 선택한다.
                    tts.setLanguage(Locale.KOREAN);
                }
            }
        });

        TTSbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.8f);
                // textView7에 있는 overview 문장을 읽는다.
                tts.speak(textView7.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        Zzimbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.8f);
                // textView7에 있는 overview 문장을 읽는다.
                tts.speak(textView7.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });
       /* TTSbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.setPitch(1.0f);
                tts.setSpeechRate(0.8f);
                // textView7에 있는 overview 문장을 읽는다.
                tts.speak(textView7.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });*/

      /*  mMapView = (MapView) findViewById(R.id.map_view);
        //mMapView.setDaumMapApiKey(MapApiConst.DAUM_MAPS_ANDROID_APP_API_KEY);
        mMapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        mMapView.setMapRotationAngle(0,true);
        mMapView.setCurrentLocationEventListener(this);*/

    }
    public void onToggleClicked(View v){

        boolean on = ((ToggleButton) v).isChecked();

        if(on){
            tts.stop();
//            tts.shutdown();
        }  else {
            tts.setPitch(1.0f);
            tts.setSpeechRate(0.6f);
            // textView7에 있는 overview 문장을 읽는다.
            tts.speak(textView7.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거한다.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }

    public void getFestivalDetailData() {
        // 쓰레드를 생성하여 돌리는 구간
        new Thread(new Runnable() {
            @Override
            public void run() {
                bf = getData(); // 하단의 getData 메소드를 통해 데이터를 파싱
                /*System.out.println("@@@@@@@@@@@출력@@@@@@@@@@@@");
                for(int i = 0; i < listData.size(); i++) {
                    System.out.println("고유넘버: "+listData.get(i).getContentid());
                    System.out.println("주소: "+listData.get(i).getAdrr1());
                    System.out.println("이름: "+listData.get(i).getTitle());
                    System.out.println();
                }
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@");*/
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textView1.setText(bf.getTitle());
                        textView2.setText(bf.getAddr());
                        textView4.setText(bf.getEventstartdate());
                        textView3.setText(bf.getEventenddate());
                        //textView5.setText(bf.getHomepage());
                        textView6.setText(bf.getTel());
                        textView7.setText(bf.getOverview());
                    }
                });
            }
        }).start();
    }

    DetSerDTO getData(){
        String queryUrl = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/detailCommon?serviceKey=RaV1p1mncJrI16%2FeEpAT4KOYzG4MiOjznmMztcqmpqOpOLyarHG7cGIJLi4fomlJ78hapy10Zm7fthL%2BWw5BLA%3D%3D" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&MobileOS=ETC" +
                "&MobileApp=AppTest" +
                "&contentId=" +contentId+
                "&defaultYN=Y" +
                "&firstImageYN=Y" +
                "&areacodeYN=Y" +
                "&catcodeYN=Y" +
                "&addrinfoYN=Y" +
                "&mapinfoYN=Y" +
                "&overviewYN=Y";

        DetSerDTO sf=null;

        try {
            //SmallFestDTO sf=null;

            URL url = new URL(queryUrl);
            InputStream is = url.openStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new InputStreamReader(is, "UTF-8"));
            String tag;
            xpp.next();
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        //listData2=new ArrayList<>();
                        break;

                    case XmlPullParser.START_TAG:
                        tag = xpp.getName();
                        if (tag.equals("item")){
                            sf=new DetSerDTO();
                        }else if (tag.equals("addr1")) {
                            xpp.next();
                            sf.setAddr(xpp.getText());
                        }else if (tag.equals("overview")) {
                            xpp.next();
                            sf.setOverview(xpp.getText());
                        } else if (tag.equals("title")) {
                            xpp.next();
                            sf.setTitle(xpp.getText());
                        } else if (tag.equals("eventenddate")) {
                            xpp.next();
                            sf.setEventenddate(xpp.getText());
                        } else if (tag.equals("eventstartdate")) {
                            xpp.next();
                            sf.setEventstartdate(xpp.getText());
                        } else if (tag.equals("firstimage")) {
                            xpp.next();
                            sf.setFirstimage(xpp.getText());
                        } else if (tag.equals("homepage")) {
                            xpp.next();
                            sf.setHomepage(xpp.getText());
                        } else if (tag.equals("tel")) {
                            xpp.next();
                            sf.setTel(xpp.getText());
                        } else if (tag.equals("mapx")) {
                            xpp.next();
                            sf.setMapx(xpp.getText());
                        } else if (tag.equals("mapy")) {
                            xpp.next();
                            sf.setMapy(xpp.getText());
                        }
                        break;

                    case XmlPullParser.TEXT:
                        break;

                    case XmlPullParser.END_TAG:
                        tag = xpp.getName(); // 태그 이름 얻어오기
                        if (tag.equals("item")) {
                           /* System.out.println("위치: "+sf.getAdrr1());
                            System.out.println("제목: "+sf.getTitle());
                            System.out.println("시작일: "+sf.getEventenddate());
                            System.out.println("종료일: "+sf.getEventstartdate());
                            System.out.println("고유넘버: "+sf.getContentid());*/
                            //listData2.add(sf);
                        }
                        break;
                }
                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sf;
    }

    /*@Override
    public void onMapReady(GoogleMap googleMap) {
       *//* int latitude=Integer.parseInt(bf.getMapx());
        int longitude=Integer.parseInt(bf.getMapy());*//*

        //LatLng festLoc = new LatLng(latitude, longitude);
        LatLng festLoc = new LatLng(37.56, 126.97);

        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(festLoc);

        markerOptions.title("축제위치");

        markerOptions.snippet("여기뭐지");

        googleMap.addMarker(markerOptions);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(festLoc));

        googleMap.animateCamera(CameraUpdateFactory.zoomTo(13));
    }*/
}
