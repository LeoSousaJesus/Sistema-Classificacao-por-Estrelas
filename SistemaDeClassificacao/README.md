# Sistema de Classificação — Aula 6 Desenvolvimento Mobile Android

Aplicação Android que implementa um sistema de classificação de jogos usando **RatingBar**, **AlertDialog** e navegação entre duas Activities, conforme descrito na **Aula 6 de Desenvolvimento Mobile**.

## Características

- **MainActivity**: Exibe a imagem do jogo (Angry Birds), um RatingBar com 5 estrelas (stepSize=1), e um status dinâmico que muda conforme a classificação selecionada.
- **AlertDialog**: Ao selecionar uma nota, um dialog exibe a classificação com um botão OK.
- **ResultadoActivity**: Segunda tela que exibe o nome do jogo, a imagem, a nota recebida em estrelas e a classificação textual.
- **Classificações**: Ruim, Regular, Bom, Ótimo, Excelente, Espetacular (exercício A2 com 5 estrelas).

## Estrutura do Projeto

```
SistemaDeClassificacao/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/sistemadeclassificacao/
│   │   │   │   ├── MainActivity.java
│   │   │   │   └── ResultadoActivity.java
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   └── activity_resultado.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── drawable/
│   │   │   │       └── jogo_angry_birds.png
│   │   │   └── AndroidManifest.xml
│   │   ├── test/
│   │   └── androidTest/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md
```

## Requisitos

- **Android Studio** (versão 2021.1 ou superior)
- **JDK 11** ou superior
- **Android SDK** com API 21 (Android 5.0) ou superior
- **Gradle** 8.1.0

## Como Abrir no Android Studio

1. **Clone ou extraia o projeto**:
   ```bash
   unzip SistemaDeClassificacao.zip
   cd SistemaDeClassificacao
   ```

2. **Abra no Android Studio**:
   - Abra o Android Studio
   - Clique em "Open" e selecione a pasta `SistemaDeClassificacao`
   - Aguarde o Gradle sincronizar

3. **Execute a aplicação**:
   - Conecte um dispositivo Android ou inicie um emulador
   - Clique em "Run" (ou pressione Shift+F10)

## Código Principal

### MainActivity.java

```java
public class MainActivity extends AppCompatActivity {
    private TextView txtstatus;
    private RatingBar rtbvotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtstatus = findViewById(R.id.txtstatus);
        rtbvotacao = findViewById(R.id.rtbvotacao);

        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    String status = getStatusFromRating((int) rating);
                    txtstatus.setText("Status: " + status);
                    showClassificationDialog(status, (int) rating);
                }
            }
        });
    }
}
```

### Classificações

| Rating | Status |
|--------|--------|
| 1 | Regular |
| 2 | Bom |
| 3 | Ótimo |
| 4 | Excelente |
| 5 | Espetacular |

## Configurações do Projeto

- **Namespace**: `com.example.sistemadeclassificacao`
- **Min SDK**: API 21 (Android 5.0)
- **Target SDK**: API 33 (Android 13)
- **Compile SDK**: API 33
- **Java Version**: 11

## Dependências

- `androidx.appcompat:appcompat:1.6.1`
- `androidx.constraintlayout:constraintlayout:2.1.4`
- `com.google.android.material:material:1.9.0`

## Notas Importantes

1. **Imagem do jogo**: Você precisará adicionar a imagem `jogo_angry_birds.png` na pasta `app/src/main/res/drawable/`. Pode usar qualquer imagem do Angry Birds ou substituir por outra.

2. **Tema**: A aplicação usa o tema `Theme.AppCompat.Light` com a cor primária verde (#388E3C), conforme o padrão Android da época da aula.

3. **AlertDialog**: O dialog aparece automaticamente ao selecionar uma nota, e ao clicar em "OK", navega para a `ResultadoActivity`.

## Exercício A2

A aplicação já implementa o exercício valendo 4 pontos na A2:
- ✅ Adiciona uma 6ª estrela (5 estrelas totais com stepSize=1)
- ✅ Mostra uma mensagem da classificação selecionada no AlertDialog
- ✅ Após clicar em OK, chama outra tela (ResultadoActivity)
- ✅ Exibe o nome do jogo, imagem e nota recebida

## Autor

Prof. João Paulo Pimentel  
Aula 6 — Construindo aplicações no Android

## Licença

MIT
