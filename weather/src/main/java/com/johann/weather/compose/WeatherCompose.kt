package com.johann.weather.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.johann.style.primaryContainerLight
import com.johann.style.primaryDark
import com.johann.style.primaryLight
import com.johann.weather.R
import com.johann.weather.ui.WeatherUi
import com.johann.weather.ui.WeatherUiState


@Composable
fun WeatherScreen(ui: WeatherUiState, onRefresh: () -> Unit, onSearch: (String) -> Unit) {
    when (ui) {
        is WeatherUiState.LAUNCH -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        }

        is WeatherUiState.Success -> {
            WeatherSuccessScreen(ui.data, onRefresh, onSearch)
        }

        is WeatherUiState.Error -> {
            Text(text = ui.errorMessage)
        }
    }

}

@Composable
fun WeatherSuccessScreen(data: WeatherUi, onRefresh: () -> Unit, onSearch: (String) -> Unit) {
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
                .padding(12.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(primaryLight)
        ) {
            var text by remember { mutableStateOf(data.addressLine) }

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(stringResource(R.string.displaying_weather_for)) },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                textStyle = TextStyle(fontSize = 26.sp),
                colors = TextFieldDefaults.colors().copy(
                    focusedContainerColor = primaryContainerLight,
                    unfocusedContainerColor = primaryContainerLight,
                    textSelectionColors = TextSelectionColors(
                        handleColor = primaryLight,
                        backgroundColor = primaryLight
                    )
                ),
                shape = MaterialTheme.shapes.small // Use the small shape from your theme
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Button(colors = ButtonDefaults.buttonColors(
                    containerColor = primaryDark,
                    contentColor = primaryLight
                ),
                    onClick = { onSearch(text) }) {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                }
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryDark,
                        contentColor = primaryLight
                    ),
                    onClick = onRefresh
                ) {
                    Icon(Icons.Default.LocationOn, contentDescription = "Refresh")
                }
            }
        }
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primaryLight)
            ) {
                Image(
                    painter = painterResource(com.johann.style.R.drawable.thermometer),
                    contentDescription = "Temperature",
//                    tint = primaryLight,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = data.temperature,
                    style = MaterialTheme.typography.labelMedium,

                    color = primaryDark
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primaryLight)
            ) {
                Image(
                    painter = painterResource(com.johann.style.R.drawable.humidity),
                    contentDescription = "Temperature",
//                    tint = primaryLight,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                )
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = data.humidity,
                    style = MaterialTheme.typography.labelMedium,
                    color = primaryDark
                )
            }
        }
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primaryLight)
            ) {
                Image(
                    painter = painterResource(id = com.johann.style.R.drawable.wind),
                    contentDescription = "Temperature",
//                    tint = primaryLight,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = data.windSpeed,
                    style = MaterialTheme.typography.labelMedium,
                    color = primaryDark
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primaryLight)
            ) {
                Image(
                    painter = painterResource(id = data.weatherIcon),
                    contentDescription = "Weather Icon",
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    modifier = Modifier
                        .padding(12.dp),
                    text = data.weatherDescription,
                    style = MaterialTheme.typography.labelMedium,
                    color = primaryDark
                )
            }
        }

    }
}
