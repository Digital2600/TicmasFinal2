package com.curso.android.app.practica.ticmasfinal2.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.ticmasfinal2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.compareButton.setOnClickListener {
            val input1 = binding.editText1.text.toString()
            val input2 = binding.editText2.text.toString()
            viewModel.compareStrings(input1, input2)
        }

        viewModel.comparisonResult.observe(this) {
            val resultText =
                if (it.isEqual) "Son iguales" else "No son iguales"
            binding.resultTextView.text = resultText
        }
    }
}