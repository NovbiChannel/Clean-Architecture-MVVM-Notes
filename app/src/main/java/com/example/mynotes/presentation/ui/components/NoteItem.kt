package com.example.mynotes.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NoteItem(title: String, content: String, modifier: Modifier) {

    val limit = 50
    val formatContent: String = if (content.length > limit) {
        content.substring(0, limit) + "..."
    } else {
        content
    }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(MaterialTheme.colors.primary)
                .padding(vertical = 20.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = formatContent,
                fontSize = 12.sp,
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 8.dp)
                    .padding(top = 24.dp)
            )
        }
    }
}