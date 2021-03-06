package com.cep96.padc_x_travel_assignment_cep.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO
import kotlinx.android.synthetic.main.item_popular_tours.view.*

class PopularToursViewHolder(itemView: View, private val onTapItem : (String) -> Unit) : BaseViewHolder<ToursVO>(itemView) {
    override fun bindData(data: ToursVO) {
        mData = data
        Glide.with(itemView).load(data.photos[0]).into(itemView.ivPopularTour)

//        itemView.tvCountryName.text = data.location
        itemView.tvAverageRating.text = data.averageRating.toString()

    }

    init {
        itemView.setOnClickListener {
            onTapItem
        }
    }

}