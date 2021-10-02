package com.example.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.authenticate.databinding.ActivityDashBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class DashActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = FirebaseAuth.getInstance().currentUser

        binding.username.text = user!!.displayName
        binding.phonenumber.text = user.uid
        binding.emailadd.text = user.email

        Glide.with(this).load(user.photoUrl).into(binding.imageView)

        binding.logoutButton.setOnClickListener {
            Firebase.auth.signOut()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}