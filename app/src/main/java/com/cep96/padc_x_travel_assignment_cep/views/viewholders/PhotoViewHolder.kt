package com.cep96.padc_x_travel_assignment_cep.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photo.view.*

class PhotoViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
    override fun bindData(data: String) {
        Glide.with(itemView.context)
            .load(data)
            .into(itemView.ivPhoto)
    }
}