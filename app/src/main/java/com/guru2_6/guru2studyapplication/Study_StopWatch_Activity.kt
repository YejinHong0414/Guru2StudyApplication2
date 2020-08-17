package com.guru2_6.guru2studyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main4.*
import java.util.*
import kotlin.concurrent.timer

class MainActivity2 : AppCompatActivity() {

    private var time = 0
    private var timerTask: Timer? = null      // null을 허용
    private var isRunning = false
    private var index :Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        btn_start.setOnClickListener {
            isRunning = !isRunning

            timerTask = timer(period = 1000) {
                time++

                val hou = time / 3600
                val min = time / 60
                val sec = time % 60

                runOnUiThread { //UI 조작
                    hourView.text = "$hou"
                    minuteView.text = "$min"
                    secondView.text = "$sec"
                }
            }
        }

        btn_stop.setOnClickListener {
            timerTask?.cancel()
        }

        btn_reset.setOnClickListener {
            timerTask?.cancel()

            // 모든 변수 초기화
            time = 0
            isRunning = false
            hourView.text = "00"
            minuteView.text = "00"
            secondView.text = "00"

            index = 1
        }

        btn_laptime.setOnClickListener {
            val lapTime = time		// 함수 호출 시 시간(time) 저장

            // apply() 스코프 함수로, TextView를 생성과 동시에 초기화
            val textView = TextView(this).apply {
                setTextSize(20f)	// fontSize 20 설정
                text = "${lapTime / 3600}.${lapTime / 60}.${lapTime % 60}"	// 출력할 시간 설정
            }

            laptimeView.addView(textView,0)	// layout에 추가, (View, index) 추가할 위치(0 최상단 의미)
            index++	// 추가된 View의 개수를 저장하는 index 변수
        }
        }
    }

private operator fun TextView.invoke(textView: TextView, i: Int) {

}
