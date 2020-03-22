package com.cep96.padc_x_travel_assignment_cep.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

class ToursDetailViewModel: ViewModel() {

    private val mToursViewModel = ToursModelImpl

    fun getPopularToursByName(name: String): LiveData<ToursVO>{
        return mToursViewModel.getTourByName(name)
    }

    fun getCountryByName(name:String): LiveData<CountryVO>{
        return mToursViewModel.getCountryByName(name)
    }

}