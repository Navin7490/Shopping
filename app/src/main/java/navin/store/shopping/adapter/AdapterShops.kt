package navin.store.shopping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import navin.store.shopping.R
import navin.store.shopping.model.ModelShops

class AdapterShops(private val context: Context, val listShops:List<ModelShops>):
    RecyclerView.Adapter<ViewHolderShops>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderShops {

        val layoutInflater=LayoutInflater.from(context)
        val view=layoutInflater.inflate(R.layout.list_shops_item,parent,false)
        return ViewHolderShops(context,view)
    }

    override fun onBindViewHolder(holder: ViewHolderShops, position: Int) {
        val shops=listShops[position]
        holder.shopsDataBinding(shops)
    }

    override fun getItemCount(): Int {
        return listShops.size
    }
}
class ViewHolderShops(private val context: Context, itemView: View):
    RecyclerView.ViewHolder(itemView) {

    var tvShopId:TextView=itemView.findViewById(R.id.tvShopID)
    var tvShopName:TextView=itemView.findViewById(R.id.tvShopName)
    var tvShopType:TextView=itemView.findViewById(R.id.tvShopType)
    var tvShopAddress:TextView=itemView.findViewById(R.id.tvShopAddress)
    var imShop:ImageView=itemView.findViewById(R.id.imShop)

    fun shopsDataBinding(shops: ModelShops){

        tvShopId.text=shops.shopId
        tvShopName.text=shops.shopName
        tvShopType.text=shops.shopType
        tvShopAddress.text=shops.shopAddress

        Glide.with(context).load(shops.shopImage)
            .into(imShop)

    }

}