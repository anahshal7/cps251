package com.example.navigation_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        val button1 = view.findViewById<Button>(R.id.image1Button)
        val button2 = view.findViewById<Button>(R.id.image2Button)
        val button3 = view.findViewById<Button>(R.id.image3Button)
        button1.setOnClickListener{
            val fragment2 = SecondFragment()
            val bundle = Bundle()
            bundle.putInt("imageResource", R.drawable.image1)
            bundle.putString("textResource", "Image 1")
            fragment2.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment2)
                .addToBackStack(null)
                .commit()
        }
        button2.setOnClickListener{
            val fragment2 = SecondFragment()
            val bundle = Bundle()
            bundle.putInt("imageResource", R.drawable.image2)
            bundle.putString("textResource", "Image 2")
            fragment2.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment2)
                .addToBackStack(null)
                .commit()
        }
        button3.setOnClickListener{
            val fragment2 = SecondFragment()
            val bundle = Bundle()
            bundle.putInt("imageResource", R.drawable.image3)
            bundle.putString("textResource", "Image 3")
            fragment2.arguments = bundle
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment2)
                .addToBackStack(null)
                .commit()
        }
        return view
    }


}