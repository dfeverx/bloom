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
