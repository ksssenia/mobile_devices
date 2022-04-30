package com.example.task2tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task2tabs.databinding.FirstFragmentBinding

class Fragment1 : Fragment(R.layout.first_fragment) {

    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = Fragment1()
    }
}