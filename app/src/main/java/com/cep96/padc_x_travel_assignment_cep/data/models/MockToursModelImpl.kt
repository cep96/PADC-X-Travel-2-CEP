package com.cep96.padc_x_travel_assignment_cep.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cep96.padc_x_travel_assignment_cep.dummy.getDummyCountries
import com.cep96.padc_x_travel_assignment_cep.dummy.getDummyTours
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountriesAndToursListVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object MockToursModelImpl: ToursModel {

//    var tours: MutableList<ToursVO> = arrayListOf()
//    var countries: MutableList<CountryVO> = arrayListOf()
//    var toursLiveData = MutableLiveData<List<ToursVO>>()
//    var countriesLiveData = MutableLiveData<List<CountryVO>>()

    override fun getAllTours(onError: (String) -> Unit): LiveData<List<ToursVO>> {
        val liveData = MutableLiveData<List<ToursVO>>()
        liveData.postValue(getDummyTours())
        return liveData
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        val liveData = MutableLiveData<List<CountryVO>>()
        liveData.postValue(getDummyCountries())
        return liveData
    }

    override fun getTourByName(name: String): LiveData<ToursVO> {
        val liveData = MutableLiveData<ToursVO>()
        liveData.postValue(getDummyTours().first{
            it.name == name
        })
        return liveData
    }

    override fun getCountryByName(name: String): LiveData<CountryVO> {
        val liveData = MutableLiveData<CountryVO>()
        liveData.postValue(getDummyCountries().first{
            it.name == name
        })
        return liveData
    }

    override fun getData(): Observable<CountriesAndToursListVO> {
//        val liveData = MutableLiveData<CountriesAndToursListVO>()
//        liveData.postValue(getDummyToursAndCountries())
//        return liveData

        return Observable.zip<List<CountryVO>, List<ToursVO>, CountriesAndToursListVO> (
            ToursModelImpl.mToursApi.getAllCountries().map {
                it.data
            },
            ToursModelImpl.mToursApi.getAllTours().map {
                it.data
            },
            BiFunction { countries, tours ->
                return@BiFunction CountriesAndToursListVO(countries, tours)
            }
        )
            .subscribeOn(Schedulers.io())

    }


}