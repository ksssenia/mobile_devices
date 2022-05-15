package com.example.circleslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.circleslist.databinding.ActivityMainBinding
import com.github.javafaker.Faker
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private val list: MutableList<CircleList> = mutableListOf()
    private val faker: Faker = Faker()
    private lateinit var adapter: CircleAdapter
    data class CircleList(val number: Int, val color: String)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CircleAdapter(layoutInflater) {
            val dialog = DialogCircle.newInstance(it.number)
            dialog.show(supportFragmentManager, "window")
        }

        binding.list.adapter = adapter
        binding.list.layoutManager = GridLayoutManager(this, 4)
        adapter.submitList(null)

        for(i in 1..28){
            val value = Random.nextInt(1, 99)
            val color = faker.color().hex()
            list.add(CircleList(value, color))
        }
        adapter.submitList(list.toList())

    }
    override fun onStart() {
        super.onStart()
        adapter.submitList(list.toList())
    }

    }