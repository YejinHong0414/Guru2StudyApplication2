package com.guru2_6.guru2studyapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("life_cycle","F onCreateView")
        // fragment가 인터페이스를 처음 그릴때 호출된다
        // inflater -> 뷰를 그려주는 역할
        // container -> 부모 뷰
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

}