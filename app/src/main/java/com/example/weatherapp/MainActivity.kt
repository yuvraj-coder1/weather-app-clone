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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.RemoveRedEye
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
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
                    WeatherAppScreen(modifier = Modifier)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WeatherAppScreen(modifier: Modifier) {

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.weather_image),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Background Image",
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.6f),

            )
            Column(modifier = modifier.verticalScroll(rememberScrollState())) {
            WeatherAppTopBar()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp)
            ) {
                WeatherAppLayout()
            }

        }
    }
}

@Composable
fun WeatherAppTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(text = stringResource(R.string.bommanahalli))

    }
}

@Composable
fun WeatherAppLayout() {

    Column() {
        CurrentWeatherStatus()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
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
        WeeklyWeatherReport()
        AirQuality()
        precisedWeatherDetail()
    }
}
@Composable
fun precisedWeatherDetail() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherSpecification(parameterIcon = Icons.Filled.LightMode, condition = "UV", magnitude = "6 Moderate",modifier = Modifier.weight(1f) )
            WeatherSpecification(parameterIcon = Icons.Filled.Thermostat, condition = "Feels Like", magnitude = "35°",modifier = Modifier.weight(1f) )
            WeatherSpecification(parameterIcon = Icons.Filled.WaterDrop, condition = "Humidity", magnitude = "35%",modifier = Modifier.weight(1f) )
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            WeatherSpecification(parameterIcon = Icons.Filled.Air, condition = "ESE Wind", magnitude = "8kmh",modifier = Modifier.weight(1f) )
            WeatherSpecification(parameterIcon = Icons.Filled.ArrowDownward, condition = "Air Pressure", magnitude = "1009hPa" ,modifier = Modifier.weight(1f))
            WeatherSpecification(parameterIcon = Icons.Filled.RemoveRedEye, condition = "Visibility", magnitude = "8 km" ,modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun WeeklyWeatherReport() {
    Box(

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                .padding(15.dp)

        ) {
            WeatherForecast(
                date = "4:19",
                day = "Today",
                Weather = Icons.Filled.Cloud,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.LightGray

            )
            WeatherForecast(
                date = "4:20",
                day = "Tomorrow",
                Weather = Icons.Filled.Cloud,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.LightGray
            )
            WeatherForecast(
                date = "4:20",
                day = "sun",
                Weather = Icons.Filled.Cloud,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.LightGray
            )
            WeatherForecast(
                date = "4:20",
                day = "mon",
                Weather = Icons.Filled.Cloud,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.LightGray
            )
            WeatherForecast(
                date = "4:19",
                day = "tue",
                Weather = Icons.Filled.LightMode,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.Yellow
            )
            WeatherForecast(
                date = "4:19",
                day = "Wed",
                Weather = Icons.Filled.Cloud,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.LightGray
            )
            WeatherForecast(
                date = "4:19",
                day = "Thu",
                Weather = Icons.Filled.LightMode,
                temperaturRange = "24°/35°",
                modifier = Modifier.weight(1f),
                IconColour = Color.Yellow
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text("15-day weather forecast")
                }
            }
        }
    }
}

@Composable
fun WeatherStatusLater(modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(15.dp)
            .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
            ) {
                WeatherAtTime(
                    time = "Now", temperature = "33°", modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp)
                )
                WeatherAtTime(time = "14:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "15:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "16:00", temperature = "34°", modifier = Modifier.weight(1f))
                WeatherAtTime(time = "17:00", temperature = "35°", modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun WeatherAtTime(time: String, temperature: String, modifier: Modifier) {
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
fun TemperatureBox(modifier: Modifier = Modifier, temperature: String = "") {
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
fun CurrentWeatherStatus() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("33°", style = TextStyle(fontSize = 90.sp))
        Spacer(modifier = Modifier.height(10.dp))
        Text("Partly Cloudy 24°/ 36° Air quality: 58-")
        Text("Satisfactory")
        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun WeatherForecast(
    date: String,
    day: String,
    Weather: ImageVector,
    temperaturRange: String,
    modifier: Modifier,
    IconColour:Color
) {
    Box(
        modifier = Modifier.padding(bottom = 10.dp)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = date, modifier.weight(1f))
            Text(text = day, modifier.weight(1f))
            Icon(
                imageVector = Weather,
                contentDescription = null,
                modifier.weight(1f),
                tint = IconColour
            )
            Text(text = temperaturRange, modifier.weight(1f))
        }
    }
}

@Composable
fun WeatherSpecification(parameterIcon:ImageVector,condition:String,magnitude:String,modifier:Modifier) {
        Card(
            modifier = modifier
                .padding(10.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
            ) {
                Icon(
                    imageVector = parameterIcon, // Load the sun icon using painterResource
                    contentDescription = "Sun Icon", // Provide a meaningful content description
                    tint = Color.LightGray, // Set the color of the sun icon
                    modifier = Modifier.size(28.dp) // Set the size of the icon
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(condition,style = TextStyle(fontSize = 10.sp))
                Text(magnitude, style = TextStyle(fontSize = 15.sp))

            }

    }
}

@Composable
fun AirQuality() {
    Row(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    "Air Quality",
                    modifier = Modifier.padding(bottom = 8.dp) // Add space below the text
                )
//                Text(">") // Assuming this is some kind of indicator, you might want to adjust its styling
                Spacer(modifier = Modifier.height(10.dp))
                Text("Satisfactory 72", style = TextStyle(fontSize = 20.sp))
                Text("Air quality is acceptable. However, unusually sensitive")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppScreen(modifier = Modifier)
}