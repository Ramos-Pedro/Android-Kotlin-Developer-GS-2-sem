package br.com.fiap.segundamesa.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.segundamesa.model.Categoria

/**
 * Lista horizontal de categorias com a opção "Todas".
 * Categoria selecionada nula = "Todas". O estado é controlado por quem chama (state hoisting).
 */
@Composable
fun CategoriaFiltro(
    categorias: List<Categoria>,
    selecionada: Categoria?,
    onSelecionar: (Categoria?) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            FilterChip(
                selected = selecionada == null,
                onClick = { onSelecionar(null) },
                label = { Text("Todas") },
                leadingIcon = if (selecionada == null) {
                    { Icon(Icons.Filled.Done, contentDescription = null, modifier = Modifier.size(18.dp)) }
                } else null
            )
        }
        items(categorias) { categoria ->
            FilterChip(
                selected = selecionada == categoria,
                onClick = { onSelecionar(categoria) },
                label = { Text(categoria.rotulo) },
                leadingIcon = {
                    Icon(
                        imageVector = categoria.icone,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
        }
    }
}
