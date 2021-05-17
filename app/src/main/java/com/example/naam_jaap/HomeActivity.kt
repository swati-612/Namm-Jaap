package com.example.naam_jaap

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btn_jaap.setOnClickListener {
            var intent = Intent(this, JaapActivity::class.java)
            startActivity(intent)
        }
        btn_today_japkarta.setOnClickListener {
            var intent = Intent(this, AajKaJaapActivity::class.java)
            startActivity(intent)
        }
        btn_most_japkarta.setOnClickListener {
            var intent = Intent(this, AbTkJaapActivity::class.java)
            startActivity(intent)
        }
        btn_sandesh.setOnClickListener {
            var intent = Intent(this,SandeshActivity::class.java)
            startActivity(intent)
        }

    }

}