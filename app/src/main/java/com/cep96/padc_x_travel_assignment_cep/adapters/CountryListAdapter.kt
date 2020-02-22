package com.cep96.padc_x_travel_assignment_cep.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cep96.padc_x_travel_assignment_cep.R
import com.cep96.padc_x_travel_assignment_cep.views.viewholders.CountryViewHolder
import com.cep96.padc_x_travelapp_assignment_cep.data.vos.CountryVO

class CountryListAdapter(private val onTapItem: () -> Unit): BaseRecyclerAdapter<CountryViewHolder, CountryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_country, parent, false),
            onTapItem
        )
    }

}