package com.frank.itemdecorationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnDivider;
    Button mBtnDivider1;
    Button mBtnDivider2;
    Button mBtnDivider3;
    TextView mTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnDivider = (Button) findViewById(R.id.btn_divider);
        mBtnDivider1 = (Button) findViewById(R.id.btn_divider1);
        mBtnDivider2 = (Button) findViewById(R.id.btn_divider2);
        mBtnDivider3 = (Button) findViewById(R.id.btn_divider3);
        mTv = (TextView) findViewById(R.id.tv_content);
        mBtnDivider.setOnClickListener(this);
        mBtnDivider1.setOnClickListener(this);
        mBtnDivider2.setOnClickListener(this);
        mBtnDivider3.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.btn_divider:
                Intent intent = new Intent(MainActivity.this,DividerActivity.class);
                startActivity(intent);

                break;
            case R.id.btn_divider1:
                Intent intent1 = new Intent(MainActivity.this,ColorDividerActivity.class);
                startActivity(intent1);

                break;
            case R.id.btn_divider2:
                Intent intent2 = new Intent(MainActivity.this,TimelineActivity.class);
                startActivity(intent2);

                break;
            case R.id.btn_divider3:
                Intent intent3 = new Intent(MainActivity.this,BookRankActivity.class);
                startActivity(intent3);

                break;

            default:
                break;
        }
    }
}
