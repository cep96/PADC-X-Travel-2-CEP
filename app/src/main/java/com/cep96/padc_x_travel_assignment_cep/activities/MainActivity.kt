package com.cep96.padc_x_travel_assignment_cep.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.adapters.BottomNavigationViewpagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mBottomNavigationAdapter: BottomNavigationViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setUpBottomNavigation()

        bottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId){
                    R.id.navHome -> {
                        viewPager2.currentItem = 0
                        return true
                    }
                    R.id.navRating -> {
                        viewPager2.currentItem = 1
                        return true
                    }
                    R.id.navFavorite -> {
                        viewPager2.currentItem = 2
                        return true
                    }
                    R.id.navPrice -> {
                        viewPager2.currentItem = 3
                        return true
                    }
                    R.id.navSearch -> {
                        viewPager2.currentItem = 4
                        return true
                    }
                }
                return false
            }

        })


    }

    private fun setUpBottomNavigation() {
        mBottomNavigationAdapter = BottomNavigationViewpagerAdapter(this)
        viewPager2.adapter = mBottomNavigationAdapter

        viewPager2.currentItem = 0
        viewPager2.isUserInputEnabled = false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
