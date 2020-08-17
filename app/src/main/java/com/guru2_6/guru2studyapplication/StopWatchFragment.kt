//package com.guru2_6.guru2studyapplication

package com.example.myapplication // <- 이 부분은 수정해주세요!

import androidx.fragment.app.Fragment
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.guru2_6.guru2studyapplication.R
//import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_study__stop_watch_.*
import kotlinx.android.synthetic.main.activity_study__stop_watch_.btn_laptime
import kotlinx.android.synthetic.main.activity_study__stop_watch_.btn_reset
import kotlinx.android.synthetic.main.activity_study__stop_watch_.btn_start
import kotlinx.android.synthetic.main.activity_study__stop_watch_.btn_stop
import kotlinx.android.synthetic.main.activity_study__stop_watch_.hourView
import kotlinx.android.synthetic.main.activity_study__stop_watch_.laptimeView
import kotlinx.android.synthetic.main.activity_study__stop_watch_.minuteView
import kotlinx.android.synthetic.main.activity_study__stop_watch_.secondView
//import kotlinx.android.synthetic.main.fragment_one.*
import java.util.*
import kotlin.concurrent.timer

class StopWatchFragment : Fragment() {

    var time = 0
    var timerTask: Timer? = null // null을 허용
    var isRunning = false
    var index: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle", "F onCreateView")
// fragment가 인터페이스를 처음 그릴때 호출된다
// inflater -> 뷰를 그려주는 역할
// container -> 부모 뷰
        super.onCreate(savedInstanceState)

        return inflater.inflate(R.layout.activity_study__stop_watch_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

// 시작
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

// 일시정지
        btn_stop.setOnClickListener {
            timerTask?.cancel()
        }

// 초기화
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

// 기록
        btn_laptime.setOnClickListener {
            val lapTime = time // 함수 호출 시 시간(time) 저장

// apply() 스코프 함수로, TextView를 생성과 동시에 초기화
            val textView = TextView(this).apply {
                setTextSize(20f) // fontSize 20 설정
                var text = "${lapTime / 3600}.${lapTime / 60}.${lapTime % 60}" // 출력할 시간 설정
            }

            laptimeView.addView(textView, 0) // layout에 추가, (View, index) 추가할 위치(0 최상단 의미)
            index++ // 추가된 View의 개수를 저장하는 index 변수
        }
    }

    private fun setTextSize(fl: Float) {
        TODO("Not yet implemented")
    }

    private fun runOnUiThread(function: () -> Unit) {

    }

    private fun TextView(stopWatchFragment: StopWatchFragment) {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("life_cycle", "F onActivityCreated")

        val data = arguments?.getString("hello")
// Log.d("data",data)

        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("life_cycle", "F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("life_cycle", "F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("life_cycle", "F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("life_cycle", "F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("life_cycle", "F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("life_cycle", "F onDetach")
        super.onDetach()
    }

}

private fun LinearLayout.addView(textView: Unit, i: Int) {

}