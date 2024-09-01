package com.gabrielfranconascimen.firstaidandroidapp.presentation.firstaid.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gabrielfranconascimen.designsystem.base.Colors
import com.gabrielfranconascimen.designsystem.base.Dimens
import com.gabrielfranconascimen.designsystem.base.FATheme
import com.gabrielfranconascimen.designsystem.base.shimmerBackground
import com.gabrielfranconascimen.designsystem.components.buttons.FAButton
import com.gabrielfranconascimen.designsystem.components.cards.FACard
import com.gabrielfranconascimen.designsystem.components.texts.FAText
import com.gabrielfranconascimen.firstaidandroidapp.R

@Composable
fun FirstAidDetailScreen(
    title: String,
    firstAidDetails: List<FirstAidDetailStepScreenEntity>?,
    isLoading: Boolean,
    isError: Boolean,
    onErrorAction: () -> Unit
) {
    LazyColumn{
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Colors.illustrationColors.header)
            ) {
                FAText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Dimens.mediumPadding),
                    text = title,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color.White,
                    align = TextAlign.Center
                )
            }
        }

        when {
            isLoading ->  {
                items(3) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(76.dp)
                            .padding(
                                top = Dimens.mediumPadding,
                                start = Dimens.mediumPadding,
                                end = Dimens.mediumPadding
                            )
                            .shimmerBackground(),
                        content = { }
                    )
                }
            }
            isError -> {
                item { FirstAidDetailError(onErrorAction) }
            }
            firstAidDetails?.isNotEmpty() == true -> {
                items(firstAidDetails) { step ->
                    FACard(
                        modifier = Modifier.padding(
                            top = Dimens.mediumPadding,
                            start = Dimens.mediumPadding,
                            end = Dimens.mediumPadding
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(IntrinsicSize.Min),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            FAText(
                                modifier = Modifier
                                    .padding(end = Dimens.smallPadding),
                                text = step.step,
                                style = MaterialTheme.typography.headlineLarge
                            )
                            VerticalDivider(color = Colors.buttonText, thickness = Dimens.borderStroke)
                            FAText(
                                modifier = Modifier
                                    .padding(start = Dimens.smallPadding),
                                text = step.label
                            )
                        }
                    }
                }
            }
            else -> {
                item {
                    FirstAidDetailError(onErrorAction)
                }
            }
        }
    }
}

@Composable
private fun FirstAidDetailError(
    onErrorAction: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = Dimens.extraLargPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        FAText(text = stringResource(id = R.string.error_description))
        Spacer(modifier = Modifier.height(Dimens.largePadding))
        FAButton(onClick = onErrorAction) {
            FAText(text = stringResource(id = R.string.button_try_again))
        }
    }
}

data class FirstAidDetailScreenEntity(
    val title: String,
    val steps: List<FirstAidDetailStepScreenEntity>
)

data class FirstAidDetailStepScreenEntity(
    val step: String,
    val label: String
)

@Composable
@Preview
private fun FirstAidDetailScreenPreview() {
    FATheme {
        FirstAidDetailScreen(
            isError = false,
            isLoading = false,
            title = "Acidente",
            firstAidDetails = listOf(
                FirstAidDetailStepScreenEntity(
                    "1",
                    "Atendimento passo 1 Atendimento passo 1 Atendimento passo 1 Atendimento passo 1 Atendimento passo 1 Atendimento passo 1  Atendimento passo 1 Atendimento passo 1  Atendimento passo 1  Atendimento passo 1"
                ),
                FirstAidDetailStepScreenEntity(
                    "2",
                    "Atendimento passo 2"
                ),
                FirstAidDetailStepScreenEntity(
                    "3",
                    "Atendimento passo 3"
                )
            ),
            onErrorAction = { }
        )
    }
}