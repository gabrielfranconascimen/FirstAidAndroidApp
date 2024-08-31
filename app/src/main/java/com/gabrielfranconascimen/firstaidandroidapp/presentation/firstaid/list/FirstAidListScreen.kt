package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.components.buttons.FAButton
import com.gabrielfranconascimen.designsystem.components.cards.FACard
import com.gabrielfranconascimen.designsystem.components.dialogs.FADialogLoading
import com.gabrielfranconascimen.designsystem.components.texts.FAText
import com.gabrielfranconascimen.firstaidandroidapp.R

@Composable
fun FirstAidListScreen(
    content: List<FirstAidListScreenEntity>,
    onItemClicked: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(content) { item ->
            FACard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = Dimens.mediumPadding,
                        start = Dimens.mediumPadding,
                        end = Dimens.mediumPadding
                    ),
                onClick = { onItemClicked(item.detailId) }
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column (
                        modifier = Modifier.weight(1.0f)
                    ) {
                        FAText(
                            modifier = Modifier.fillMaxWidth(),
                            text = item.title
                        )
                        Spacer(modifier = Modifier.height(Dimens.smallPadding))
                        FAText(
                            modifier = Modifier.fillMaxWidth(),
                            text = item.description,
                            style = MaterialTheme.typography.labelSmall
                        )
                    }
                    Spacer(modifier = Modifier.width(Dimens.smallPadding))
                    Icon(
                        modifier = Modifier.size(Dimens.iconSize),
                        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                        contentDescription = stringResource(id = R.string.icon_arrow_right_description))
                }
            }
        }
    }
}

@Composable
fun FirstAidListScreenLoading() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        FADialogLoading()
    }
}

@Composable
fun FirstAidListScreenError(
    onErrorAction: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FAText(text = stringResource(id = R.string.error_description))
            Spacer(modifier = Modifier.height(Dimens.largePadding))
            FAButton(onClick = onErrorAction) {
                FAText(text = stringResource(id = R.string.button_try_again))
            }
        }
    }
}

data class FirstAidListScreenEntity(
    val title: String,
    val description: String,
    val detailId: String,
)

@Composable
@Preview(heightDp = 260)
private fun FirstAidListScreenPreview() {
    FATheme {
        FirstAidListScreen(
            content = listOf(
                FirstAidListScreenEntity(
                    detailId = "1",
                    title =  "Primeiro item",
                    description = "Descrição primeiro item"
                ),
                FirstAidListScreenEntity(
                    detailId = "2",
                    title =  "Segundo item",
                    description = "Descrição segundo item"
                ),
                FirstAidListScreenEntity(
                    detailId = "3",
                    title =  "Terceiro item",
                    description = "Descrição terceiro item"
                )
            ),
            onItemClicked = { }
        )
    }
}

@Composable
@Preview(heightDp = 260)
private fun FirstAidListScreenErrorPreview() {
    FATheme {
        FirstAidListScreenError {

        }
    }
}

@Composable
@Preview(heightDp = 260)
private fun FirstAidListScreenLoadingPreview() {
    FATheme {
        FirstAidListScreenLoading()
    }
}
