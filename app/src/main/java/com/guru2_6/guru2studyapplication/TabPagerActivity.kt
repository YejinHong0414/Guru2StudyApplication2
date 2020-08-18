package com.guru2_6.guru2studyapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ateots.guruproject.GraphFragment
import com.example.myapplication.StopWatchFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

// 어플리케이션의 메인액티비티
class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)

        tab_layout.addTab(tab_layout.newTab().setText("메모장")) // 탭의 첫번째 화면 : 메모장 (달력)
        tab_layout.addTab(tab_layout.newTab().setText("할 일"))
        tab_layout.addTab(tab_layout.newTab().setText("통계"))
        tab_layout.addTab(tab_layout.newTab().setText("스탑워치"))
        tab_layout.addTab(tab_layout.newTab().setText("타이머"))

        val pagerAdapter = FragmentPagerAdapter(supportFragmentManager, 5)
        view_pager.adapter = pagerAdapter

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.currentItem = tab!!.position
                // null 을 할당할 수 없으므로 !!
            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // -> 페이저가 이동했을때 탭을 이동시키는 코드
    }
}

class FragmentPagerAdapter(
    fragmentManager: FragmentManager,
    val tabCount: Int
): FragmentStatePagerAdapter(fragmentManager){
    override fun getItem(position: Int): Fragment {
        // 여기에 각자 기능 Fragment들을 넣으시면 됩니다!:)
        when(position){
            0 -> {
                return MemoFragment()
            }
            1 -> {
                return TodoListFragment()
            }
            2 -> {
                return GraphFragment()
            }
            3 -> {
                return StopWatchFragment()
            }
            4 -> {
                return TimerFragment()
            }
            else -> return MemoFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }
}
