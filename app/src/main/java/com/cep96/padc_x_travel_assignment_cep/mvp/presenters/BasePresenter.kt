package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import com.cep96.padc_x_travel_assignment_cep.mvp.views.BaseView

interface BasePresenter<T : BaseView> {

    fun initPresenter(view: T)
}