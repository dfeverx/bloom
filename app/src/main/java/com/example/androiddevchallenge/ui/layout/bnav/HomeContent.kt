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
package com.example.androiddevchallenge.ui.layout.bnav

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.entity.Plant
import com.example.androiddevchallenge.entity.Theme
import com.example.androiddevchallenge.fakerepo.plants
import com.example.androiddevchallenge.fakerepo.themes
import com.example.androiddevchallenge.ui.components.Body1
import com.example.androiddevchallenge.ui.components.H1
import com.example.androiddevchallenge.ui.components.H2
import com.example.androiddevchallenge.ui.components.TextSearch

@Composable
fun HomeContent() {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 56.dp)
        ) {
            item {
                HomeHeader()
            }
            item {
                BrowseThemes()
            }
            item {
                DesignUrGardenHeader()
            }
            items(plants) {
//                DesignUrGardenItem(it)
                FullWidthItem(it)
            }
        }
    }
}

@Composable
fun FullWidthItem(plant: Plant) {

    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .height(64.dp)
            .padding(horizontal = 16.dp)
            .clickable { }
    ) {
//        left Img
        Card(
            modifier = Modifier.size(64.dp),
            elevation = 0.dp,
            shape = MaterialTheme.shapes.small
        ) {
            Image(
                modifier = Modifier
                    .size(64.dp),
                painter = painterResource(id = plant.img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }

//        remaining
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    H2(
                        text = plant.title,
                        modifier = Modifier
                            .paddingFromBaseline(top = 24.dp)
                            .padding(start = 16.dp)
                    )
                    Body1(
                        text = plant.description,
                        modifier = Modifier
                            .paddingFromBaseline(bottom = 24.dp)
                            .padding(start = 16.dp)
                    )
                }
//                Spacer(modifier = Modifier.weight(1f))
                Checkbox(
                    checked = plant.isSelected,
                    onCheckedChange = { /*TODO*/ },
                    colors = CheckboxDefaults.colors(checkmarkColor = MaterialTheme.colors.onSecondary),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(24.dp)
                )
            }
            Divider(modifier = Modifier.padding(start = 8.dp), thickness = 1.dp)
        }
    }
}

@Composable
fun DesignUrGardenHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(40.dp)
            .padding(horizontal = 16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        H1(
            text = "Design your home garden",
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp)

        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.Filled.FilterList,
            contentDescription = null,
            modifier = Modifier
                .requiredSize(24.dp)
                .align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun BrowseThemes() {
    H1(
        text = "Browse themes",
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp, bottom = 0.dp)
            .padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(8.dp))
    BrowseThemesItems(themes = themes)
}

@Composable
fun HomeHeader() {
    Spacer(
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth()
    )
    TextSearch(
        value = "Search",
        onValueChangeListener = { /*TODO*/ },
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
fun BrowseThemesItems(themes: List<Theme>) {

    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 8.dp),
//        modifier = Modifier.padding(top = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        themes.forEach {
            item {
                ThemesItem(theme = it)
            }
        }
    }
}

@Composable
fun ThemesItem(theme: Theme) {

    Surface(
        color = MaterialTheme.colors.surface, elevation = 1.dp,
        modifier = Modifier
            .padding(bottom = 16.dp)
            .size(136.dp)
            .clickable { },
        shape = MaterialTheme.shapes.small,
    ) {
        Column {
            Image(
                modifier = Modifier
                    .requiredHeight(96.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = theme.img),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(start = 16.dp)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart),
                    text = theme.title,
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h2
                )
            }
        }
    }
}
