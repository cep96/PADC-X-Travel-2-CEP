package com.cep96.padc_x_travel_assignment_cep.persistence.typeconverters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PhonesTypeConverter {

    @TypeConverter
    fun toString(phones: List<String>): String{
        return Gson().toJson(phones)
    }

    @TypeConverter
    fun toPhoneListString(phonesListString: String): List<String>{
        val phoneListType = object : TypeToken<List<String>>(){}.type
        return Gson().fromJson(phonesListString, phoneListType)
    }
}