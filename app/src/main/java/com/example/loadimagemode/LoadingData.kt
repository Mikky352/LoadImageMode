package com.example.loadimagemode

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable
import com.bumptech.glide.load.resource.gif.GifDrawable


data class LoadingData (
var url1:String?="",
var url2:String?="",
var show:Boolean?=true,
var drawable: Drawable?=null
 ):AbstractModel()/*,Parcelable*//*: Parcelable{
    constructor(parcel: Parcel) : this(

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url1)
        parcel.writeString(url2)
        parcel.writeString(url3)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LoadingData> {
        override fun createFromParcel(parcel: Parcel): LoadingData {
            return LoadingData(parcel)
        }

        override fun newArray(size: Int): Array<LoadingData?> {
            return arrayOfNulls(size)
        }
//    }*/
//{constructor(parcel: Parcel) : this(
//
//) {
//}
//
// override fun writeToParcel(parcel: Parcel, flags: Int) {
//  parcel.writeString(url1)
//  /*parcel.writeString(url2)
//  parcel.writeString(url3)*/
// }
//
// override fun describeContents(): Int {
//  return 0
// }
//
// companion object CREATOR : Parcelable.Creator<LoadingData> {
//  override fun createFromParcel(parcel: Parcel): LoadingData {
//   return LoadingData(parcel)
//  }
//
//  override fun newArray(size: Int): Array<LoadingData?> {
//   return arrayOfNulls(size)
//  }
// }
//}



