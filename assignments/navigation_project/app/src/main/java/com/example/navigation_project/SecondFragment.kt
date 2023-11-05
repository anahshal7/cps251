package com.example.navigation_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val imageResource = arguments?.getInt("imageResource")
        val textView = view.findViewById<TextView>(R.id.textView)
        val textResource = arguments?.getString("textResource")
        if (imageResource != null) {
            imageView.setImageResource(imageResource)
        }
        textView.text = textResource
        return view
    }
}