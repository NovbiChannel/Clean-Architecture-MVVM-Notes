package com.example.mynotes.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotes.presentation.ui.theme.Black
import com.example.mynotes.presentation.ui.theme.White

@Composable
fun NoteItem(title: String, content: String, modifier: Modifier) {

    val limit = 50
    val formatContent: String
    if (content.length > limit) {
        formatContent = content.substring(0, limit) + "..."
    } else {
        formatContent = content
    }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .shadow(elevation = 10.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White)
                .padding(vertical = 20.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = formatContent,
                fontSize = 12.sp,
                color = Black,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp)
                    .padding(top = 24.dp)
            )
        }
    }
}