package com.dicoding.belajarexplicitintent

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.dicoding.MoveActivity
import com.dicoding.MoveWithObjectActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1//di bawah ini code logika  moveActivity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)

        //1 //tambahkan beberapa baris yang berfungsi untuk menambahkan event onClick pada button
        btnMoveActivity.setOnClickListener(this)

        // 2 // dibawah ini code logika moveWithActivityData
        val btnMoveWithDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveWithDataActivity.setOnClickListener(this)


        //dibawah ini code logika activityMoveWithObject
        val btnMoveWithObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

    }

    //1
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_move_activity -> {
                val moveIntent = Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            //2
            R.id.btn_move_activity_data -> {
                val moveWithDataIntent = Intent(this@MainActivity,MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Dicoding academy boy")
                startActivity(moveWithDataIntent)

            }
            //3
            R.id.btn_move_activity_object -> {
                val person = Person (
                    "DicodingAcademy",
                    5,
                    "Academy@dicoding.com",
                    "Bandung"
                )

                val moveWithObjectIntent = Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)
                startActivity(moveWithObjectIntent)
            }
        }



    }
}