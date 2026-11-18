package br.com.fiap.segundamesa.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Categorias dos lotes de alimentos com excedente.
 * A opção "Todas" é representada na interface por uma categoria nula (sem filtro).
 */
enum class Categoria(val rotulo: String, val icone: ImageVector) {
    PADARIA("Padaria", Icons.Filled.BakeryDining),
    REFEICOES("Refeições", Icons.Filled.Restaurant),
    HORTIFRUTI("Hortifrúti", Icons.Filled.Eco),
    CONFEITARIA("Confeitaria", Icons.Filled.Cake),
    MERCEARIA("Mercearia", Icons.Filled.ShoppingBasket),
    BEBIDAS("Bebidas", Icons.Filled.LocalDrink)
}
