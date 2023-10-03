package com.example.workingwitharrays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

data class Account(val username: String, val password: String)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declaration of buttons
        var buttonAdd = findViewById<Button>(R.id.btnAdd)
        var buttonUpdate = findViewById<Button>(R.id.btnUpdate)
        var buttonRemove = findViewById<Button>(R.id.btnRemove)
        var buttonShow = findViewById<Button>(R.id.btnShow)

        //declaration of edit text variable
        var editUsername = findViewById<EditText>(R.id.edtUsername)
        var editPassword = findViewById<EditText>(R.id.edtPassword)

        //Declaration of textview variable  probably no longer used
        var textCounter = findViewById<TextView>(R.id.txtCounter)

        //Declaration of array list
        var arrayAccount = ArrayList<Account>()

        //buttons
        buttonAdd.setOnClickListener{
         try{
             val username = editUsername.text.toString()
             val password = editPassword.text.toString()
            if (!username.isNullOrBlank() && !password.isNullOrBlank()) {
                val newAccount = Account(username, password)
                arrayAccount.add(newAccount)
                //textCounter.setText(arrayAccount.size.toString())
                Log.i("info_garma", "New user is added: ${editUsername.text.toString()}")
                toastFunc("User Account has been added successfully!")
            }else {
                Log.e("error_garma", "Username and/or Password is null or blank")
                toastFunc("Kindly insert value in Username AND password")
                editUsername.setText("")
                editPassword.setText("")
            }
         }catch(e:Exception){
             Log.e("error_garma", e.message.toString())
         }
        }
        buttonUpdate.setOnClickListener{
            try {
                val username = editUsername.text.toString()
                val password = editPassword.text.toString()
                var existingAccount = arrayAccount.indexOfFirst{it.username == username}
                if (!username.isNullOrBlank() && !password.isNullOrBlank() && existingAccount >= 0){
                    val savedPassword = arrayAccount[existingAccount].password
                    if (password == savedPassword) {
                        arrayAccount[existingAccount] = Account(username, password)
                        Log.i("info_garma", "New user is updated: ${editUsername.text.toString()}")
                        toastFunc("User Account has been updated successfully!")
                    }else {
                        Log.e("error_garma", "Mismatch password")
                        toastFunc("Password is incorrect")
                    }
                }else {
                    Log.e("error_garma", "User Account does not exist")
                    toastFunc("Kindly insert value in User Account")
                    editUsername.setText("")
                    editPassword.setText("")
                }
            }catch(e:Exception) {
                Log.e("error_garma", e.message.toString())
            }
        }
        buttonRemove.setOnClickListener{
            try {
                val username = editUsername.text.toString()
                val password = editPassword.text.toString()
                var existingAccount = arrayAccount.indexOfFirst{it.username == username}
                if (!username.isNullOrBlank() && !password.isNullOrBlank() && existingAccount >= 0){
                    val savedPassword = arrayAccount[existingAccount].password
                    if(password == savedPassword) {
                        Log.i("info_garma", "New user is deleted: ${editUsername.text.toString()}")
                        arrayAccount.removeAt(existingAccount)
                        toastFunc("User Account has been deleted successfully!")
                    }else {
                        Log.e("error_garma", "Mismatch password")
                        toastFunc("Password is incorrect")
                    }
                }else {
                    Log.e("error_garma", "User Account does not exist")
                    toastFunc("Kindly insert value in User Account")
                    editUsername.setText("")
                    editPassword.setText("")
                }
            }catch(e:Exception) {
                Log.e("error_garma", e.message.toString())
            }
        }
        buttonShow.setOnClickListener{
         try {
             Log.e("show_account", "Accounts:")
             for (element in arrayAccount){
                 Log.e("show_account", " ${element}")
             }
         } catch(e:Exception) {
             Log.e("error_garma", e.message.toString())
         }
        }
    }

    fun toastFunc(messageToast: String) {
        Toast.makeText(this, messageToast, Toast.LENGTH_SHORT).show()
    }
}