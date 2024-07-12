package com.mrtorresdu.myfirstapplication.firstapp.menu.imccalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.mrtorresdu.myfirstapplication.R
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var tvWeight: TextView
    private lateinit var tvAge: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnAddWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnAddAge: FloatingActionButton
    private lateinit var btnCalculate: Button
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 60
    private var currentAge:Int = 18
    private var currentHeight: Int = 120

    companion object {
        const val IMC_KEY = "IM_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUi()

    }


    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        rsHeight = findViewById(R.id.rsHeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnAddAge = findViewById(R.id.btnAddAge)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight () }

        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge () }
        btnCalculate.setOnClickListener{
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun navigateToResult(result:Double){
        val intent = Intent( this, ResultIMCActivity::class.java)
        intent.putExtra("IMC_RESULT", result)
        startActivity(intent)
    }

    private fun calculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        return df.format(imc).toDouble()

    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUi() {
        setGenderColor()
        setWeight()
        setAge()
    }
}