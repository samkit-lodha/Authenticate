package com.example.authenticate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val user = FirebaseAuth.getInstance().currentUser
        Handler().postDelayed({
            if(user!=null){
                startActivity(Intent(this,DashActivity::class.java))
                finish()
            }
            else{
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            }
        },2500)
    }
}