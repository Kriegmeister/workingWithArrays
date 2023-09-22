package com.example.workingwitharrays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

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

        //Declaration of textview variable
        var textCounter = findViewById<TextView>(R.id.txtCounter)

        //Declaration of array list
        var arrayAccount = ArrayList<String>()

        //buttons
        buttonAdd.setOnClickListener{
         try{
            if (!editUsername.text.toString().isNullOrEmpty()) {
                arrayAccount.add(editUsername.text.toString())
                textCounter.setText(arrayAccount.size.toString())
                Log.i("info_garma", "New user is added: ${editUsername.text.toString()}")
                toastFunc("User Account has been added successfully!")
            }else {
                Log.e("error_garma", "User Account is null or blank")
                toastFunc("Kindly insert value in User Account")
                editUsername.setText("")
            }
         }catch(e:Exception){
             Log.e("error_garma", e.message.toString())
         }
        }
        buttonUpdate.setOnClickListener{
            try {
                var existingAccount = arrayAccount.indexOf(editUsername.text.toString())
                if (existingAccount > 0){
                    arrayAccount[existingAccount] = editUsername.text.toString() + "_updated"
                    Log.i("info_garma", "New user is updated: ${editUsername.text.toString()}")
                    toastFunc("User Account has been updated successfully!")
                }else {
                    Log.e("error_garma", "User Account does not exist")
                    toastFunc("Kindly insert value in User Account")
                    editUsername.setText("")
                }
            }catch(e:Exception) {
                Log.e("error_garma", e.message.toString())
            }
        }
        buttonRemove.setOnClickListener{
            try {
                var existingAccount = arrayAccount.indexOf(editUsername.text.toString())
                if (existingAccount >= 0){
                    Log.i("info_garma", "New user is deleted: ${editUsername.text.toString()}")
                    arrayAccount.removeAt(existingAccount)
                    toastFunc("User Account has been deleted successfully!")
                }else {
                    Log.e("error_garma", "User Account does not exist")
                    toastFunc("Kindly insert value in User Account")
                    editUsername.setText("")
                }
            }catch(e:Exception) {
                Log.e("error_garma", e.message.toString())
            }
        }
        buttonShow.setOnClickListener{
         try {
             for (element in arrayAccount){
                 Log.e("show_account", "For loop: ${element}")
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