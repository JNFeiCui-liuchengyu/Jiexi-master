package com.feicui.jiexi.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.feicui.jiexi.R;
import com.feicui.jiexi.adapter.NewsAdapter;
import com.feicui.jiexi.common.BrowseNews;
import com.feicui.jiexi.common.GetNews;
import com.feicui.jiexi.common.NewlListFromJson;
import com.feicui.jiexi.entity.Entity;

import java.util.List;

public class ActivityMain extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private NewlListFromJson json;
    private static final String TAG = "ActivityMain";
    private NewsAdapter adapter;
    private ListView    mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setOnItemClickListener(this);
        mListView.setAdapter(adapter);
        String url = GetNews.getRequest();
        json = new NewlListFromJson();
        new MyAsncTasy().execute(url);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String news = json.list.get(position).getLink();
        Log.d(TAG, "链接为******** " + news);
        Intent intent = new Intent(ActivityMain.this, BrowseNews.class);
        intent.putExtra("link", news);
        startActivity(intent);
        finish();
    }

    private class MyAsncTasy extends AsyncTask<String, Void, List<Entity>> {
        @Override
        protected List<Entity> doInBackground(String... params) {
            return json.getJsonData();

        }

        @Override
        protected void onPostExecute(List<Entity> entities) {
            super.onPostExecute(entities);
            NewsAdapter adapter=new NewsAdapter(ActivityMain.this,entities,mListView);
            mListView.setAdapter(adapter);
        }
    }

}
