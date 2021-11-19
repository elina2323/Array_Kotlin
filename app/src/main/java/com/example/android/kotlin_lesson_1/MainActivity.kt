package com.example.android.kotlin_lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var text: String = "Джордж Ва́шингтон — <американский> государственный и <политический " +
            "деятель>, <первый> всенародно избранный <президент Соединённых Штатов Америки>"

    private var tvText: TextView? = null
    private var tvText2: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvText = findViewById(R.id.tvText)
        tvText2 = findViewById(R.id.tvText2)
        var subText: String = text.substringAfter('<')
        var subText2: String = subText.substringBefore('>')
        var subText3: String = subText.substringAfter('<')
        var subText4: String = subText3.substringBefore('>')
        var counter: Int = 0
        var startNumber : Array<Int> = arrayOf(2, 4, 6, 9)
        var number: Int = startNumber[0]


        for(n in text.indices){
            if (text.get(n) == '<') counter++
        }

        var startPosition = IntArray(counter)
        var endPosition = IntArray(counter)
        var startPcounter: Int = 0
        var endPcounter: Int = 0

        for(n in text.indices){
            if (text.get(n) == '<') {
                startPosition[startPcounter] = n
                startPcounter++
            }
            if (text.get(n) == '>') {
                endPosition[endPcounter] = n
                endPcounter++
            }
        }

        var textFoundArray = Array(counter){""}
        for (n in startPosition.indices){
            textFoundArray[n] = text.substring(startPosition[n] + 1, endPosition[n])
            Log.d("MyLog", "Text from n: ${textFoundArray[n]}")

        }

        tvText?.setText(subText2)
        tvText2?.setText(subText4)


    }
}

