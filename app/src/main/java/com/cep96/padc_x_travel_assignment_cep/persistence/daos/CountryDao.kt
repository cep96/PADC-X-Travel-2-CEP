package com.cep96.padc_x_travel_assignment_cep.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    fun getAllCountries(): LiveData<List<CountryVO>>

    @Query("DELETE FROM country")
    fun deleteAll()

    @Query("SELECT * FROM country WHERE name = :name ")
    fun getCountryByName(name: String): LiveData<CountryVO>

    @Query("SELECT * FROM country WHERE name = :name ")
    fun getTourByName(name: String): LiveData<ToursVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCountries(countries: List<CountryVO>)
}