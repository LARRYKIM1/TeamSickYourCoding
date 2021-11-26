package com.example.SwDevSec.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.SwDevSec.Activity.DTO.SerDTO;
import com.example.SwDevSec.ListViewAdapter;
import com.example.SwDevSec.R;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EventListActivity extends AppCompatActivity implements AbsListView.OnScrollListener{
    private String language;
    private String typeCode;
    private String areacode;

    private ListView listView;                      // 리스트뷰
    private boolean lastItemVisibleFlag = false;    // 리스트 스크롤이 마지막 셀(맨 바닥)로 이동했는지 체크할 변수
    private List<SerDTO> list_sfd;                      // String 데이터를 담고있는 리스트
    private ListViewAdapter adapter;                // 리스트뷰의 아답터
    private int page = 0;                           // 페이징변수. 초기 값은 0 이다.
    private final int OFFSET = 20;                  // 한 페이지마다 로드할 데이터 갯수.
    private ProgressBar progressBar;                // 데이터 로딩중을 표시할 프로그레스바
    private boolean mLockListView = false;          // 데이터 불러올때 중복안되게 하기위한 변수
    private int pageNum=1;
    //사진가져올때 스레드
    Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        Intent preintent = getIntent();
        language=preintent.getExtras().getString("language");
        typeCode=preintent.getExtras().getString("typeCode");
        areacode=preintent.getExtras().getString("areacode");

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.printf("%s %s %s \n",language,typeCode,areacode);
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        listView = (ListView) findViewById(R.id.listview);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        list_sfd = new ArrayList<SerDTO>();
        adapter = new ListViewAdapter(this, list_sfd);
        listView.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);


        listView.setOnScrollListener(this);
        getItem(language,typeCode,areacode);

    }
    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        // 1. OnScrollListener.SCROLL_STATE_IDLE : 스크롤이 이동하지 않을때의 이벤트(즉 스크롤이 멈추었을때).
        // 2. lastItemVisibleFlag : 리스트뷰의 마지막 셀의 끝에 스크롤이 이동했을때.
        // 3. mLockListView == false : 데이터 리스트에 다음 데이터를 불러오는 작업이 끝났을때.
        // 1, 2, 3 모두가 true일때 다음 데이터를 불러온다.
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE && lastItemVisibleFlag && mLockListView == false) {
            // 화면이 바닦에 닿을때 처리
            // 로딩중을 알리는 프로그레스바를 보인다.
            progressBar.setVisibility(View.VISIBLE);

            // 다음 데이터를 불러온다.
            getItem( language, typeCode, areacode );
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // firstVisibleItem : 화면에 보이는 첫번째 리스트의 아이템 번호.
        // visibleItemCount : 화면에 보이는 리스트 아이템의 갯수
        // totalItemCount : 리스트 전체의 총 갯수
        // 리스트의 갯수가 0개 이상이고, 화면에 보이는 맨 하단까지의 아이템 갯수가 총 갯수보다 크거나 같을때.. 즉 리스트의 끝일때. true
        lastItemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount >= totalItemCount);
    }




    private void getItem(String language, String typeCode, String areacode){
        // 리스트에 다음 데이터를 입력할 동안에 이 메소드가 또 호출되지 않도록 mLockListView 를 true로 설정한다.
        mLockListView = true;

        fetchJSON(pageNum, language,typeCode,areacode);
        pageNum=pageNum+1;

        // 1초 뒤 프로그레스바를 감추고 데이터를 갱신하고, 중복 로딩 체크하는 Lock을 했던 mLockListView변수를 풀어준다.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page++;
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                mLockListView = false;
            }
        },3000);

    }

    public void fetchJSON(final int pageNum, final String language, final String typeCode, final String areacode){
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL("http://52.231.70.45:8080/SickYourCoding/ten.do?lang="+language+"&ContentTypeID="+typeCode+"&areacode="+areacode+"&num="+pageNum);
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println(url.toString());
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                    conn.setReadTimeout(10000 /* milliseconds */);
//                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setReadTimeout(25000 /* milliseconds */);
                    conn.setConnectTimeout(35000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    // Starts the query
                    conn.connect();
                    InputStream stream = conn.getInputStream();
                    String data = convertStreamToString(stream);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@");
                    System.out.println(data);
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@");
                    readAndParseJSON(data);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void readAndParseJSON(String in) {
        Gson gson = new Gson();
        try {
            JSONArray jsonArray = new JSONArray(in);

            int index = 0;
            while (index < jsonArray.length()) {
                final SerDTO sfd = gson.fromJson(jsonArray.get(index).toString(), SerDTO.class);
//                Bitmap img=sfd.getFirstimage();
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            String imageUrl=sfd.getFirstimage();
                            URL url = new URL(imageUrl);
                            InputStream is = url.openStream();
                            final Bitmap bm = BitmapFactory.decodeStream(is);
                            sfd.setFirstimageBM(bm);
                        } catch(Exception e){

                        }

                    }
                });
                t.start();

                list_sfd.add(sfd);
                index++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
