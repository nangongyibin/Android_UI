package com.ngyb.pinnedsectionlistview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.halfbit.pinnedsection.PinnedSectionListView;

public class MainActivity extends AppCompatActivity {

    private PinnedSectionListView pslv;
    private List<Object> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pslv = findViewById(R.id.pslv);

        initData();
        MyAdapter myAdapter = new MyAdapter();
        pslv.setAdapter(myAdapter);
    }

    private void initData() {
        Category category = new Category("小学生");
        list.add(category);
        for (int i = 0; i < 10; i++) {
            list.add(new Student("小学生" + i));
        }
        list.add(new Category("中学生"));
        for (int i = 0; i < 20; i++) {
            list.add(new Student("中学生" + i));
        }
    }

    private class MyAdapter extends BaseAdapter implements PinnedSectionListView.PinnedSectionListAdapter {

        @Override
        public boolean isItemViewTypePinned(int viewType) {
            if (viewType == 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            if (list.get(position) instanceof Category) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int type = getItemViewType(position);
            TextView tv = null;
            if (type == 0) {
                if (convertView == null) {
                    tv = new TextView(getApplicationContext());
                    tv.setTextSize(18);
                    tv.setTextColor(Color.WHITE);
                    tv.setPadding(8, 8, 8, 8);
                    tv.setBackgroundColor(Color.parseColor("#000000"));
                } else {
                    tv = (TextView) convertView;
                }
                Category category = (Category) list.get(position);
                tv.setText(category.name);
            } else if (type == 1) {
                if (convertView == null) {
                    tv = new TextView(getApplicationContext());
                    tv.setTextSize(16);
                    tv.setTextColor(Color.BLACK);
                    tv.setPadding(6, 6, 6, 6);
                } else {
                    tv = (TextView) convertView;
                }
                Student student = (Student) list.get(position);
                tv.setText(student.name);
            }
            return tv;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }
}
