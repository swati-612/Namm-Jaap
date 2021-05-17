package com.example.naam_jaap

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity()  {
      lateinit var auth: FirebaseAuth
      var databaseReference :DatabaseReference? = null
      var database : FirebaseDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database?.reference!!.child("Main")

         register()

    }
    private fun register(){

        registerButton.setOnClickListener {
            if (TextUtils.isEmpty(fullNameInput.text.toString())){
              fullNameInput.setError("please enter full name")
                return@setOnClickListener
            }else if(TextUtils.isEmpty((emailInput.text.toString()))){
                emailInput.setError("please enter email id")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(passwordInput.text.toString())){
                passwordInput.setError("please enter password")
                return@setOnClickListener
            }




        auth.createUserWithEmailAndPassword(emailInput.text.toString(), passwordInput.text.toString())
            .addOnCompleteListener {
              if (it.isSuccessful){
                   val currentUser = auth.currentUser
                   val currentUSerDb = databaseReference?.child(currentUser.uid)            //missing ? ,!!
                  currentUSerDb?.child("fullname")?.setValue(fullNameInput.text.toString())

                  Toast.makeText(this@RegistrationActivity, "Registration Success", Toast.LENGTH_SHORT).show()
                  finish()
              }else{

                  Toast.makeText(this@RegistrationActivity, "Registration failed, please try again! ", Toast.LENGTH_SHORT).show()
              }
            }
        }
    }
}
