package com.example.calculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isNewOperator = true
    private var isEqual = false
    private var string: String = ""
    private var number = 0
    private var firstNumber = ""
    private var operator = ""
    private lateinit var binding: ActivityMainBinding
    private var  historyList = arrayListOf<String>()
    private lateinit var history: String

    // region view declaration
    private lateinit var expression: TextView
    private lateinit var resultText: TextView
    private lateinit var clear: Button
    private lateinit var divide: Button
    private lateinit var multiply: Button
    private lateinit var add: Button
    private lateinit var subtract: Button
    private lateinit var equal: Button
    private lateinit var dot: Button
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // region find view
        expression = findViewById(R.id.expression)
        resultText = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.plus)
        subtract = findViewById(R.id.subtract)
        equal = findViewById(R.id.equal)
        dot = findViewById(R.id.dot)
        zero = findViewById(R.id.zero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        // endregion

        binding.result.setOnClickListener {
            val result = Intent(this, History::class.java)
                .putStringArrayListExtra("KEY_LIST", historyList)
            startActivity(result)
        }

        expression.text = intent?.getStringExtra("KEY_RESULT")
    }

    fun numberEvent(view: View) {

        if(isEqual) {
            expression.text = ""
            isEqual = false
        }
        if(isNewOperator)
            expression.text = ""
        isNewOperator = false
        val buttonSelect = view as Button
        var buttonClick = expression.text.toString()

        when(buttonSelect.id) {
            zero.id -> {
                if(buttonClick.startsWith("0") && buttonClick.indexOf('.') == -1) buttonClick.replace("0", "")
                 else buttonClick += "0"
            }
            one.id -> {buttonClick += "1"}
            two.id -> {buttonClick += "2"}
            three.id -> {buttonClick += "3"}
            four.id -> {buttonClick += "4"}
            five.id -> {buttonClick += "5"}
            six.id -> {buttonClick += "6"}
            seven.id -> {buttonClick += "7"}
            eight.id -> {buttonClick += "8"}
            nine.id -> {buttonClick += "9"}
            dot.id -> {buttonClick += "."}
        }
        expression.text = buttonClick
        string += buttonClick
    }

    fun operatorEvent(view: View) {
        val buttonSelect = view as Button
        isNewOperator = true
        firstNumber = expression.text.toString()
        when(buttonSelect.id) {
            add.id -> {operator = "+"}
            subtract.id -> {operator = "-"}
            multiply.id -> {operator = "*"}
            divide.id -> {operator = "/"}
        }
        string += operator
    }


    fun equalEvent(view: View) {
        val secondNumber = expression.text.toString()
        var result = 0.0
        when(operator) {
            "+" -> {result = firstNumber.toDouble() + secondNumber.toDouble()}
            "-" -> {result = firstNumber.toDouble() - secondNumber.toDouble()}
            "*" -> {result = firstNumber.toDouble() * secondNumber.toDouble()}
            "/" -> {result = firstNumber.toDouble() / secondNumber.toDouble()}
        }
        expression.text = result.toString()

        historyList.add(string)

        isEqual = true
    }

    fun clearEvent(view: View) {
        expression.text = "0"
        isNewOperator = true
        resultText.text = ""
        string = ""
    }

}