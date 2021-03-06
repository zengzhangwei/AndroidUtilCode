package com.blankj.launcher.pkg

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import com.blankj.base.BaseDrawerActivity
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.BusUtils
import kotlinx.android.synthetic.main.activity_main.*


/**
 * ```
 * author: Blankj
 * blog  : http://blankj.com
 * time  : 2016/09/29
 * desc  : MainActivity
 * ```
 */
class MainActivity : BaseDrawerActivity() {

    override fun initData(bundle: Bundle?) {

    }

    override fun bindLayout(): Int {
        return R.layout.activity_main
    }

    override fun initView(savedInstanceState: Bundle?, contentView: View) {
        launcherMainCtl.setExpandedTitleColor(Color.TRANSPARENT)
        setSupportActionBar(launcherMainToolbar)
        val toggle = ActionBarDrawerToggle(this,
                mDrawerRootLayout,
                launcherMainToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        mDrawerRootLayout.addDrawerListener(toggle)
        toggle.syncState()

        BarUtils.setStatusBarAlpha4Drawer(this, mDrawerRootLayout, launcherMainFakeStatusBar, 0, false)
        BarUtils.addMarginTopEqualStatusBarHeight(launcherMainToolbar)

//        launcherMainCoreUtilBtn.setOnClickListener {
//            BusUtils.post<Any>("CoreUtilActivity#start", this)
//        }
//
//        launcherMainSubUtilBtn.setOnClickListener {
//            BusUtils.post<Any>("SubUtilActivity#start", this)
//        }
    }

    override fun doBusiness() {

    }

    override fun onWidgetClick(view: View) {

    }

    fun coreUtilClick(view: View) {

    }

    fun subUtilClick(view: View) {
        BusUtils.post<Any>("SubUtilActivity#start", this)
    }

    override fun onBackPressed() {
        ActivityUtils.startHomeActivity()
    }
}
