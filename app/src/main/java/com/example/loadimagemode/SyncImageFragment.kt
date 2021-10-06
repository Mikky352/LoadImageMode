package com.example.loadimagemode

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.loadimagemode.databinding.FragmentSyncImageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SyncImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SyncImageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var fragmentSyncImageBinding: FragmentSyncImageBinding
    var viewModel:FragmentSyncViewModel?=null

    var param: MainViewVisiblity?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSyncImageBinding = FragmentSyncImageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(FragmentSyncViewModel::class.java)
        fragmentSyncImageBinding.viewModel = viewModel

        viewModel?.setMainVisiblity(param)

        activity?.let {
            viewModel?.change?.observe(it, Observer {

             if(it==1){
                 Log.e("MainVisblity","Visblity inside change "+it)
                 param?.sucess(true)
             }
            })
        }

        // Inflate the layout for this fragment
        return fragmentSyncImageBinding.root
    }
    /*var param=object:MainViewVisiblity{
        override fun sucess(bool: Boolean) {
            Log.e("MainVisblity","Visblity inside "+bool)
        }


    }*/

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SyncImageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
     fun newInstance(param: MainViewVisiblity): SyncImageFragment{

            var fragment :  SyncImageFragment=  SyncImageFragment()
            fragment.param=param
            return fragment

     }


        /*@JvmStatic
        fun newInstance(param1: String, param2: String) =
            SyncImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }*/
    }
}