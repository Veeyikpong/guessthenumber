package com.veeyikpong.randomnumbergame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_playgame.*
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.alert
import java.util.*

class PlayGameActivity : AppCompatActivity() {

    var randomNumber = 0;
    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playgame)
        randomNumber()
    }

    fun randomNumber() {
        // Get the count from the intent extras
        val count = intent.getIntExtra(TOTAL_COUNT, 0)

        // Generate the random number
        val random = Random()
        // Add one because the bound is exclusive
        if (count > 0) {
            // Add one because the bound is exclusive
            randomNumber = random.nextInt(count + 1)
            textview_random_playgame.text = randomNumber.toString()
        }
        textview_label_playgame.text = getString(R.string.random_heading, count)

    }

    fun guessNumber(view : View){
        if(et_input.text.toString().equals(randomNumber.toString())){
            alert("Correct"){}.show()
        }else{
            alert("Wrong"){}.show()
        }
    }

    fun giveup(view : View){
        textview_random_playgame.visibility = View.VISIBLE
    }
}