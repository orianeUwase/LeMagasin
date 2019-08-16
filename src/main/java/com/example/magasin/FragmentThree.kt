package com.example.magasin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_one.*
import kotlinx.android.synthetic.main.fragment_three.*


class FragmentThree : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragThree.text="fragment three"
    }
}
