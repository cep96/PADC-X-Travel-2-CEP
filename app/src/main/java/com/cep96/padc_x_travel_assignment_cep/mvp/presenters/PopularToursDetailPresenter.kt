package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import androidx.lifecycle.LifecycleOwner

interface PopularToursDetailPresenter {

    fun onUIReady(lifecycleOwner: LifecycleOwner, name: String)
}