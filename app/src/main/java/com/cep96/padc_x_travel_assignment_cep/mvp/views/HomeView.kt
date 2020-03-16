package com.cep96.padc_x_travel_assignment_cep.mvp.views

import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

interface HomeView: BaseView {

    fun displayToursList(tours: List<ToursVO>)
    fun displayCountriesList(countries: List<CountryVO>)
    fun navigateToTourDetails(toursName: String)
    fun navigateToCountryDetails(countryName: String)
    fun enableSwipeRefresh()
    fun disableSwipeRefresh()
    fun displayToursEmpty()
    fun displayCountriesEmpty()
}