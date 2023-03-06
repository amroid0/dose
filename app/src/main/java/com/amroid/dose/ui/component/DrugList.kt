package com.amroid.dose.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.amroid.dose.data.model.DrugModel
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun DrugList(
    loading: Boolean,
    drugs: List<DrugModel>,
    onNavigateToDrugDetailScreen: (DrugModel) -> Unit,
){
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && drugs.isEmpty()) {
            LoadingRecipeListShimmer()
        }
        else if(drugs.isEmpty()){
            EmptyView()
        }
        else {
            LazyColumn{
                itemsIndexed(
                    items = drugs
                ) { index, drug ->

                    DrugCard(
                        drug = drug,
                        onClick = { onNavigateToDrugDetailScreen(drug)
                        }
                    )
                }
            }
        }
    }
}







