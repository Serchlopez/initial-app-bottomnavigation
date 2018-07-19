package com.edilfonico.edilfonico.activities

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import android.widget.FrameLayout
import com.edilfonico.edilfonico.R
import com.edilfonico.edilfonico.fragments.FavoriteFragment
import com.edilfonico.edilfonico.fragments.HomeFragment
import com.edilfonico.edilfonico.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private var mMainNav:BottomNavigationView? = null
    private var mMainFrame:FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainNav = findViewById(R.id.main_nav)
        mMainFrame = findViewById(R.id.main_frame)
        val homeFr = HomeFragment()
        val favoriteFr = FavoriteFragment()
        val settingsr = SettingsFragment()
        setFragment(homeFr,false,"home")
        mMainNav?.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    setFragment(homeFr,false,"home")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_favorite-> {
                    setFragment(favoriteFr,false,"favorite")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.nav_settings -> {
                    setFragment(settingsr,false,"settings")
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener false
        }
    }
    private fun setFragment(fragment: Fragment, addToBackStack: Boolean, tag: String){
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.main_frame, fragment, tag)
        ft.commitAllowingStateLoss()
    }
}
