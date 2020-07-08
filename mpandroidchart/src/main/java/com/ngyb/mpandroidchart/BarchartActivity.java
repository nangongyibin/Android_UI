package com.ngyb.mpandroidchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * 日期：2020/7/8 20:56
 */
public class BarchartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建条形数据对象
        BarChart barChart = new BarChart(this);
        setContentView(barChart);
        //设置条形数据
        barChart.setData(getBarData());
        barChart.groupBars(0f,0.06f,0.02f);
        //设置描述
        Description description = new Description();
        description.setText("2019行业薪资比较");
        barChart.setDescription(description);
        //设置绘制Bar的阴影
        barChart.setDrawBarShadow(true);
        //设置绘制的动画时间
        barChart.animateXY(3000,3000);
//        barChart.invalidate();
    }

    private BarData getBarData() {
        int maxX =10;
        //创建集合，存放每个柱子的数据
        List<BarEntry> list1 = new ArrayList<>();
        List<BarEntry> list2 = new ArrayList<>();
        for (int i = 0; i < maxX; i++) {
            //一个BarEntry就是一个柱子的数据对象
            BarEntry barEntry1 = new BarEntry(i,i + 5);
            list1.add(barEntry1);
            BarEntry barEntry2 = new BarEntry(i,i + 3);
            list2.add(barEntry2);
        }
        //创建BarDataSet对象，其实就是一组柱形数据
        BarDataSet barDataSet1 = new BarDataSet(list1, "Android");
        BarDataSet barDataSet2 = new BarDataSet(list2, "ios");
        //设置柱形的颜色
        barDataSet1.setColor(Color.BLUE);
        //设置是否显示柱子上面的数值
        barDataSet1.setDrawValues(false);
        //设置柱子阴影的颜色
        barDataSet1.setBarShadowColor(Color.GRAY);
        //创建集合，存放所有组的柱形数据
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
//        BarData barData = new BarData(dataSets);
        BarData barData = new BarData(barDataSet1, barDataSet2);
        barData.setBarWidth(0.45f);
        return barData;
    }
}
