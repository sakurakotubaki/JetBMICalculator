package com.example.jetbmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbmicalculator.ui.theme.JetBMICalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(text = "BMI計算アプリ", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.padding(30.dp))

                        // 身長
                        Text(text = "身長(cm)", color = Color(0xFFF85F64), fontWeight = FontWeight.Bold)
                        // TextFieldを使って入力欄を作成
                        TextField(
                            value = "",
                            onValueChange = { },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent// 透明にする
                            ),
                            modifier = Modifier.fillMaxWidth(),
                            placeholder = {
                                Text(text = "170")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            singleLine = true// 1行のみ
                        )
                    }
                }
            }
        }
    }
}