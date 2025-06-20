package com.pain.jetpack_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pain.jetpack_04.ui.theme.Jetpack_04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jetpack_04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FlowLayout(Modifier.padding(innerPadding))
                }
            }
        }
    }


    @OptIn(ExperimentalLayoutApi::class)
    @Composable
    fun FlowLayout(modifier: Modifier){
        FlowRow (
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
//            repeat(5){item->
//                ChipItem("hii")
//            }
            ChipItem("hii")
            ChipItem("hii")
            ChipItem("hii")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")
            ChipItem("I m prashant")

        }
    }

    @Composable
    fun ChipItem(text : String){
        Surface (
            shape = RoundedCornerShape(16.dp),
            color = Color.LightGray,
            modifier = Modifier
                .padding(4.dp)
        ){
            Text(
                text = text,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
            )
        }
    }
}


