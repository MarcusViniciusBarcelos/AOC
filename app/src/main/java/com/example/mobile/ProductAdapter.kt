package com.example.mobile

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProductAdapter(
    private val products: MutableList<Product>,
    private val goToDetail: (item: Product) -> Unit
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.itemView.setOnClickListener {
            goToDetail(product)
        }
        holder.itemView.setOnLongClickListener {
            showPopUpMenu(holder.itemView, position)
            true
        }
        holder.nameProduct.text = product.name
        holder.priceProduct.text = product.price.convertToMoneyWithSymbol()
        Glide.with(context)
            .load(product.urlImage)
            .into(holder.imageProduct)
    }

    override fun getItemCount(): Int = products.size

    inner class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageProduct: ImageView = view.findViewById(R.id.imageProduct)
        val nameProduct: TextView = view.findViewById(R.id.tvProductName)
        val priceProduct: TextView = view.findViewById(R.id.tvProductPrice)
    }

    private fun showPopUpMenu(view: View, position: Int) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_delete -> {
                        removeItem(products[position])
                        true
                    }
                    else -> false
                }
            }
            inflate(R.menu.menu_popup)
            show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeItem(product: Product) {
        products.remove(product)
        notifyDataSetChanged()
    }
}