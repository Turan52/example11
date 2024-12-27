package com.example.myapplication0000

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    private var isFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentA())
            .commit()

        findViewById<View>(R.id.change_frag).setOnClickListener {
            if (isFragmentA) {
                replaceFragment(FragmentB())
            } else {
                replaceFragment(FragmentA())
            }
            isFragmentA = !isFragmentA
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    fun openSignUpPage(view: View) {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
