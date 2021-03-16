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
package com.example.androiddevchallenge.fakerepo

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.entity.Plant
import com.example.androiddevchallenge.entity.Theme

val themes = listOf(

    Theme("Desert chic", R.drawable.desert_chic),
    Theme("Tiny terraiums", R.drawable.tiny),
    Theme("Jungle vibes", R.drawable.jungle),
    Theme("Easy care", R.drawable.easy),
    Theme("Statements", R.drawable.statement),

    )
val plants = listOf(
    Plant("Monstera", "This is a description", R.drawable.monstera, true),
    Plant("Aglaonema", "This is a description", R.drawable.aglaonema),
    Plant("Peace lily", "This is a description", R.drawable.peace),
    Plant("Fiddle leaf tree", "This is a description", R.drawable.fiddle),
    Plant("Snake plant", "This is a description", R.drawable.snake),
    Plant("Pothos", "This is a description", R.drawable.pothos),
)
