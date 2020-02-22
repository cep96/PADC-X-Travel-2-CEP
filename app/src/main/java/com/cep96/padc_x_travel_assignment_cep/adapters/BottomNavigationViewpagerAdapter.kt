package com.cep96.padc_x_travel_assignment_cep.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cep96.padc_x_travel_assignment_cep.fragments.BottomNavHomeFragment

class BottomNavigationViewpagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return BottomNavHomeFragment.newInstance()
            1 -> return BottomNavHomeFragment.newInstance()
            2 -> return BottomNavHomeFragment.newInstance()
            3 -> return BottomNavHomeFragment.newInstance()
            4 -> return BottomNavHomeFragment.newInstance()
            else -> return BottomNavHomeFragment.newInstance()
        }
    }
}