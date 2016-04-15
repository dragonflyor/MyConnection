package com.yuzhi.fine.view;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yuzhi.fine.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZNE on 2016/4/12.
 */
public class ChooseDateInputView extends RelativeLayout {

    //private static final String NAMESPACE = "http://schemas.android.com/apk/res/com.com.yuzhi.fine";
    private static final String NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private TextView tvTitle;
    private Button etInput;
    private DatePicker dpChooseDate;

    private String mTitle;
    private String mHint;
    private String mEditText;



    private Date m_date =new Date(System.currentTimeMillis());



    public Date getDate() {
        return m_date;
    }

    public void setDate(Date date) {

        m_date = date;
    }

    public ChooseDateInputView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();

    }

    public ChooseDateInputView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //根据布局属性，取出属性
        mTitle = attrs.getAttributeValue(NAMESPACE, "mtitle_cdv");
        mHint = attrs.getAttributeValue(NAMESPACE, "mhint_cdv");
        mEditText = attrs.getAttributeValue(NAMESPACE, "mtext_cdv");

        initView();

    }

    public ChooseDateInputView(Context context) {
        super(context);
        initView();
    }


    /**
     * 初始化布局
     */
    private void initView(){
        //这个视图添加到，本RelativeLayout容器里面去


        View.inflate(getContext(), R.layout.view_choosedateinput_item, this);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        etInput = (Button)findViewById(R.id.et_input);

        etInput.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getContext(), "选择时间响应", Toast.LENGTH_SHORT).show();
                View diaglogView = View.inflate(getContext(), R.layout.dialog_date, null);

                dpChooseDate = (DatePicker) diaglogView.findViewById(R.id.dp_choosedate);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("选择时间").setView(diaglogView)
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int day = dpChooseDate.getDayOfMonth();
                                int month = dpChooseDate.getMonth();
                                int year = dpChooseDate.getYear();

                                m_date = new Date(year, month, day);

                                etInput.setText(year + "年" + month + "月" + day + "日");
                            }
                        })
                        .show();


            }
        });


        //设置标题
        tvTitle.setText(mTitle);
        //etInput.setText(mEditText);
       // etInput.setHint(mHint);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        String date = simpleDateFormat.format(m_date);
        etInput.setText(date);

    }


    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {

        tvTitle.setText(title);
    }


    /**
     * 文本框内容
     *
     * @param text
     */
    public void setTextM(String text) {
        etInput.setText(text);
    }

    /**
     * 返回输入的文本
     *
     * @return
     */
    public String getTextM() {
        return etInput.getText().toString();
    }

}


