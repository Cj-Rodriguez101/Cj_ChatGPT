package com.cjrodriguez.cjchatgpt.presentation.screens.chatScreen.components

import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PictureAsPdf
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cjrodriguez.cjchatgpt.R.string

@Composable
fun FileContainer(
    uri: Uri,
    removeFile: (Uri) -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(100.dp)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(20)
            )
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxSize()
                .align(Companion.CenterStart)
                .padding(8.dp),
            model = uri,
            contentDescription = stringResource(id = string.generated_image),
            placeholder = rememberVectorPainter(image = Icons.Default.PictureAsPdf),
            error = rememberVectorPainter(image = Icons.Default.PictureAsPdf)
        )

        IconButton(
            modifier = Modifier.align(Companion.TopEnd),
            onClick = {
                removeFile(uri)
            }) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = stringResource(string.remove_file)
            )
        }
    }
}