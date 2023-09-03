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
    private var canResult = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun allClearAction(view: View) {
        with(binding){
            num1.text = ""
            operator.text = ""
            num2.text = ""
            resultNum.text = ""

            canAddNum1 = true
            canAddNum2 = false
            canAddOperation = false
            canResult = false
        }
    }

    fun backspaceAction(view: View) {
        with(binding){
            var length = 0
            if(canAddNum1){
                length = num1.length()
                if(length>0)
                    num1.text = num1.text.subSequence(0, length-1)
            } else if(canAddOperation){
                length = 1
                if(length>0)
                    operator.text = ""
            } else if(canAddNum2){
                length = num2.length()
                if(length>0)
                    num2.text = num2.text.subSequence(0, length-1)
            }
        }
    }

    fun operationAction(view: View) {
        with(binding){
            if(canAddOperation){
                operator.append((view as Button).text.toString())
                canAddNum1 = false
                canAddOperation = false
                canAddNum2 = true
            }
        }
    }

    fun numberAction(view: View) {
        with(binding){
            if(canAddNum1){
                num1.append((view as Button).text.toString())
                canAddOperation = true
            } else if(canAddNum2){
                num2.append((view as Button).text.toString())
                canAddOperation = false
                canResult = true
            }
        }
    }

    fun equalsAction(view: View) {
        with(binding){
            if(canResult){
                var num1 = num1.text.toString().toInt()
                var num2 = num2.text.toString().toInt()
                var result = 0
                when(operator.text.toString()){
                    "%" -> result = num1%num2
                    "/" -> result = num1/num2
                    "*" -> result = num1*num2
                    "-" -> result = num1-num2
                    "+" -> result = num1+num2
                }
                resultNum.append(result.toString())
            }
        }
    }



}