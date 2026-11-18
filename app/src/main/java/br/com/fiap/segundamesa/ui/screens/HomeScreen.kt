package br.com.fiap.segundamesa.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.fiap.segundamesa.data.LoteRepository
import br.com.fiap.segundamesa.model.Categoria
import br.com.fiap.segundamesa.ui.components.CategoriaFiltro
import br.com.fiap.segundamesa.ui.components.DestaqueCard
import br.com.fiap.segundamesa.ui.components.LoteCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    repositorio: LoteRepository = remember { LoteRepository() }
) {
    // Estado da categoria selecionada (null = "Todas")
    var categoriaSelecionada by remember { mutableStateOf<Categoria?>(null) }

    // Dados obtidos do repositório; a filtragem não é feita na interface
    val destaques = remember { repositorio.listarDestaques() }
    val lotes = repositorio.filtrarPorCategoria(categoriaSelecionada)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Filled.Eco,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Segunda Mesa")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
                    Text(
                        text = "Comida boa ganha uma segunda mesa",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Lotes de excedente de comércios da Zona Oeste de São Paulo, " +
                            "com retirada no mesmo dia.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            item { SecaoTitulo("Destaques") }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(destaques, key = { it.id }) { lote ->
                        DestaqueCard(lote = lote)
                    }
                }
            }

            item { SecaoTitulo("Categorias") }
            item {
                CategoriaFiltro(
                    categorias = Categoria.entries,
                    selecionada = categoriaSelecionada,
                    onSelecionar = { categoriaSelecionada = it }
                )
            }

            item { SecaoTitulo("Lotes disponíveis") }
            if (lotes.isEmpty()) {
                item {
                    Text(
                        text = "Nenhum lote nesta categoria no momento.",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            } else {
                items(lotes, key = { it.id }) { lote ->
                    LoteCard(
                        lote = lote,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun SecaoTitulo(texto: String) {
    Text(
        text = texto,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    )
}
