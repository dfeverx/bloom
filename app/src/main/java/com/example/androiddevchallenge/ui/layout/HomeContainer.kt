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

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.components.MyBottomNavigation
import com.example.androiddevchallenge.ui.layout.bnav.CartItem
import com.example.androiddevchallenge.ui.layout.bnav.FavoritesItem
import com.example.androiddevchallenge.ui.layout.bnav.HomeContent
import com.example.androiddevchallenge.ui.layout.bnav.ProfileItem

@Composable
fun HomeContainer() {
    Surface(color = MaterialTheme.colors.background) {
        BottomNavContent()
    }
}

@Composable
fun BottomNavContent() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
    val items = listOf(
        Screen.Home,
        Screen.Favorites,
        Screen.Profile,
        Screen.Cart
    )
    Scaffold(
        bottomBar = { MyBottomNavigation(items, navController, currentRoute) },
        content = {
            MainContent(navController)
        }
    )
}

@Composable
fun MainContent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home_item"
    ) {
        composable("home_item") {
            HomeContent()
        }
        composable("cart_item") {
            CartItem()
        }
        composable("profile_item") {
            ProfileItem()
        }
        composable("favorites_item") {
            FavoritesItem()
        }
    }
}

sealed class Screen(val route: String, @StringRes val label: Int, val icon: ImageVector) {
    object Home : Screen("home_item", R.string.home, Icons.Filled.Home)
    object Favorites : Screen("favorites_item", R.string.favorites, Icons.Outlined.FavoriteBorder)
    object Profile : Screen("profile_item", R.string.profile, Icons.Filled.AccountCircle)
    object Cart : Screen("cart_item", R.string.cart, Icons.Filled.ShoppingCart)
}
