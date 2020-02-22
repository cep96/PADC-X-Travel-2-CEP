package com.cep96.padc_x_travel_assignment_cep.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cep96.padc_x_travel_assignment_cep.R

class PopularToursDetailActvity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_tours_detail_actvity)
    }

    companion object{
        fun getIntent(context: Context): Intent{
            return Intent(context, PopularToursDetailActvity::class.java)
        }
    }
}
