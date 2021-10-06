package com.example.loadimagemode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.loadimagemode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var syncButton :Button?=null
    var asyncButton :Button?=null
    lateinit var  binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel =ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel =viewModel

        Log.e("MainVisblity","Visblity oustside "+binding.linear)
        supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,SyncImageFragment.newInstance(object :MainViewVisiblity{
            override fun sucess(bool: Boolean) {
                Log.e("MainVisblity","Visblity inside "+bool)
                if(bool){
                    binding.linear.visibility=View.VISIBLE
                }else{
                    binding.linear.visibility=View.INVISIBLE
                }
            }
        })).commit()

        viewModel.change.observe(this, Observer {


            if(it==1){
                supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,SyncImageFragment.newInstance(object :MainViewVisiblity{
                    override fun sucess(bool: Boolean) {
                        if(bool){
                            binding.linear.visibility=View.VISIBLE
                        }else{
                            binding.linear.visibility=View.INVISIBLE
                        }
                    }
                })).commit()

            }else if(it==2){

                supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,AsyncImageFragment.newInstance(
                    object :MainViewVisiblity{
                        override fun sucess(bool: Boolean) {
                            if(bool){
                                binding.linear.visibility=View.VISIBLE
                            }else{
                                binding.linear.visibility=View.INVISIBLE
                            }                        }
                    })).commit()
            }
        })

       /* syncButton = findViewById(R.id.syncButton)
        asyncButton = findViewById(R.id.asyncButton)*/

       /* syncButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,SyncImageFragment.newInstance("","")).commit()
                asyncButton?.backgroundTintList=resources.getColorStateList(R.color.teal_700)
                syncButton?.backgroundTintList=resources.getColorStateList(R.color.purple_500)

            }

        })

        asyncButton?.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View?) {
                supportFragmentManager.beginTransaction().replace(R.id.frameConatiner,AsyncImageFragment.newInstance("","")).commit()
                syncButton?.backgroundTintList=resources.getColorStateList(R.color.teal_700)
                asyncButton?.backgroundTintList=resources.getColorStateList(R.color.purple_500)
            }

        })*/

    }
}