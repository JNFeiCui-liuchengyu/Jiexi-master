package com.feicui.jiexi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.feicui.jiexi.R;
import com.feicui.jiexi.entity.Entity;
import com.feicui.jiexi.image.ImageLoader;

import java.util.List;

/**
 * Created by ｌ on 2016/6/6.
 */
public class NewsAdapter extends BaseAdapter implements AbsListView.OnScrollListener {
    private       List<Entity>   mEntities;
    private       LayoutInflater inflater;
    private       ImageLoader    mImageLoader;
    public static String[]       URLS;
    private       int            mStart, mEnd;
    private boolean mFristIn;

    public NewsAdapter(Context context, List<Entity> data, ListView listView) {
        mImageLoader = new ImageLoader(listView);
        mEntities = data;
        inflater = LayoutInflater.from(context);
        URLS = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            URLS[i] = data.get(i).icon;
        }
        mFristIn = true;
        listView.setOnScrollListener(this);
    }

    @Override
    public int getCount() {
        return mEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return mEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_list_news, null);
            viewHolder.ivicon = (ImageView) convertView.findViewById(R.id.imageView1);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.textView1);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivicon.setImageResource(R.drawable.defaultpic);
        viewHolder.tvTitle.setText(mEntities.get(position).title);
        viewHolder.tvContent.setText(mEntities.get(position).summary);
        String url = mEntities.get(position).icon;
        viewHolder.ivicon.setTag(url);
        mImageLoader.showImageByAsncTask(viewHolder.ivicon, mEntities.get(position).icon);
        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE) {
            mImageLoader.loadImages(mStart, mEnd);
        } else {
            mImageLoader.cancelAllTask();
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        mStart = firstVisibleItem;
        mEnd=firstVisibleItem+visibleItemCount;
        if (mFristIn==true&&visibleItemCount>0){
            mImageLoader.loadImages(mStart,mEnd);
            mFristIn=false;
        }
    }

    class ViewHolder {
        public ImageView ivicon;
        public TextView  tvTitle, tvContent;
    }
}
