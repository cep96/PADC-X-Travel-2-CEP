package com.cep96.padc_x_travelapp_assignment_cep.network

import com.cep96.padc_x_travel_assignment_cep.GET_COUNTRIES
import com.cep96.padc_x_travel_assignment_cep.GET_TOURS
import com.cep96.padc_x_travelapp_assignment_cep.network.responses.GetAllCountriesResponse
import com.cep96.padc_x_travelapp_assignment_cep.network.responses.GetAllToursResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ToursApi {

    @GET(GET_COUNTRIES)
    fun getAllCountries(): Observable<GetAllCountriesResponse>

    @GET(GET_TOURS)
    fun getAllTours(): Observable<GetAllToursResponse>
}