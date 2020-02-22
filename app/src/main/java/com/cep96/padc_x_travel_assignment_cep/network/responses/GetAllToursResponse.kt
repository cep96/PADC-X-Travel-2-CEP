package com.cep96.padc_x_travelapp_assignment_cep.network.responses

import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.google.gson.annotations.SerializedName

data class GetAllToursResponse (
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String = "",
    @SerializedName("data")val data: List<CountryVO> ?= null
)