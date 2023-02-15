package com.example.calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class History : AppCompatActivity(), View.OnClickListener {

    private lateinit var historyList: ArrayList<String>

    private lateinit var history1: TextView
    private lateinit var history2: TextView
    private lateinit var history3: TextView
    private lateinit var history4: TextView
    private lateinit var history5: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        history1 = findViewById(R.id.result1)
        history2 = findViewById(R.id.result2)
        history3 = findViewById(R.id.result3)
        history4 = findViewById(R.id.result4)
        history5 = findViewById(R.id.result5)

        historyList = intent?.getStringArrayListExtra("KEY_LIST")!!

        history1.text = historyList[0]
        history2.text = historyList[1]
        history3.text = historyList[2]
        history4.text = historyList[3]
        history5.text = historyList[4]

//        history5.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//                .putExtra("KEY_RESULT", history5.text.toString())
//            startActivity(intent)
//            setResult(RESULT_OK, intent)
//        }

        val textList = listOf(history1, history2, history3, history4)
        for(i in textList) {
            i.setOnClickListener(this)
        }


    }

    override fun onClick(v: View?) {
        val historyResult = v as TextView
        val intent = Intent(this, MainActivity::class.java)
            .putExtra("KEY_RESULT", historyResult.text.toString())
        startActivity(intent)
    }

}