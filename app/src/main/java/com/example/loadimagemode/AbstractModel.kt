package com.example.loadimagemode

abstract class AbstractModel{
    var adapterPosition: Int = -1
    var onItemClick: RecyclerAdapter.OnItemClick? = null
    var onImageChange: RecyclerAdapter.LoadChanged? = null
}