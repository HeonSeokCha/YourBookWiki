package com.chs.yourbookwiki.book.presnetation.book_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cmp_book.composeapp.generated.resources.Res
import cmp_book.composeapp.generated.resources.description_unavailable
import cmp_book.composeapp.generated.resources.languages
import cmp_book.composeapp.generated.resources.pages
import cmp_book.composeapp.generated.resources.rating
import cmp_book.composeapp.generated.resources.synopsis
import com.chs.yourbookwiki.book.presnetation.book_detail.components.BlurredImageBackground
import com.chs.yourbookwiki.book.presnetation.book_detail.components.BookChip
import com.chs.yourbookwiki.book.presnetation.book_detail.components.ChipSize
import com.chs.yourbookwiki.book.presnetation.book_detail.components.TitledContent
import com.chs.yourbookwiki.core.presentation.SandYellow
import org.jetbrains.compose.resources.stringResource
import kotlin.math.round

@Composable
fun BookDetailScreenRoot(
    viewModel: BookDetailViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    BookDetailScreen(
        state = state,
        onAction = { action ->
            when (action) {
                is BookDetailAction.OnBackClick -> onBackClick()
                else -> Unit
            }

            viewModel.onAction(action)
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BookDetailScreen(
    state: BookDetailState,
    onAction: (BookDetailAction) -> Unit
) {
    BlurredImageBackground(
        imageUrl = state.bookInfo?.imageUrl,
        isFavorite = state.isFavorite,
        onFavoriteClick = {
            onAction(BookDetailAction.OnFavoriteClick)
        },
        onBackClick = {
            onAction(BookDetailAction.OnBackClick)
        },
        modifier = Modifier.fillMaxSize()
    ) {
        if (state.bookInfo != null) {
            Column(
                modifier = Modifier
                    .widthIn(max = 700.dp)
                    .fillMaxWidth()
                    .padding(
                        vertical = 16.dp,
                        horizontal = 24.dp
                    )
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.bookInfo.title,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )


                Text(
                    text = state.bookInfo.authors.joinToString(),
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )

                Row(
                    modifier = Modifier
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    state.bookInfo.averageRating?.let {
                        TitledContent(
                            title = stringResource(Res.string.rating),
                        ) {
                            BookChip {
                                Text(
                                    text = "${round(it * 10) / 10.0}"
                                )

                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = SandYellow
                                )
                            }
                        }
                    }


                    state.bookInfo.numPages?.let {
                        TitledContent(
                            title = stringResource(Res.string.pages),
                        ) {
                            BookChip {
                                Text(
                                    text = it.toString()
                                )
                            }
                        }
                    }
                }

                if (state.bookInfo.languages.isNotEmpty()) {
                    TitledContent(
                        title = stringResource(Res.string.languages),
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    ) {
                        FlowRow(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.wrapContentSize(Alignment.Center)
                        ) {
                            state.bookInfo.languages.forEach { lang ->
                                BookChip(
                                    size = ChipSize.SMALL,
                                    modifier = Modifier.padding(2.dp)

                                ) {
                                    Text(
                                        text = lang.uppercase(),
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                }
                            }
                        }
                    }
                }

                Text(
                    text = stringResource(Res.string.synopsis),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(
                            top = 24.dp,
                            bottom = 8.dp
                        )
                )

                if (state.isLoading) {
                    CircularProgressIndicator()
                    Box(
                       modifier = Modifier
                           .fillMaxWidth()
                           .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                    }
                } else {
                    Text(
                        text = if (state.bookInfo.description.isNullOrBlank()) {
                            stringResource(Res.string.description_unavailable)
                        } else {
                            state.bookInfo.description
                        },
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Justify,
                        color = if (state.bookInfo.description.isNullOrBlank()) {
                            Color.Black.copy(alpha = 0.4f)
                        } else Color.Black,
                        modifier = Modifier
                            .padding(vertical = 8.dp)
                    )
                }
            }
        }
    }
}