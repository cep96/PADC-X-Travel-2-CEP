package com.cep96.padc_x_travel_assignment_cep.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var mData: T ?= null

    abstract fun bindData(data : T)
}