package com.example.naam_jaap


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*


class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerText.setOnClickListener {                                                     //registration btn click event
            startActivity(Intent(this@MainActivity, RegistrationActivity::class.java))
        }


        auth = FirebaseAuth.getInstance()

        val currentuser = auth.currentUser
        if (currentuser != null) {
            startActivity(Intent(this@MainActivity, HomeActivity::class.java))
            finish()
        }

         btn_login.setOnClickListener {
           var intent = Intent(this, HomeActivity::class.java)
          startActivity(intent)
        }
    //   login()

    }

  /*  private fun login(){

      btn_login.setOnClickListener {
        if (TextUtils.isEmpty(emailInput.text.toString())){
           emailInput.setError("please enter email id")
            return@setOnClickListener
        }else if (TextUtils.isEmpty(passwordInput.text.toString())){
            passwordInput.setError("please enter password")
            return@setOnClickListener
        }


          auth.signInWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
              .addOnCompleteListener {
               if (it.isSuccessful){
                   startActivity(Intent(this@MainActivity, HomeActivity::class.java))
                   finish()
               }else{
                   Toast.makeText(this@MainActivity, "Login failed, please try again! ", Toast.LENGTH_LONG).show()
               }
              }

      }

        registerText.setOnClickListener {
            startActivity(Intent(this@MainActivity, RegistrationActivity::class.java))
        }
    }*/


}