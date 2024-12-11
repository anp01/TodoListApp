package com.example.sampleapp.presentation.nav.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onDisplayAll: () -> Unit,
    onDisplayFalse: () -> Unit,
    onDisplayTest: () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onDisplayAll() }) {
            Text("Display All")
        }

        Spacer(Modifier.height(24.dp))

        Button(onClick = { onDisplayFalse() }) {
            Text("Display false Todo")
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = { onDisplayTest() }) {
            Text("Test")
        }
    }
}