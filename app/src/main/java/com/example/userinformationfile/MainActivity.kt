package com.example.userinformationfile

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("userInformation", MODE_PRIVATE)
    }

    fun save(view: View) {
        val email = emailEditText.text.toString()
        val firstName = firstNameEditText.text.toString()
        val lastName = lastNameEditText.text.toString()
        val age = ageEditText.text.toString().toInt()
        val address = homeAddressEditText.text.toString()

        if (email.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty()
            && age.toString().isNotEmpty() && address.isNotEmpty()
        ) {
            val openSharedPreference = sharedPreferences.edit()
            openSharedPreference.putString("email", email)
            openSharedPreference.putString("firstName", firstName)
            openSharedPreference.putString("lastName", lastName)
            openSharedPreference.putInt("age", age)
            openSharedPreference.putString("address", address)
            openSharedPreference.apply()
        } else {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
        }
    }

    fun check(view: View){
        val email = sharedPreferences.getString("email", "")
        val firstName = sharedPreferences.getString("firstName", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getInt("age", 0)
        val address = sharedPreferences.getString("address", "")

        emailEditText.setText(email)
        firstNameEditText.setText(firstName)
        lastNameEditText.setText(lastName)
        ageEditText.setText(age.toString())
        homeAddressEditText.setText(address)
    }
}