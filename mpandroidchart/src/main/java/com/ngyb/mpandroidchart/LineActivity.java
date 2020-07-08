package com.ngyb.mpandroidchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/7 23:01
 */
public class LineActivity extends AppCompatActivity {

    private LineChart lc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        lc = findViewById(R.id.lc);
        //设置没有数据时候展示的文本
        lc.setNoDataText("目前木有数据哦");
        //给lc设置数据
        lc.setData(getLineData());
        //设置Y轴的取值范围
        YAxis axisLeft = lc.getAxisLeft();
        //设置Y轴的最小值
        axisLeft.setAxisMinValue(0);
        //设置Y轴的最大值
        axisLeft.setAxisMaxValue(65);
        //设置去掉右边的Y轴线
        YAxis axisRight = lc.getAxisRight();
        axisRight.setEnabled(false);
        //设置是否启用X轴线
        XAxis xAxis = lc.getXAxis();
        //显示X轴线
        xAxis.setEnabled(true);
        //设置表格描述信息
        Description description = new Description();
        description.setText("表格描述");
        lc.setDescription(description);
        //设置是否绘制表格背景
        lc.setDrawGridBackground(true);
        //设置表格网格背景的颜色
        lc.setGridBackgroundColor(Color.WHITE);
        //设置绘制动画的时间
        lc.animateXY(3000, 3000);
    }

    private LineData getLineData() {
        int maxX = 10;
        List<Entry> entryList = new ArrayList<>();
        List<Entry> entryList2 = new ArrayList<>();
        for (int i = 0; i < maxX; i++) {
            Entry entry = new BarEntry(i, i * 5);
            entryList.add(entry);
            Entry entry2 = new BarEntry(i, i * 6 + 5);
            entryList2.add(entry2);
        }
        LineDataSet dataSet = new LineDataSet(entryList, "Line1");
        LineDataSet dataSet2 = new LineDataSet(entryList2, "Line2");
        dataSet.setLineWidth(4);
        dataSet.setColor(Color.RED);
        dataSet.setDrawCircleHole(false);
        dataSet.setDrawCircles(false);
        LineData lineData = new LineData(dataSet, dataSet2);
        return lineData;
    }
}
