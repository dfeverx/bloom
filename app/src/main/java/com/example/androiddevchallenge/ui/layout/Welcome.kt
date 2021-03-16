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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.PrimaryButton
import com.example.androiddevchallenge.ui.components.SecondaryButton
import com.example.androiddevchallenge.ui.components.Subtitle1

@Composable
fun Welcome(navController: NavController) {
    Surface(color = MaterialTheme.colors.primary) {

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
//        Background
            Image(
                painter = painterResource(id = R.drawable.welcome_bg),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
//        Content
            Content(navController)
        }
    }
}

@Composable
fun Content(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
//        Illos
        Image(
            painter = painterResource(id = R.drawable.welcome_illos),
            modifier = Modifier.padding(start = 88.dp, top = 72.dp, bottom = 48.dp),
            contentDescription = null,
//            contentScale = ContentScale.Crop
        )
//        Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null
        )
// Slogan
        Subtitle1(
            text = stringResource(R.string.slogan),
            modifier = Modifier
                .paddingFromBaseline(top = 32.dp, bottom = 40.dp)
        )

/*        Text(
            stringResource(R.string.slogan),
            modifier = Modifier
//                .firstBaselineToTop(32.dp)
                .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
//                .padding(bottom = 40.dp),
            style = MaterialTheme.typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )*/
//       Create account button
/*        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = MaterialTheme.colors.onSecondary
            ),

            shape = MaterialTheme.shapes.medium,
            onClick = { }, modifier = Modifier
                .padding(bottom = 8.dp)
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Create account")
        }*/
        PrimaryButton(
            buttonText = stringResource(R.string.create_account),
            onButtonClick = { /*navController?.navigate("")*/ },
            modifier = Modifier
                .padding(bottom = 8.dp)
                .height(48.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

//        Login
/*
        Button(
            border = null, elevation = null,
            modifier = Modifier.padding(top = 24.dp),
            onClick = { navController?.navigate("log_in") }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = MaterialTheme.colors.primaryVariant
            )
        ) {
            Text(text = "Log in")
        }
*/
        SecondaryButton(
            buttonText = stringResource(R.string.login),
            onClick = { navController.navigate("log_in") },
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}
