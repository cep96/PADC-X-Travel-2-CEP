package com.cep96.padc_x_travel_assignment_cep.mvp.views

import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

interface PopularToursDetailView: BaseView {

    fun displayToursDetails(tour: ToursVO)
    fun displayCountryDetails(country: CountryVO)
    fun showEmptyView()
    fun hideEmptyView()
}