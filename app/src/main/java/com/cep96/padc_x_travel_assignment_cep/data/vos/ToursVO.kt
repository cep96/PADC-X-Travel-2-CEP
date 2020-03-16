package com.cep96.padc_x_travelapp_assignment_cep.data.vos

import androidx.room.*
import com.cep96.padc_x_travel_assignment_cep.persistence.typeconverters.PhonesTypeConverter
import com.cep96.padc_x_travel_assignment_cep.persistence.typeconverters.ScoresAndReviewsTypeConverter
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tours")
@TypeConverters(ScoresAndReviewsTypeConverter::class, PhonesTypeConverter::class)
data class ToursVO (
    @PrimaryKey
    @SerializedName("name") var name: String = "",
    @SerializedName("description") var description: String = "",
    @SerializedName("location")var location: String = "",
    @SerializedName("average_rating") var averageRating: Double = 0.0,
    @SerializedName("scores_and_reviews")var scoresAndReviews: List<ScoresAndReviewsVO> = arrayListOf(),
    @SerializedName("photos")var photos: List<String> = arrayListOf()
){

}