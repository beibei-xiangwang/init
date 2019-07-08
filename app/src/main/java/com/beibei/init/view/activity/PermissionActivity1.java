package com.beibei.init.view.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

import com.beibei.init.R;
import com.beibei.init.base.BaseActivity;
import com.beibei.init.common.utils.ToastUtils;

/**
 * project_name:   init
 * package_name:   com.beibei.init.view.activity
 * author:   beibei
 * create_time:    2018/10/9 17:10
 * class_desc: 原生的权限请求
 * remarks:
 */
public class PermissionActivity1 extends BaseActivity {
    private final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    Button button;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_permission;
    }

    @Override
    protected void initData() {

    }

    private void openContact() {
        ToastUtils.showToast(this, "打开联系人");
    }


    @Override
    protected void initView() {
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasPermissions(Manifest.permission.READ_CONTACTS)) {
                    openContact();
                } else {
                    requestPermissions(MY_PERMISSIONS_REQUEST_READ_CONTACTS, Manifest.permission.READ_CONTACTS);
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openContact();
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                        showPermissionRationale("该功能需要通讯录权限，请授权后使用", MY_PERMISSIONS_REQUEST_READ_CONTACTS, Manifest.permission.READ_CONTACTS);
                    } else {
                        showPermissionSetting("通讯录权限", "打开联系人功能");
                    }
                }
                return;
            }
        }
    }
}
