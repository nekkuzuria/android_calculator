package com.example.android_calculator

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.android_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var canAddOperation = false
    private var canAddNum1 = true
    private var canAddNum2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun allClearAction(view: View) {
        binding.num1 = ""
        binding.operator = ""
        binding.num2 = ""
        binding.resultNum = ""
    }

    fun backspaceAction(view: View) {

    }

    fun operationAction(view: View) {

    }

    fun numberAction(view: View) {
        if(canAddNum1){
            binding.num1.append(view.text)
            canAddOperation = true
        } else if(canAddNum2){
            binding.num2.append(view.text)
            canAddOperation = false
        }
    }

    fun equalsAction(view: View) {

    }



}