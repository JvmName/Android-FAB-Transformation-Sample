package com.parthpadg.fabanimation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter : RecyclerView.Adapter<ColorAdapter.ColorVH>() {

    var colorList: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ColorVH(LayoutInflater.from(parent.context).inflate(R.layout.cell_color, parent, false))

    override fun getItemCount() = colorList.size

    override fun onBindViewHolder(holder: ColorVH, position: Int) = holder.bind(colorList[position])

    class ColorVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hexColor: String) = itemView.setBackgroundColor(hexColor.toColorInt())
    }
}