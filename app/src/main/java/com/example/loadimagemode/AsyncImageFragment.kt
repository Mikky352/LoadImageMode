package com.example.loadimagemode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.loadimagemode.databinding.FragmentAsyncImageBinding
import com.example.loadimagemode.databinding.FragmentSyncImageBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [asyncImageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AsyncImageFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fragmentAsyncImageBinding: FragmentAsyncImageBinding
     var viewModel:FragmentAsyncViewModel?=null

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
        // Inflate the layout for this fragment
        fragmentAsyncImageBinding = FragmentAsyncImageBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(FragmentAsyncViewModel::class.java)
        fragmentAsyncImageBinding.viewModel = viewModel
        // Inflate the layout for this fragment
        return fragmentAsyncImageBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment asyncImageFragment.
         */


        @JvmStatic
        fun newInstance(  ): AsyncImageFragment{

            var fragment :  AsyncImageFragment=  AsyncImageFragment()
            return fragment

        }
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AsyncImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}