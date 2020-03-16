package com.cep96.padc_x_travel_assignment_cep.persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cep96.padc_x_travel_assignment_cep.persistence.daos.CountryDao
import com.cep96.padc_x_travel_assignment_cep.persistence.daos.TourDao
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

@Database(entities = [CountryVO::class, ToursVO::class], version = 2,exportSchema = false)
abstract class TravelDB: RoomDatabase() {

    companion object{
        val DB_NAME = "PADC-X-TRAVEL.DB"
        var dbInstance: TravelDB ? = null

        fun getDBInstance(context: Context): TravelDB{
            when(dbInstance){
                null -> {
                    dbInstance = Room.databaseBuilder(context, TravelDB::class.java, DB_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            val i = dbInstance
            return i!!
        }
    }

    abstract fun countryDao(): CountryDao

    abstract fun tourDao(): TourDao
}