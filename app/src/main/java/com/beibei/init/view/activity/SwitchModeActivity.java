package com.beibei.init.view.activity;

import android.view.View;
import android.widget.Button;

import com.beibei.init.R;
import com.beibei.init.base.BaseActivity;
import com.beibei.init.common.utils.StatusBarUtil;


/**
 * Created by jaeger on 08/03/2018.
 *
 * Email: chjie.jaeger@gmail.com
 * GitHub: https://github.com/laobie
 */

public class SwitchModeActivity extends BaseActivity {
    private Button mBtnSetLightMode;
    private Button mBtnSetDarkMode;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_switch_mode);
//
//        mBtnSetLightMode = findViewById(R.id.btn_set_light_mode);
//        mBtnSetDarkMode = findViewById(R.id.btn_set_dark_mode);
//
//        mBtnSetLightMode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int color = getResources().getColor(R.color.circle_color_blue);
//                StatusBarUtil.setColor(SwitchModeActivity.this, color, 30);
//                StatusBarUtil.setLightMode(SwitchModeActivity.this);
//            }
//        });
//
//        mBtnSetDarkMode.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int color = getResources().getColor(R.color.colorPrimary);
//                StatusBarUtil.setColor(SwitchModeActivity.this, color);
//                StatusBarUtil.setDarkMode(SwitchModeActivity.this);
//            }
//        });
//    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_switch_mode;
    }

    @Override
    protected void initView() {

        mBtnSetLightMode = findViewById(R.id.btn_set_light_mode);
        mBtnSetDarkMode = findViewById(R.id.btn_set_dark_mode);

        mBtnSetLightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.circle_color_blue);
                StatusBarUtil.setColor(SwitchModeActivity.this, color, 30);
                StatusBarUtil.setLightMode(SwitchModeActivity.this);
            }
        });

        mBtnSetDarkMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = getResources().getColor(R.color.colorPrimary);
                StatusBarUtil.setColor(SwitchModeActivity.this, color);
                StatusBarUtil.setDarkMode(SwitchModeActivity.this);
            }
        });
    }

    @Override
    protected void initData() {

    }
}
