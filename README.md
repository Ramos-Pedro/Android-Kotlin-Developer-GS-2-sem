# Segunda Mesa — Global Solution CitizenTech (Android)

## Desenvolvedores

| RM | Nome completo                 |
|----|-------------------------------|
| 559513 | Pedro Ribeiro Ramos           |
| 560032 | Thiago Cardoso Mendes Machado |
| 558527 | Ana Julia Reis                |

## Tema da Global Solution

CitizenTech — tecnologia a serviço do cidadão. O app trata do **combate ao desperdício de alimentos**.

## Descrição da solução

O **Segunda Mesa** conecta comércios com excedente de alimentos (padarias, restaurantes, hortifrútis, mercados) a consumidores e, em fases posteriores da regra de logística, a ONGs e cozinhas comunitárias. Esta versão do app mobile mostra os lotes disponíveis na Zona Oeste de São Paulo, com preço reduzido e horário-limite de retirada no mesmo dia.

## Principais funcionalidades

- Lista vertical (`LazyColumn`) com os lotes disponíveis: nome, ícone, estabelecimento, bairro, horário-limite, preço com desconto e porções.
- Lista horizontal (`LazyRow`) de categorias com a opção **Todas**; a categoria selecionada fica destacada e a lista principal é atualizada automaticamente.
- Lista horizontal (`LazyRow`) de **destaques**, obtida a partir dos mesmos dados (atributo booleano `destaque`).
- Estado da categoria gerenciado com `remember` e `mutableStateOf`.

## Fluxo de telas

Tela única (`HomeScreen`): Destaques → Categorias (filtro) → Lotes disponíveis. Ao tocar em uma categoria, a lista de lotes é recomposta com o filtro aplicado.



## Fonte dos dados

Repositório em memória (`LoteRepository`), com dados fictícios de estabelecimentos. Não há banco de dados nem API nesta entrega.

## Arquitetura e packages

Pacote base: `br.com.fiap.segundamesa`

| Package | Responsabilidade |
|---------|------------------|
| `model` | `Lote` (data class) e `Categoria` (enum class) |
| `data` | `LoteRepository`: centraliza os lotes e as regras de filtragem |
| `ui.components` | Composables reutilizáveis: `LoteCard`, `CategoriaFiltro`, `DestaqueCard` e formatador de preço |
| `ui.screens` | `HomeScreen`: monta a tela com `Scaffold`, `TopAppBar` e as listas |
| `ui.theme` | Tema Material Design 3 |

A filtragem fica no repositório; os componentes apenas exibem os dados recebidos.

## Como executar

Abrir a pasta no Android Studio, aguardar o sync do Gradle e executar o módulo `app` (minSdk 24, Kotlin, Jetpack Compose, Material 3).
