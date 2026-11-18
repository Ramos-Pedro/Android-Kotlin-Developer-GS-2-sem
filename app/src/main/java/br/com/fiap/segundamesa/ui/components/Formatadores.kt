package br.com.fiap.segundamesa.ui.components

import java.util.Locale

private val LocalePtBr = Locale("pt", "BR")

/** Formata um valor em reais, por exemplo: R$ 12,90. */
fun formatarPreco(valor: Double): String =
    String.format(LocalePtBr, "R$ %.2f", valor)
