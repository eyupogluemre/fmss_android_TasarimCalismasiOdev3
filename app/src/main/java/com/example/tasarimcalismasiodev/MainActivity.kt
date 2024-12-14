package com.example.tasarimcalismasiodev

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasarimcalismasiodev.ui.theme.TasarimCalismasiOdevTheme
import com.example.tasarimcalismasiodev.ui.theme.anton
import com.example.tasarimcalismasiodev.ui.theme.dark1
import com.example.tasarimcalismasiodev.ui.theme.dark2
import com.example.tasarimcalismasiodev.ui.theme.dark3Baslik
import com.example.tasarimcalismasiodev.ui.theme.josefin
import com.example.tasarimcalismasiodev.ui.theme.passion

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            TasarimCalismasiOdevTheme {
                Page1()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page1(darkTheme: Boolean = isSystemInDarkTheme()) {

    val configuration = LocalConfiguration.current
    val ekranYuksekligi = configuration.screenHeightDp
    val ekranGenisligi = configuration.screenWidthDp

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "TherapyTime", color = Color.White, fontFamily = anton) },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = if (darkTheme) dark1 else Color(0xFF7CA5E0),
                titleContentColor = Color.Black
            )
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.drawable.resim4), contentDescription = "")
            Text(
                text = stringResource(id = R.string.baslik1),
                fontSize = (ekranGenisligi / 15).sp,
                textAlign = TextAlign.Center,
                color = if (darkTheme) dark3Baslik else Color(0xFF39476e)

            )
            Text(
                text = stringResource(id = R.string.baslik2),
                fontSize = (ekranGenisligi / 25).sp,
                textAlign = TextAlign.Center,
                color = if (darkTheme) dark3Baslik else Color(0xFF39476e),
                modifier = Modifier.padding(top = 10.dp)

            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilterChip1(stringResource(id = R.string.bozukluk1))
                    FilterChip1(stringResource(id = R.string.bozukluk2))
                    FilterChip1(stringResource(id = R.string.bozukluk3))
                    FilterChip1(stringResource(id = R.string.bozukluk4))

                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilterChip1(stringResource(id = R.string.bozukluk5))
                    FilterChip1(stringResource(id = R.string.bozukluk6))
                    FilterChip1(stringResource(id = R.string.bozukluk7))
                    FilterChip1(stringResource(id = R.string.bozukluk8))
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    FilterChip1(stringResource(id = R.string.bozukluk9))
                    FilterChip1(stringResource(id = R.string.bozukluk10))
                    FilterChip1(stringResource(id = R.string.bozukluk11))
                    FilterChip1(stringResource(id = R.string.bozukluk12))
                }
                Button(
                    onClick = { },
                    modifier = Modifier.padding(top = 30.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (darkTheme) dark1 else Color(0xFF7CA5E0),
                        contentColor = Color.White

                    )
                ) {
                    Text(stringResource(id = R.string.buton), fontSize = 18.sp)
                }
            }

        }

    }


}

@Composable
fun FilterChip1(text1: String, darkTheme: Boolean = isSystemInDarkTheme()) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text1, color = if (darkTheme) dark2 else Color.Black)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = if (darkTheme) Color.Black else Color(
                0xFFf0de99
            )
        )
    )
}
