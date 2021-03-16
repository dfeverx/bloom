/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun H1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.h1,
        color = MaterialTheme.colors.onSurface
    )
}
@Composable
fun H2(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.h2,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
fun Subtitle1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.subtitle1,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
fun Body1(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.body1,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
fun Body2(text: AnnotatedString, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.body2,
        color = MaterialTheme.colors.onSurface,
        textAlign = TextAlign.Center
    )
}

@Composable
fun OutlinedTextInput(
    value: String,
    onValueChangeListener: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChangeListener(it)
        },
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1,

    )
}

@Composable
fun TextSearch(
    value: String,
    onValueChangeListener: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChangeListener(it)
        },
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1,
        leadingIcon = {
            // In this method we are specifying
            // our leading icon and its color.
            Icon(imageVector = Icons.Filled.Search, contentDescription = null, Modifier.size(18.dp))
        },
    )
}
