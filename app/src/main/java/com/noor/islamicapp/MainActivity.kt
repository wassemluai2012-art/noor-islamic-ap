package com.noor.islamicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val bg = Color(0xFF091713)
val green = Color(0xFF19382C)
val gold = Color(0xFFD8B66A)
val white = Color(0xFFF4F1E8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoorApp()
        }
    }
}

@Composable
fun NoorApp() {
    var page by remember { mutableStateOf("الرئيسية") }

    MaterialTheme(
        colorScheme = darkColorScheme(
            background = bg,
            surface = green,
            primary = gold
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(bg)
                .padding(20.dp)
        ) {
            Text(
                "نور 🌙",
                color = gold,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(Modifier.height(25.dp))

            when (page) {
                "الرئيسية" -> Home()
                "القرآن" -> Quran()
                "الأذكار" -> Azkar()
                "المسبحة" -> Tasbeeh()
            }

            Spacer(Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                listOf("الرئيسية", "القرآن", "الأذكار", "المسبحة")
                    .forEach { item ->
                        TextButton(onClick = { page = item }) {
                            Text(item, color = gold)
                        }
                    }
            }
        }
    }
}

@Composable
fun Home() {
    Text("السلام عليكم ورحمة الله", color = white, fontSize = 23.sp)
    Spacer(Modifier.height(15.dp))
    Card(colors = CardDefaults.cardColors(containerColor = green)) {
        Column(Modifier.padding(20.dp)) {
            Text("أهلاً بك في نور", color = gold, fontSize = 23.sp)
            Text("رفيقك اليومي للقرآن والذكر", color = white)
        }
    }
    Spacer(Modifier.height(20.dp))
    Text("﴿ إِنَّ مَعَ الْعُسْرِ يُسْرًا ﴾", color = gold, fontSize = 22.sp)
    Text("سورة الشرح - 6", color = white)
}

@Composable
fun Quran() {
    Text("القرآن الكريم", color = gold, fontSize = 25.sp)
    Text("114 سورة من كتاب الله", color = white)
    listOf("الفاتحة", "البقرة", "آل عمران", "النساء", "المائدة")
        .forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 5.dp),
                colors = CardDefaults.cardColors(containerColor = green)
            ) {
                Text(it, color = white, modifier = Modifier.padding(15.dp))
            }
        }
}

@Composable
fun Azkar() {
    Text("الأذكار", color = gold, fontSize = 25.sp)
    Text("سبحان الله وبحمده", color = white, fontSize = 22.sp)
    Text("أذكارك اليومية في مكان واحد", color = white)
}

@Composable
fun Tasbeeh() {
    var count by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("المسبحة الإلكترونية", color = gold, fontSize = 24.sp)
        Spacer(Modifier.height(30.dp))
        Text("$count", color = white, fontSize = 65.sp)

        Button(
            onClick = { count++ },
            colors = ButtonDefaults.buttonColors(
                containerColor = gold
            )
        ) {
            Text("سبّح", color = bg, fontSize = 22.sp)
        }

        TextButton(onClick = { count = 0 }) {
            Text("إعادة العداد", color = white)
        }
    }
}