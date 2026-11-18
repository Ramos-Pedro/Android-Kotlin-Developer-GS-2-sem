package br.com.fiap.segundamesa.model

/**
 * Lote de alimentos excedentes disponibilizado por um comércio parceiro.
 *
 * @property categorias um lote pode pertencer a uma ou mais categorias
 * @property destaque indica se o lote aparece na seção de destaques
 */
data class Lote(
    val id: Int,
    val nome: String,
    val estabelecimento: String,
    val bairro: String,
    val precoOriginal: Double,
    val precoSegundaMesa: Double,
    val porcoes: Int,
    val horarioLimite: String,
    val categorias: List<Categoria>,
    val destaque: Boolean
) {
    /** Categoria principal, usada para escolher o ícone do lote. */
    val categoriaPrincipal: Categoria
        get() = categorias.first()
}
