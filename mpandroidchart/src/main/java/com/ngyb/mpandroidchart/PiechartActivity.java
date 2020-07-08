package com.ngyb.mpandroidchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：南宫燚滨
 * 描述：
 * 邮箱：nangongyibin@gmail.com
 * p * 日期：2020/7/8 21:22
 */
public class PiechartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PieChart pieChart = new PieChart(this);
        setContentView(pieChart);
        //设置饼状图的数据
        pieChart.setData(getPieData());
        //设置描述
        Description description = new Description();
        description.setText("胡萝卜维生素成分比例");
        description.setTextSize(20);
        pieChart.setDescription(description);
        //设置中心说明文字
        pieChart.setCenterText("中心说明文字");
        pieChart.setCenterTextSize(20);
        pieChart.setCenterTextColor(Color.RED);
        pieChart.animateXY(3000, 3000);
    }

    private PieData getPieData() {
        List<PieEntry> list = new ArrayList<>();
        list.add(new PieEntry(33f, "维生素A"));
        list.add(new PieEntry(33f, "维生素B"));
        list.add(new PieEntry(34f, "维生素C"));
        //创建一组饼块的数据
        PieDataSet pieDataSet = new PieDataSet(list, "");
        //设置饼块的间距
        pieDataSet.setSliceSpace(4);
        //设置饼块的颜色
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        pieDataSet.setColors(colors);
        //创建x轴
        PieData pieData = new PieData(pieDataSet);
        return pieData;
    }
}
