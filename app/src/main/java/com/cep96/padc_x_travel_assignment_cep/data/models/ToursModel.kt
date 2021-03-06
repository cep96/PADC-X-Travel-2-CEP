package com.cep96.padc_x_travel_assignment_cep.data.models

import androidx.lifecycle.LiveData
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

interface ToursModel {

    fun getAllTours(onError: (String) -> Unit): LiveData<List<ToursVO>>

    fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>>

    fun getTourByName(name: String): LiveData<ToursVO>

    fun getCountryByName(name: String): LiveData<CountryVO>

}