package com.cep96.padc_x_travel_assignment_cep.persistence.typeconverters

import androidx.room.TypeConverter
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ScoresAndReviewsVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ScoresAndReviewsTypeConverter {

    @TypeConverter
    fun toString(scoresAndReviews: List<ScoresAndReviewsVO>): String{
        return Gson().toJson(scoresAndReviews)
    }

    @TypeConverter
    fun toScoresAndReviewsList(scoresAndReviewsString: String): List<ScoresAndReviewsVO>{
        val scoresAndReviewsListType = object : TypeToken<List<ScoresAndReviewsVO>>() {}.type
        return Gson().fromJson(scoresAndReviewsString, scoresAndReviewsListType)
    }

}