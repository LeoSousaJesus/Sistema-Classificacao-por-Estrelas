# Sistema de Classificação de Jogos

Aplicação Android desenvolvida para avaliação (Aula 6), com o objetivo de implementar um sistema de classificação utilizando componentes nativos do Android como `RatingBar`, `AlertDialog` e navegação entre `Activities`.

## Detalhes da Aplicação

O aplicativo consiste em um sistema de votação para jogos, contendo as seguintes funcionalidades:
- **MainActivity**: Tela principal que exibe a imagem de um jogo (ex: Angry Birds) e permite que o usuário avalie o jogo selecionando de 1 a 5 estrelas no `RatingBar`. O status em texto (Ruim, Regular, Bom, Ótimo, Excelente, Espetacular) exibido na tela é atualizado e colorido dinamicamente de acordo com a nota selecionada.
- **Interatividade com AlertDialog**: Ao selecionar uma nota, a aplicação exibe um alerta de confirmação (`AlertDialog`) apresentando o status da avaliação.
- **ResultadoActivity**: Segunda tela da aplicação, acessada após a confirmação no `AlertDialog`. Apresenta um resumo da avaliação contendo o nome do jogo, a imagem, a nota recebida visualmente em estrelas (modo apenas leitura) e o status textual correspondente. Permite também voltar à tela inicial.

### Regras de Classificação

O sistema classifica o jogo de acordo com as estrelas escolhidas (Step Size = 1):
- **1 Estrela**: Regular
- **2 Estrelas**: Bom
- **3 Estrelas**: Ótimo
- **4 Estrelas**: Excelente
- **5 Estrelas**: Espetacular

*(Valores padrão ou 0 estrelas são interpretados como "Ruim")*

## Tecnologias Utilizadas

- **Java 11**: Linguagem de programação principal utilizada na lógica da aplicação.
- **Android SDK**: API 21 (Min SDK - Android 5.0) até API 33 (Target SDK - Android 13).
- **Gradle 8.1.0**: Sistema e ferramenta de automação de build.
- **XML**: Linguagem de marcação utilizada para a construção dos layouts das interfaces (`activity_main.xml` e `activity_resultado.xml`).
- **Componentes Nativos do Android**:
  - `RatingBar`: Para a captura (na tela principal) e exibição (na tela de resultados) da nota em formato de estrelas.
  - `AlertDialog`: Para mensagens em pop-up validando a classificação escolhida.
  - `Intent`: Para navegação e passagem de parâmetros (ex: valor do *rating*) entre as Activities.
  - `ImageView`, `TextView`, `Button`, `LinearLayout`, `RelativeLayout`: Para estruturação visual do App.
- **Bibliotecas AndroidX & Material Design**: Utilizadas para garantir retrocompatibilidade e oferecer suporte a componentes visuais modernos (`androidx.appcompat`, `androidx.constraintlayout`, `com.google.android.material`).

## Telas de Exemplo (Aplicação de Avaliação)

Abaixo estão as representações das telas que compõem o fluxo do aplicativo durante a avaliação:

### 1. Tela Principal de Avaliação (`MainActivity`)
Nesta tela o usuário pode visualizar a capa do jogo e atribuir a sua nota, clicando diretamente nas estrelas. O status da avaliação na parte inferior se altera dependendo de qual estrela for preenchida.

![Tela Principal](https://via.placeholder.com/300x500.png?text=Tela+Principal+-+MainActivity)

### 2. Confirmação da Avaliação (`AlertDialog`)
Logo após clicar em uma estrela, o aplicativo emite um alerta nativo listando a avaliação escolhida, bloqueando o fundo até a leitura.

![Alerta de Confirmação](https://via.placeholder.com/300x500.png?text=Alerta+de+Confirmacao+-+AlertDialog)

### 3. Tela de Resultado (`ResultadoActivity`)
Tela final alcançada após clicar em "OK" no alerta anterior, mostrando o resumo detalhado: a nota (RatingBar bloqueado para leitura) e o respectivo status escrito em destaque. O botão na parte inferior permite voltar e avaliar novamente.

![Tela de Resultado](https://via.placeholder.com/300x500.png?text=Tela+de+Resultado+-+ResultadoActivity)

---
*Observação: As imagens apresentadas acima são marcadores de posição (placeholders). Para visualizar as telas reais, execute o projeto no Android Studio utilizando um emulador ou dispositivo físico.*
