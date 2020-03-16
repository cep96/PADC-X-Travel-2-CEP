package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import androidx.lifecycle.ViewModel
import com.cep96.padc_x_travel_assignment_cep.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView> : BasePresenter<T>, ViewModel() {

    var mView: T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}