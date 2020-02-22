package com.cep96.padc_x_travel_assignment_cep.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.views.viewholders.PopularToursViewHolder
import com.cep96.padc_x_travelapp_assignment_cep.data.models.ToursModelImpl
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO

class PopularToursListAdapter( private val onTapItem : () -> Unit): BaseRecyclerAdapter<PopularToursViewHolder, CountryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularToursViewHolder {
        return PopularToursViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_popular_tours, parent, false)
        ,onTapItem)
    }

}