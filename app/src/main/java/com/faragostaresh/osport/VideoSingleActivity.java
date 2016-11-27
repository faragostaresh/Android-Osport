package com.faragostaresh.osport;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.faragostaresh.adapter.VideoListAdapter;
import com.faragostaresh.adapter.Config;
import com.faragostaresh.adapter.Video;

import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class VideoSingleActivity extends AppCompatActivity {

    //Creating a List of Video
    public static int videoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_single);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get video id
        Bundle extras = getIntent().getExtras();
        videoId = extras.getInt("id");

        // Set json url
        String url = Config.DATA_URL_SINGLE + videoId;

        //Showing a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Loading Data", "Please wait...",false,false);

        //Creating a json array request
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Dismissing progress dialog
                        loading.dismiss();

                        Video videoSingle = new Video();
                        JSONObject json = null;
                        try {
                            json = response.getJSONObject(0);

                            setTitle(json.getString(Config.TAG_TITLE));

                            TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
                            textViewTitle.setText(json.getString(Config.TAG_TITLE));

                            String mime = "text/html";
                            String encoding = "utf-8";
                            String html = "<div id='player'></div><script type='text/javascript' src='http://qp-bin.k-cdn.net/stable/qplayer.js'></script><script type='text/javascript'>var url = 'http://www.qmery.com/video/" +  json.getString(Config.TAG_QMERY_HASH) + ".json';var playerinstance=qplayer('player');playerinstance.setup(url);</script>";
                            WebView playerWebView = (WebView) findViewById(R.id.playerWebView);
                            playerWebView.clearCache(true);
                            playerWebView.clearHistory();
                            playerWebView.getSettings().setJavaScriptEnabled(true);
                            playerWebView.getSettings().setDomStorageEnabled(true);
                            playerWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                            playerWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);;
                            playerWebView.loadDataWithBaseURL(null, html, mime, encoding, null);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        //Creating request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(jsonArrayRequest);





    }
}
