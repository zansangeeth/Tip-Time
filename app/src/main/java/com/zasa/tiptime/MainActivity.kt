package com.zasa.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.zasa.tiptime.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener{calculateTip()}

    }

    private fun calculateTip(){
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null || cost == 0.0){
            return displayTip(0.0)
        }

        val tipPercentage = when (binding.tipOption.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }

        var tip =tipPercentage * cost

//        val roundUp = binding.roundUpSwitch.isChecked
//        if (roundUp) {
//            // Take the ceiling of the current tip, which rounds up to the next integer, and store
//            // the new value in the tip variable.
//            tip = kotlin.math.ceil(tip)
//        }

        displayTip(tip)
        Log.d("sample", "tip : $tip")



    }


    private fun displayTip(tip: Double) {

        binding.tipResults.text = getString(R.string.tip_amount)

    }



}




