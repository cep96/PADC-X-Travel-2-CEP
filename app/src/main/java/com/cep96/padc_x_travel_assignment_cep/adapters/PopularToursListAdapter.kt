package com.cep96.padc_x_travel_assignment_cep.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.views.viewholders.PopularToursViewHolder
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.ToursVO

class PopularToursListAdapter( private val onTapItem : (String) -> Unit): BaseRecyclerAdapter<PopularToursViewHolder, ToursVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularToursViewHolder {
        return PopularToursViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_tours, parent, false)
        ,onTapItem)
    }

}