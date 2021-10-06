package com.example.loadimagemode

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var change =MutableLiveData<Int>()
    var isButtonColor: ObservableField<Boolean> = ObservableField(false)

    fun onClick(view: View) {




        when (view.id) {

            R.id.syncButton ->{
                change.value=1
                isButtonColor.set(false)
                //view.context.supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,SyncImageFragment.newInstance("","")).commit()
            }
            R.id.asyncButton ->{
                isButtonColor.set(true)
                change.value=2
            }
        }
    }



}