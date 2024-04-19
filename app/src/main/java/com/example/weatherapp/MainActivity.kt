package com.example.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WeatherAppScreen(modifier = Modifier.fillMaxWidth().background(Color.Blue))
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherAppScreen(modifier: Modifier) {

    Box(modifier = modifier) {
        Scaffold(
            topBar = { WeatherAppTopBar() },
            modifier = Modifier.fillMaxSize()
                .background(Color.Blue)
        ) {
            Box(modifier = Modifier.fillMaxSize().padding(top = 100.dp)) {
                WeatherAppLayout()
            }
        }
    }
}

@Composable
fun WeatherAppTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(5.dp)
    ) {
        Text(text = stringResource(R.string.bommanahalli))

    }
}

@Composable

fun WeatherAppLayout() {

    Column {
        CurrentWeatherStatus()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
        ) {
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = stringResource(R.string.settings),
                    modifier = Modifier.padding(end = 5.dp)
                )
                Text(text = "Low pollen count")
            }
        }
        WeatherStatusLater(modifier = Modifier)

    }
}

@Composable
fun WeatherStatusLater(modifier: Modifier) {
    Box(modifier = modifier
        .padding(5.dp)
        .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            ) {
            Row(
            ) {
                WeatherAtTime(time = "Now", temperature = "33", modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp))
                WeatherAtTime(time = "14:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "15:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "16:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "17:00", temperature = "35°", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun WeatherAtTime(time:String , temperature:String , modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = time,
            style = TextStyle(fontSize = 10.sp),
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Icon(
            imageVector = Icons.Filled.Cloud,
            contentDescription = "Weather",
            modifier = Modifier.padding(bottom = 4.dp),
            tint = Color.LightGray
            )
        Text(text = temperature)
    }
}
@Composable
fun TemperatureBox(modifier: Modifier = Modifier, temperature: String="") {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "A little warmer than yesterday\n$temperature",
            color = Color.White,
            fontSize = 24.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        )
    }
}

@Composable
    fun CurrentWeatherStatus()
{
    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){

        Text("33°", style = TextStyle(fontSize = 90.sp))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Partly Cloudy 24°/ 36° Air quality: 58-")
        Text("Satisfactory")
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppScreen(modifier = Modifier)
}