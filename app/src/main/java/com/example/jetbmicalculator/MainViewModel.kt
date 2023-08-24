package com.example.jetbmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class MainViewModel : ViewModel() {
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmi by mutableStateOf(0f)// 0fをつけるとFloat型になる

    // BMI = (体重kg) / (身長m) ** 2
    fun calculateBMI() {
        val heightNumber = height.toFloatOrNull() ?.div(100) ?: 0f// 数字に変換できない場合はnullを返す
        val weightNumber = weight.toFloatOrNull() ?: 0f

        bmi = if(heightNumber > 0f && weightNumber > 0f) {
            (weightNumber / heightNumber.pow(2) * 10).roundToInt() / 10f
        } else 0f
    }
}