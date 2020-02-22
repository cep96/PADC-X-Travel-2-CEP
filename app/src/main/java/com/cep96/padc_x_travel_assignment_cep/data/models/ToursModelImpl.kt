package com.cep96.padc_x_travelapp_assignment_cep.data.models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountriesAndToursListVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

object ToursModelImpl : BaseModel() {

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

    fun getData(): Observable<CountriesAndToursListVO>{
        return Observable.zip<List<CountryVO>, List<CountryVO>, CountriesAndToursListVO> (
            mToursApi.getAllCountries().map { it.data },
            mToursApi.getAllTours().map { it.data },
            BiFunction { countries, tours ->
                return@BiFunction CountriesAndToursListVO(countries, tours)
            }
        )
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