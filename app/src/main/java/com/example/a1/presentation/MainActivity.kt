package com.example.a1.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a1.R
import com.example.a1.data.repository.UserRepoImpl
import com.example.a1.domain.models.SaveUserNameParam
import com.example.a1.domain.models.UserName
import com.example.a1.domain.repository.UserRepo
import com.example.a1.domain.usecase.GetUserNameUseCase
import com.example.a1.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {


    private val userRepo by lazy { UserRepoImpl(context = applicationContext) }
    private val getUserNameUseCase by lazy{GetUserNameUseCase(userRepo = userRepo)}
    private val saveUserNameUseCase by lazy{SaveUserNameUseCase(userRepo = userRepo)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.viewText)
        val textEdit = findViewById<EditText>(R.id.editText)
        val getButton = findViewById<Button>(R.id.btnGet)
        val saveButton = findViewById<Button>(R.id.btnSave)


        getButton.setOnClickListener {

            val userName: UserName = getUserNameUseCase.execute()
            textView.text = "${userName.firstName} ${userName.secondName}"

        }

        saveButton.setOnClickListener {

            val text = textEdit.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            textView.text = "Save result = $result"
        }

    }
}