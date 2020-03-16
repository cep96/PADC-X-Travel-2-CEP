package com.cep96.padc_x_travel_assignment_cep.data.models

import android.content.Context
import com.cep96.padc_x_travel_assignment_cep.BASE_URL
import com.cep96.padc_x_travel_assignment_cep.persistence.db.TravelDB
import com.cep96.padc_x_travel_assignment_cep.network.ToursApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected lateinit var mTheDB: TravelDB
    protected lateinit var mToursApi: ToursApi


    private fun initDatabase(context:Context){
        mTheDB = TravelDB.getDBInstance(context)
    }

    private fun initNetWork(context: Context){
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mToursApi = retrofit.create(ToursApi::class.java)
    }

    fun initModel(context: Context){
        initDatabase(context)
        initNetWork(context = context)
    }

}