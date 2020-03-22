package com.cep96.padc_x_travel_assignment_cep.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import io.reactivex.android.schedulers.AndroidSchedulers

class ToursViewModel: ViewModel() {

    private val mTourViewModel = ToursModelImpl

    private val popularToursList = MutableLiveData<List<ToursVO>>()
    private val countryList = MutableLiveData<List<CountryVO>>()

    private val errorLiveData = MutableLiveData<String>()


    fun getPopularToursLiveData(): MutableLiveData<List<ToursVO>>{
        return popularToursList
    }

    fun getCountriesLiveData(): MutableLiveData<List<CountryVO>>{
        return countryList
    }

    fun getErrorLiveData(): MutableLiveData<String>{
        return errorLiveData
    }

    fun getData(){
        mTourViewModel.getData()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mTourViewModel.saveToDatabase(it.tours, it.countries)
                popularToursList.postValue(it.tours)
                countryList.postValue(it.countries)
            },{
                errorLiveData.postValue(it.localizedMessage)
            })
    }


}