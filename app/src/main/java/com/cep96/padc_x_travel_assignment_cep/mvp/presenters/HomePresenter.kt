package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.cep96.padc_x_travel_assignment_cep.mvp.views.HomeView

interface HomePresenter: BasePresenter<HomeView> {
    fun onUIReady()
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onToursUIReady(lifecycleOwner: LifecycleOwner)
    fun onTapTourItem(name: String)
    fun onTapCountryItem(name : String)
}