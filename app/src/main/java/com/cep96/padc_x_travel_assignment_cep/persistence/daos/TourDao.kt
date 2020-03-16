package com.cep96.padc_x_travel_assignment_cep.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

@Dao
interface TourDao {

    @Query("SELECT * FROM tours")
    fun getAllTours(): LiveData<List<ToursVO>>

    @Query("DELETE FROM tours")
    fun deleteAll()

    @Query("SELECT * FROM tours WHERE name = :name")
    fun getTourByName(name: String): LiveData<ToursVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTours(tours: List<ToursVO>)
}