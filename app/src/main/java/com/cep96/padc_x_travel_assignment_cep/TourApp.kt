package com.cep96.padc_x_travel_assignment_cep

import android.app.Application
import com.cep96.padc_x_travel_assignment_cep.data.models.BaseModel
import com.cep96.padc_x_travel_assignment_cep.data.models.ToursModelImpl

class TourApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ToursModelImpl.initModel(applicationContext)
    }
}