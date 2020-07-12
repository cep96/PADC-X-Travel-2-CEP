package com.cep96.padc_x_travel_assignment_cep.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountriesAndToursListVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

object ToursModelImpl : BaseModel(), ToursModel {
    override fun getAllTours(onError: (String) -> Unit): LiveData<List<ToursVO>> {
        return mTheDB.tourDao().getAllTours()
    }

    override fun getAllCountries(onError: (String) -> Unit): LiveData<List<CountryVO>> {
        return mTheDB.countryDao().getAllCountries()
    }

    override fun getTourByName(name: String): LiveData<ToursVO> {
        return mTheDB.tourDao().getTourByName(name)
    }

    override fun getCountryByName(name: String): LiveData<CountryVO> {
        return mTheDB.countryDao().getCountryByName(name)
    }

    var toursList: MutableLiveData<List<CountryVO>> = MutableLiveData()
    var countryList: MutableLiveData<List<CountryVO>> = MutableLiveData()

//    override fun getAllTours(onError: (String) -> Unit, onSuccess: (List<CountryVO>) -> Unit) {
//        mToursApi.getAllTours()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                onSuccess(it.data ?: arrayListOf())
//                toursList.postValue(it.data ?: arrayListOf())
//            }, {
//                onError(it.localizedMessage)
//            })
//    }

//    fun getAllData(): Observable<Pair<List<CountryVO>, List<CountryVO>>> {
//        return Observable.zip<List<CountryVO>, List<CountryVO>, Pair<List<CountryVO>, List<CountryVO>>>(
//            mToursApi.getAllCountries().map { it.data },
//            mToursApi.getAllTours().map { it.data },
//            BiFunction { countries, tours ->
//                return@BiFunction Pair(countries, tours)
//            }
//
//        )
//            .subscribeOn(Schedulers.io())
//
//    }

    override fun getData(): Observable<CountriesAndToursListVO> {
        return Observable.zip<List<CountryVO>, List<ToursVO>, CountriesAndToursListVO> (
            mToursApi.getAllCountries().map {
                it.data
            },
            mToursApi.getAllTours().map {
                it.data
            },
            BiFunction { countries, tours ->
                return@BiFunction CountriesAndToursListVO(countries, tours)
            }
        )
            .subscribeOn(Schedulers.io())

//            .doOnNext {
//                Log.i("List", "$it")
//                mTheDB.countryDao().insertAllCountries(it.countries)
//                mTheDB.tourDao().insertAllTours(it.tours)
//            }
    }

    fun saveToDatabase(tours: List<ToursVO>, countries: List<CountryVO>){
        mTheDB.countryDao().insertAllCountries(countries)
        mTheDB.tourDao().insertAllTours(tours)
    }

//    override fun getAllCountries(onError: (String) -> Unit, onSuccess: (List<CountryVO>) -> Unit) {
//        mToursApi.getAllCountries()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                onSuccess(it.data ?: arrayListOf())
//                countryList.postValue(it.data ?: arrayListOf())
//            }, {
//                onError(it.localizedMessage)
//            })
//    }


}