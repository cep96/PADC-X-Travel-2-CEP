package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travel_assignment_cep.mvp.views.PopularToursDetailView

class PopularToursDetailPresenterImpl: PopularToursDetailPresenter,
    AbstractBasePresenter<PopularToursDetailView>() {

    private val mToursModel = ToursModelImpl

    override fun onUIReady(lifecycleOwner: LifecycleOwner, name: String) {
        mToursModel.getCountryByName(name).observe(
            lifecycleOwner, Observer { country ->
                if (country == null){
                    mView?.showEmptyView()
                }else{
                    mView?.hideEmptyView()
                    mView?.displayToursDetails(country)
                }

            }
        )

//        mToursModel.getTourByName(name)
//            .observe(lifecycleOwner, Observer { tour ->
//                if (tour == null){
//                    mView?.showEmptyView()
//                }else{
//                    mView?.hideEmptyView()
//                    mView?.displayToursDetails(tour)
//                }
//
//            })
    }


}