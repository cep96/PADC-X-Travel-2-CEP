package com.cep96.padc_x_travelapp_assignment_cep.data.models

import androidx.lifecycle.LiveData
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO

interface ToursModel {

    fun getAllTours(onError: (String) -> Unit, onSuccess: (List<CountryVO>) -> Unit)

    fun getAllCountries(onError: (String) -> Unit, onSuccess: (List<CountryVO>) -> Unit)

}