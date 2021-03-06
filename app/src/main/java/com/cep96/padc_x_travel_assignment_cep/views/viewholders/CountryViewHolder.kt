package com.cep96.padc_x_travel_assignment_cep.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cep96.padc_x_travel_assignment_cep.persistence.SharedPrefs
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import kotlinx.android.synthetic.main.item_country.view.*

class CountryViewHolder(itemView: View, private val onTapItem: (String) -> Unit) : BaseViewHolder<CountryVO>(itemView) {
    override fun bindData(data: CountryVO) {
        mData = data

        Glide.with(itemView).load(data.photos[0]).into(itemView.ivCountry)

//        itemView.tvCountryName.text = data.location
        itemView.tvAverageRating.text = data.averageRating.toString()
    }

    init {
        itemView.setOnClickListener {
            mData?.let {
                onTapItem(it.name)
            }

        }
    }

}