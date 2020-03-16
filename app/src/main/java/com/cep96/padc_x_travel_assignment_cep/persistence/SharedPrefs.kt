package com.cep96.padc_x_travel_assignment_cep.persistence

import android.content.Context
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import com.google.gson.Gson

object SharedPrefs {

    private val TRAVEL_SHARED_PREFS = "TRAVEL_SHARED_PREFS"
    private val SHARED_PREFS_TOURS = "SHARED_PREFS_TOURS"
    private val SHARED_PREFS_COUNTRY = "SHARED_PREFS_COUNTRY"

    private fun sharedPrefs(context: Context) =
        context.getSharedPreferences(TRAVEL_SHARED_PREFS,Context.MODE_PRIVATE)


    fun saveToursData(context: Context,tours: ToursVO){

        val toursString = Gson().toJson(tours)
        val editor = sharedPrefs(context).edit()
        editor.putString(SHARED_PREFS_TOURS, toursString)
            .apply()
    }

    fun getToursData(context: Context): ToursVO{
        val toursString = sharedPrefs(context).getString(SHARED_PREFS_TOURS,"tours")
        return Gson().fromJson(toursString, ToursVO::class.java)
    }

    fun saveCountryData(context: Context,country: CountryVO){

        val countryString = Gson().toJson(country)
        val editor = sharedPrefs(context).edit()
        editor.putString(SHARED_PREFS_COUNTRY, countryString)
            .apply()
    }

    fun getCountryData(context: Context): CountryVO{
        val countryString = sharedPrefs(context).getString(SHARED_PREFS_COUNTRY,"tours")
        return Gson().fromJson(countryString, CountryVO::class.java)
    }


}