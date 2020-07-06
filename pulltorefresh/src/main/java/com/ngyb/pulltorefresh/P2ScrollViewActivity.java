package com.ngyb.pulltorefresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/6 21:57
 */
public class P2ScrollViewActivity extends AppCompatActivity {

    private PullToRefreshScrollView ptrsv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p2_scroll_view);

        ptrsv = findViewById(R.id.ptrsv);
        ptrsv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        ptrsv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                loadData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                loadData();
            }
        });
    }

    private void loadData() {
        ptrsv.onRefreshComplete();
    }
}
