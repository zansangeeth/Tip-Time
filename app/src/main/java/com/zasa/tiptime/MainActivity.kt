package com.zasa.tiptime
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate_button.setOnClickListener {
            calculateTip()
        }
    }


    private fun calculateTip() {
        var costAmount = cost_of_service_edit_text.text.toString()
        var doubleCost = costAmount.toIntOrNull()

        var tipOption = when(tip_option.checkedRadioButtonId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var calculate = doubleCost!! *tipOption
        tip_results.setText("$ " + calculate.toString())

    }


}






