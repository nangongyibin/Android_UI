package com.ngyb.pulltorefresh;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/6 21:36
 */
public class P2RefreshGridViewActivity extends AppCompatActivity {

    private PullToRefreshGridView ptfgv;
    private List<String> datas = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_refresh_grid_view);

        ptfgv = findViewById(R.id.ptfgv);
        ptfgv.setMode(PullToRefreshBase.Mode.BOTH);
        GridView refreshableView = ptfgv.getRefreshableView();
        refreshableView.setNumColumns(3);
        ptfgv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                loadData(true);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                loadData(false);
            }
        });
        myAdapter = new MyAdapter();
        refreshableView.setAdapter(myAdapter);
    }

    private void loadData(boolean isPullDown) {
        if (isPullDown){
            datas.add(0,"下拉刷新的数据"+ UUID.randomUUID().toString());
        }else{
            datas.add("上拉刷新的数据"+UUID.randomUUID().toString());
        }
        myAdapter.notifyDataSetChanged();
        ptfgv.onRefreshComplete();
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = null;
            if (convertView ==null){
                tv = new TextView(getApplicationContext());
                tv.setTextColor(Color.BLACK);
                tv.setPadding(6,6,6,6);
                tv.setTextSize(20);
            }else{
                tv = (TextView) convertView;
            }
            tv.setText(datas.get(position));
            return tv;
        }
    }
}
