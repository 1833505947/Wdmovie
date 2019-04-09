package movie.bw.com.wdmovie.adapter

import android.content.Context
import android.support.v7.view.menu.MenuView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import movie.bw.com.wdmovie.R
import movie.bw.com.wdmovie.entity.ListBean

class ListAdapter (val ctx: Context, val list: List<ListBean.Result>): RecyclerView.Adapter<ListAdapter.VH>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): VH {
        val inflate = View.inflate(ctx, R.layout.list_layout, null)
        var vh = VH(inflate)
        return vh
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: VH, p1: Int) {
        p0.tv.text = list[p1].name
        Glide.with(ctx).load(list[p1].imageUrl)
    }
    class VH(itemView: View): RecyclerView.ViewHolder(itemView) {
        var iv:ImageView = itemView.findViewById(R.id.iv)
        var tv:TextView = itemView.findViewById(R.id.tv)
    }
}