package com.dicoding

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.belajarexplicitintent.Person

import com.dicoding.belajarexplicitintent.R

class MoveWithObjectActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        val person = if (Build.VERSION.SDK_INT >=33) {
            intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Person>(EXTRA_PERSON)
        }

        if (person != null) {
            val text = "Name :${person.name.toString()},\nEmail: ${person.email},\nAge: ${person.age},\nLocation : ${person.city}"
            tvObject.text = text
        }



    }
}