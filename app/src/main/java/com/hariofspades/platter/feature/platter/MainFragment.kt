package com.hariofspades.platter.feature.platter

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.hariofspades.platter.R
import com.hariofspades.platter.data.FactoryOutlet
import com.thomy.library.ui.CountDownTime
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.platter_view.view.*


/**
 * A simple [Fragment] subclass.
 *
 */
class MainFragment : Fragment() {

    lateinit var rootView: View

    private lateinit var countDownTimerView: CountDownTime

    private val list = FactoryOutlet.makeRecipeList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false)
        setupPager()
        setupOrderFragment()
        return rootView
    }

    private fun setupOrderFragment() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        countDownTimerView = view.findViewById(R.id.plates)


        countDownTimerView.startTimer(
                timerCount = 30,
                onCountDownTimeStarted = {
                    Log.d("Timer: ", "Started")
                },
                onCountDownTimeRunning = {
                    Log.d("Timer: ", "Running $it")
                },
                onCountDownTimeStopped = {
                    Log.d("Timer: ", "Stopped")
                })

    }

    private fun setupPager() {
        rootView.apply {
            pager.adapter = RecipeAdapter(activity!!)
//            setImage(list[0].url)

            if (motionLayout != null) {
                pager.addOnPageChangeListener(motionLayout as ViewPager.OnPageChangeListener)
                pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                    override fun onPageScrollStateChanged(p0: Int) {

                    }

                    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

                    }

                    override fun onPageSelected(p0: Int) {

                        countDownTimerView.resetTimer()

                        Log.d("TAG", "onPageScrolled: thomy:: nesxt")
//                        setImage(Cart.currentDish)
                    }

                })
            }
        }
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}
