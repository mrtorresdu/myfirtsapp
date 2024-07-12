package com.mrtorresdu.myfirstapplication.firstapp.menu.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.mrtorresdu.myfirstapplication.R
import com.mrtorresdu.myfirstapplication.firstapp.menu.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnRecalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble("IMC_RESULT") ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressedDispatcher.onBackPressed() }
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(result:Double) {
        tvIMC.text = result.toString()
        when (result) {
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_underweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                tvDescription.text = getString(R.string.description_underweight)
            }

            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal_weight))
                tvDescription.text = getString(R.string.description_normal_weight)
            }

            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_overweight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                tvDescription.text = getString(R.string.description_overweight)
            }

            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesity))
                tvDescription.text = getString(R.string.description_obesity)
            }

            else -> {
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)

            }
        }
    }
}