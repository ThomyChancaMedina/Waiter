package com.hariofspades.platter.feature.platter

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.hariofspades.platter.R
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private var mainFragment = MainFragment.newInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.plant(Timber.DebugTree())

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, mainFragment)
                    .commitNow()
        }

//        setupCart()
        clickListeners()
    }

//    private fun setupCart() {
//        cart_list.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, true)
////            adapter = listAdapter
//        }
//    }

    private fun clickListeners() {
        add_to_cart.setOnClickListener {


                motionContainer.transitionToEnd()

        }
    }


}
