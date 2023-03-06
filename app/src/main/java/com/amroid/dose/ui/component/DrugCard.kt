package com.amroid.dose.ui.component

import com.amroid.dose.data.model.DrugModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun DrugCard(
  drug: DrugModel,
  onClick: () -> Unit,
) {
  Card(
    shape = MaterialTheme.shapes.small,
    modifier = Modifier
      .padding(
        bottom = 6.dp,
        top = 6.dp,
      )
      .fillMaxWidth()
      .clickable(onClick = onClick),
    elevation = 8.dp,
  ) {

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
    ) {

      Text(
        text = drug.name,
        modifier = Modifier.align(Alignment.CenterHorizontally),

        style = MaterialTheme.typography.h4
      )
      Text(
        text = drug.dose,
        modifier = Modifier
          .align(Alignment.CenterHorizontally),
        style = MaterialTheme.typography.h6
      )
      Text(
        text = drug.strength,
        modifier = Modifier
          .align(Alignment.CenterHorizontally),
        style = MaterialTheme.typography.h6
      )

    }
  }
}


