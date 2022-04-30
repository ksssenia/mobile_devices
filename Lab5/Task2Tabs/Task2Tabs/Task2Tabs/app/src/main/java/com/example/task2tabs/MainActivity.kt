package com.example.task2tabs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.task2tabs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment: Fragment
            when (it.itemId) {
                R.id.first_item -> {
                    fragment = Fragment1.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.second_item -> {
                    fragment = Fragment2.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.third_item -> {
                    fragment = Fragment3.newInstance()
                    setCurrentFragment(fragment)
                }
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.first_item
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }
    }
}