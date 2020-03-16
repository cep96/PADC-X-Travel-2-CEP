package com.cep96.padc_x_travelapp_assignment_cep.data.vos

import com.google.gson.annotations.SerializedName

data class ScoresAndReviewsVO (
    @SerializedName("name") var name: String,
    @SerializedName("score") var score: Double,
    @SerializedName("max_score") var maxScore: Int,
    @SerializedName("total_reviews") var totalReview: Int
)