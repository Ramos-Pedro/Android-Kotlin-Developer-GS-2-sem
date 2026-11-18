package br.com.fiap.segundamesa.data

import br.com.fiap.segundamesa.model.Categoria
import br.com.fiap.segundamesa.model.Lote

/**
 * Repositório em memória que centraliza os lotes usados pelo aplicativo.
 * Toda regra de filtragem fica aqui, separada da camada de apresentação.
 */
class LoteRepository {

    private val lotes: List<Lote> = listOf(
        Lote(
            id = 1,
            nome = "Cesta de pães do dia",
            estabelecimento = "Padaria Pão Quente",
            bairro = "Pinheiros",
            precoOriginal = 32.0,
            precoSegundaMesa = 12.9,
            porcoes = 8,
            horarioLimite = "20:00",
            categorias = listOf(Categoria.PADARIA),
            destaque = true
        ),
        Lote(
            id = 2,
            nome = "Marmitas executivas",
            estabelecimento = "Restaurante Sabor Caseiro",
            bairro = "Vila Madalena",
            precoOriginal = 28.0,
            precoSegundaMesa = 11.0,
            porcoes = 15,
            horarioLimite = "15:30",
            categorias = listOf(Categoria.REFEICOES),
            destaque = true
        ),
        Lote(
            id = 3,
            nome = "Caixa de frutas maduras",
            estabelecimento = "Hortifruti Raiz",
            bairro = "Lapa",
            precoOriginal = 24.0,
            precoSegundaMesa = 9.5,
            porcoes = 10,
            horarioLimite = "19:00",
            categorias = listOf(Categoria.HORTIFRUTI),
            destaque = true
        ),
        Lote(
            id = 4,
            nome = "Bolos e tortas do dia",
            estabelecimento = "Doceria Açúcar & Afeto",
            bairro = "Perdizes",
            precoOriginal = 45.0,
            precoSegundaMesa = 18.0,
            porcoes = 6,
            horarioLimite = "21:00",
            categorias = listOf(Categoria.CONFEITARIA, Categoria.PADARIA),
            destaque = false
        ),
        Lote(
            id = 5,
            nome = "Kit mercearia próxima ao vencimento",
            estabelecimento = "Mercadinho do Bairro",
            bairro = "Butantã",
            precoOriginal = 40.0,
            precoSegundaMesa = 15.0,
            porcoes = 12,
            horarioLimite = "18:00",
            categorias = listOf(Categoria.MERCEARIA),
            destaque = false
        ),
        Lote(
            id = 6,
            nome = "Sucos naturais do dia",
            estabelecimento = "Empório Verde",
            bairro = "Alto de Pinheiros",
            precoOriginal = 20.0,
            precoSegundaMesa = 8.0,
            porcoes = 20,
            horarioLimite = "17:30",
            categorias = listOf(Categoria.BEBIDAS, Categoria.HORTIFRUTI),
            destaque = false
        ),
        Lote(
            id = 7,
            nome = "Prato do dia com acompanhamentos",
            estabelecimento = "Cantina Nonna Lia",
            bairro = "Lapa",
            precoOriginal = 36.0,
            precoSegundaMesa = 14.0,
            porcoes = 9,
            horarioLimite = "22:00",
            categorias = listOf(Categoria.REFEICOES),
            destaque = false
        ),
        Lote(
            id = 8,
            nome = "Salgados assados",
            estabelecimento = "Padaria Pão Quente",
            bairro = "Pinheiros",
            precoOriginal = 22.0,
            precoSegundaMesa = 8.9,
            porcoes = 14,
            horarioLimite = "19:30",
            categorias = listOf(Categoria.PADARIA, Categoria.REFEICOES),
            destaque = false
        )
    )

    /** Retorna todos os lotes cadastrados. */
    fun listarTodos(): List<Lote> = lotes

    /** Retorna os lotes de uma categoria; categoria nula significa "Todas". */
    fun filtrarPorCategoria(categoria: Categoria?): List<Lote> =
        if (categoria == null) lotes else lotes.filter { categoria in it.categorias }

    /** Retorna os lotes marcados como destaque, a partir dos dados existentes. */
    fun listarDestaques(): List<Lote> = lotes.filter { it.destaque }
}
