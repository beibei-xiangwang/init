package com.beibei.init.view.activity

import android.os.Build
import android.view.View
import com.beibei.init.R
import com.beibei.init.base.BaseActivity
import com.beibei.init.base.BaseFragment
import com.beibei.init.common.networkJava.request.InitDataNoParamRequest
import com.beibei.init.common.utils.LogUtils
import com.beibei.init.common.utils.StatusBarUtil
import com.beibei.init.common.utils.StatusUiTextUtils
import com.beibei.init.presenter.MainHelper
import com.beibei.init.presenter.viewinter.MainView

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), MainView {
    private var mMainHelper: MainHelper? = null//MainActivity业务处理类

    override val layoutId: Int
        get() = R.layout.activity_main

    override fun initView() {
        mMainHelper = MainHelper(this, this, lifecycle)
        lifecycle.addObserver(mMainHelper!!)
        registerNetBroadcastReceiver()

        mMainHelper?.getUserInfo(InitDataNoParamRequest("126"))

        tv.setOnClickListener {
//            startActivity(PermissionActivity::class.java)
//            startActivity(PermissionActivity1::class.java)
//            startActivity(SettingActivity::class.java)

            StatusBarUtil.setColor(this, resources.getColor(R.color.color_red), 0)
            StatusBarUtil.setLightMode(this)
//            val inspectNet = getCurrentNetStatus()
//            ToastUtils.showToast(this, "-----" + inspectNet.toString())



//            RxBus.instance.post(MessageEvent(Constant.MINE_MODIFY_INFO, ""))
        }
    }

    override fun initData() {
    }

    override fun setStatusBar() {
//        setStatusBarFull(this, 0, null, true)
//        setUiTextColor(true)
        StatusBarUtil.setDarkMode(this)
        StatusBarUtil.setColor(this, resources.getColor(R.color.colorPrimary), 0)
    }

    override fun setText(type: String) {
        tv.text = "______$type"
    }

    override fun reConnectNet() {
        mMainHelper?.getUserInfo(InitDataNoParamRequest("126"))
    }

    fun setStatusBarFull(`object`: Any, statusbarApha: Int, view: View?, isDarkColor: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (`object` is BaseFragment) {
                StatusBarUtil.setTranslucentForImageViewInFragment(this, statusbarApha, view)//顶部图片展示在顶部
            } else if (`object` is BaseActivity) {
                StatusBarUtil.setTranslucentForImageView(this, 0, null)//顶部图片展示在顶部
            }
            setUiTextColor(isDarkColor)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            StatusBarUtil.setColor(this, resources.getColor(R.color.base_theme),0)
        }
    }

    /**
     * 设置状态栏
     */
    fun setUiTextColor(isFull: Boolean): Boolean {
        var isAdaptation = false
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {//4.4以上系统仅对魅族，小米做过适配
            if (StatusUiTextUtils.FlymeSetStatusBarLightMode(this.window, isFull)) {
                isAdaptation = true
                LogUtils.e("===============Flyme======Flyme==============" + isAdaptation)
            } else {
                isAdaptation = StatusUiTextUtils.MIUISetStatusBarLightMode(this.window, isFull)
                LogUtils.e("===============MiUi======MiUi==============" + isAdaptation)
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//6.0系统改变字体颜色
            if (isFull) {
                this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                this.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_VISIBLE
            }
            isAdaptation = true
        }
        return isAdaptation
    }
}
