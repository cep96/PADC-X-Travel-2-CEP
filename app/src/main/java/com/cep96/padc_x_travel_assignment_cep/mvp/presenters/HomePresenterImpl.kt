package com.cep96.padc_x_travel_assignment_cep.mvp.presenters

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModel
import com.cep96.padc_x_travel_assignment_cep.mvp.views.HomeView
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import io.reactivex.android.schedulers.AndroidSchedulers

class HomePresenterImpl: HomePresenter, AbstractBasePresenter<HomeView>() {

    override fun onUIReady() {

    }

    override fun onTapTourItem(name: String) {
        mView?.navigateToTourDetails(name)
    }

    override fun onTapCountryItem(name: String) {
        mView?.navigateToCountryDetails(name)
    }

    var mViewModel: ToursModel = ToursModelImpl


    override fun onSwipeRefresh(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    override fun onToursUIReady(lifecycleOwner: LifecycleOwner) {
        requestData(lifecycleOwner)
    }

    @SuppressLint("CheckResult")
    private fun requestData(lifecycleOwner: LifecycleOwner) {
        mView?.enableSwipeRefresh()

        //load data from network and save to DB
        mViewModel.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                ToursModelImpl.saveToDatabase(it.tours, it.countries)
            },{
                Log.e("TAG",it.localizedMessage)
            })


        //retrieve from database
        mViewModel.getAllCountries {}
            .observe(lifecycleOwner,Observer {
                if (it==null || it.isEmpty()){

                }else{

                }
                it.let {
                    mView?.displayCountriesList(it)
                }
                mView?.disableSwipeRefresh()
            })

        ToursModelImpl.getAllTours {}
            .observe(lifecycleOwner, Observer {
                it.let {
                    mView?.displayToursList(it)
                }
                mView?.disableSwipeRefresh()
            })

    }
}