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
package com.example.androiddevchallenge.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.Body2
import com.example.androiddevchallenge.ui.components.H1
import com.example.androiddevchallenge.ui.components.OutlinedTextInput
import com.example.androiddevchallenge.ui.components.PrimaryButton

@Composable
fun LogIn(navController: NavController) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            H1(text = "Log in with email", modifier = Modifier.paddingFromBaseline(top = 184.dp))
            OutlinedTextInput(
                "Email address", {}
            )
            OutlinedTextInput(
                "Password (8+ characters)", {},
                Modifier
                    .padding(top = 8.dp)

            )
            val annotatedText =
                AnnotatedString.Builder(stringResource(R.string.terms_privacy_policy_link)).apply {
                    addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), 35, 48)
                    addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline), 68, 82)
                }
            Body2(
                text = annotatedText.toAnnotatedString(),
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            )
            PrimaryButton(
                buttonText = "Log in",
                onButtonClick = { navController.navigate("home") },
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
            )
        }
    }


}
