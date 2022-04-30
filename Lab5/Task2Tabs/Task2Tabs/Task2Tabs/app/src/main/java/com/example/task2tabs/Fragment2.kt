package com.example.task2tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task2tabs.databinding.SecondFragmentBinding

class Fragment2 : Fragment(R.layout.second_fragment) {

    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = SecondFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = Fragment2()
    }
}