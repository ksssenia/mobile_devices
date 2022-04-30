package com.example.task2tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task2tabs.databinding.ThirdFragmentBinding

class Fragment3 : Fragment(R.layout.third_fragment) {

    private lateinit var binding: ThirdFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ThirdFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun newInstance() = Fragment3()
    }
}