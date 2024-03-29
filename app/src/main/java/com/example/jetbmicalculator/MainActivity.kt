package com.example.jetbmicalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbmicalculator.ui.theme.JetBMICalculatorTheme

class MainActivity : ComponentActivity() {
    private  val viewModel by viewModels<MainViewModel>()

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
                        PinkLabeledTextField(
                            value = viewModel.height,
                            onValueChange = { viewModel.height = it},
                            label = "身長(cm)",
                            placeholder = "170",
                        )
                        Spacer(modifier = Modifier.padding(20.dp))

                        // 体重
                        PinkLabeledTextField(
                            value = viewModel.weight,
                            onValueChange = {
                                viewModel.weight = it
                            },
                            label = "体重(kg)",
                            placeholder = "65",
                        )
                        Spacer(modifier = Modifier.padding(20.dp))

                        // 計算する
                        Button(
                            onClick = {
                                viewModel.calculateBMI()
                            },
                            modifier = Modifier.fillMaxWidth(),// 画面幅いっぱいに広げる
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF85F64)// 背景色をピンクにする
                            ),
                        ) {
                            Text(
                                text = "計算する",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.padding(20.dp))

                        // 結果を表示テキスト
                        Text(
                            text = "あなたのBMIは${viewModel.bmi}です",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PinkLabeledTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
) {
    Column {
        // 身長
        Text(text = label, color = Color(0xFFF85F64), fontWeight = FontWeight.Bold)
        // TextFieldを使って入力欄を作成
        TextField(
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent// 透明にする
            ),
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = placeholder)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true// 1行のみ
        )
    }
}