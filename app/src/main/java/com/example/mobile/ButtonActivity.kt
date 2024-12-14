package com.example.mobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobile.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {
    private lateinit var  binding : ActivityButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavigate.setOnClickListener{
            if(binding.editUsername.text.isEmpty()){
                binding.editUsername.error="username cannot be empty"
            }
            else if(binding.editPassword.text.isEmpty()){
                binding.editPassword.error="password cannot be empty"
            }else {

                val intent = Intent(this@ButtonActivity, DestinationActivity::class.java)
                val username: String = binding.editUsername.text.toString()
                val password: String = binding.editPassword.text.toString()

                //key        //value
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent)

                finish()
            }
        }

//        binding.btnNavigate.setOnClickListener{
//            val intent = Intent(this@ButtonActivity,RecyclerActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.editData)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}