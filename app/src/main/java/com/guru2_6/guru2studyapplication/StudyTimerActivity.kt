package com.guru2_6.guru2studyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_study_timer.*
import kotlin.concurrent.timer

class StudyTimerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_timer)

        val seekbar : SeekBar = findViewById(R.id.seekBar)
        val time : TextView = findViewById(R.id.time)
        var timeTick = 0
        var minute = 0
        var second = 0
        val initialTextViewTranslationY = time.translationY

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                timeTick = progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)

                val translationDistance = (initialTextViewTranslationY +
                        progress * resources.getDimension(R.dimen.text_anim_step) * -1)

                //time.animate().translationY(translationDistance)

                if(!fromUser){
                    time.animate().setDuration(500).rotationBy(360f)
                        .translationY(initialTextViewTranslationY)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                timeTick = seekBar!!.progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                timeTick = seekBar!!.progress
                time.text = String.format("%02d : %02d", timeTick/60, timeTick%60)
            }
        })
        start.setOnClickListener {
            minute = timeTick / 60
            second = timeTick % 60
            timer(period = 1000, initialDelay = 1000){
                runOnUiThread {
                    time.text = String.format("%02d : %02d", minute, second)
                }
                if(second == 0 && minute == 0){
                    println("타이머 종료")
                    cancel()
                }
                if(second == 0){
                    minute--
                    second = 60
                }
                second--
                stop.setOnClickListener { cancel() }
            }
        }

        reset.setOnClickListener { view ->
            seekbar.progress = 0

        }
    }
}