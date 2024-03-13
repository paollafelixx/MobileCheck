package com.example.cp1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class MainActivity : AppCompatActivity() {
    private var radioGroup: RadioGroup? = null
    private var editHeight: EditText? = null
    private var btnCalculate: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup = findViewById(R.id.radioGroup)
        editHeight = findViewById(R.id.editHeight)
        btnCalculate = findViewById(R.id.btnCalculate)
        btnCalculate!!.setOnClickListener { calculateWeight() }
    }

    private fun calculateWeight() {
        val selectedId = radioGroup!!.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this@MainActivity, "Selecione o sexo", Toast.LENGTH_SHORT).show()
            return
        }
        val radioButton: RadioButton = findViewById(selectedId)
        val heightStr = editHeight!!.text.toString()
        if (heightStr.isEmpty()) {
            Toast.makeText(this@MainActivity, "Digite a altura", Toast.LENGTH_SHORT).show()
            return
        }
        val height = heightStr.toDouble()
        val weight: Double
        weight = if (radioButton.id == R.id.radioMale) {
            72.7 * height - 58
        } else {
            62.1 * height - 44.7
        }
        val message = "Peso ideal: $weight kg"
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
    }
}
