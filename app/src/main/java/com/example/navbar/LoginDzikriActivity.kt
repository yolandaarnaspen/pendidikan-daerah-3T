package com.example.navbar

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.navbar.databinding.ActivityDzikriMainBinding
import com.example.navbar.databinding.ActivityLoginDzikriBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class LoginDzikriActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginDzikriBinding
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginDzikriBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("users")

        binding.buttonLogin.setOnClickListener {
            val loginusername = binding.loginusername.text.toString()
            val loginpassword = binding.loginpassword.text.toString()

            if (loginusername.isNotEmpty() && loginpassword.isNotEmpty()){
                loginUser(loginusername, loginpassword)
            } else {
                Toast.makeText(this@LoginDzikriActivity, "Silahkan untuk mengisi daftar akun terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSignUp.setOnClickListener {
            startActivity(Intent(this@LoginDzikriActivity, RegisterActivity::class.java))
            finish()
        }

    }

    private fun loginUser (username: String, password: String){
        databaseReference.orderByChild("username").equalTo(username).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    for (userSnapshot in dataSnapshot.children){
                        val userData = userSnapshot.getValue(UserData::class.java)

                        if (userData != null && userData.password == password){
                            Toast.makeText(this@LoginDzikriActivity, "Login Succesfull", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@LoginDzikriActivity, DzikriMainActivity::class.java))
                            finish()
                            return
                        }
                    }
                }
                Toast.makeText(this@LoginDzikriActivity, "Login Failled", Toast.LENGTH_SHORT).show()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(this@LoginDzikriActivity, "Database Error: ${databaseError.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}