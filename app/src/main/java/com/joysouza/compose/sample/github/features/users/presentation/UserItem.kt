package com.joysouza.compose.sample.github.features.users.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.joysouza.compose.sample.github.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserItem(
    user: User,
    navigateToDetail: (String) -> Unit
) {
    Card(
        onClick = { navigateToDetail(user.login) },
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 4.dp)
            .semantics {
                contentDescription = "Info usuário"
                onClick(
                    label = "Toque duas vezes para acessar os detalhes do usuário",
                    action = null
                )
            },
    ) {
        CardContent(user)
    }
}

@Composable
fun CardContent(user: User) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .align(Alignment.CenterVertically),
                model = user.avatarUrl,
                placeholder = painterResource(id = R.drawable.avatar_placeholder),
                contentDescription = "Imagem do usuário",
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = user.login,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = user.htmlUrl,
                    style = MaterialTheme.typography.labelSmall
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(id = R.string.icon_favorites_description),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserItemPreview() {
    UserItem(
        User(
            login = "login",
            htmlUrl = "htmlUrl",
            avatarUrl = "avatarUrl"
        ),
        {}
    )
}
