package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecyclerAdapter<T : AbstractModel>(@LayoutRes val layoutId: Int) :
    RecyclerView.Adapter<RecyclerAdapter.VH<T>>() {
    private val animatedPosition: HashSet<Int> by lazy { HashSet() }
    private var items = mutableListOf<T>()
    private var inflater: LayoutInflater? = null
    private var onItemClick: OnItemClick? = null

    private var onload: LoadChanged? = null
    private var isAnimation = true

    fun getAllItems(): List<T> = items
    private val uiScope = CoroutineScope(Dispatchers.Main)

    fun setAnimations(boolean: Boolean) {
        isAnimation = boolean
    }
    fun addItemsAtPosition(items: List<T>,position: Int) {
        //this.items.clear()
        this.items= items as MutableList<T>
        uiScope.launch {
            notifyItemChanged(position)
        }

    }

    fun addItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
    fun setImageListener(onload:LoadChanged){
        this.onload=onload
    }

    fun setOnItemClick(onItemClick: OnItemClick?) {
        this.onItemClick = onItemClick
    }

    fun appendItems(items: List<T>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return VH(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH<T>, position: Int) {
        val model = items[position]
        model.adapterPosition = position
        onItemClick?.let { model.onItemClick = it }
        onload?.let { model.onImageChange = it }

        holder.bind(model)
    }
    class VH<T : AbstractModel>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: T) {
            binding.setVariable(BR.model, model)
            binding.executePendingBindings()
        }
    }

    fun interface OnItemClick {
        fun onClick(view: View, data: Any, type: String)
    }

     public interface LoadChanged {
        fun Sucess(bool:Boolean,position: Int,drawable: Drawable)
    }
}