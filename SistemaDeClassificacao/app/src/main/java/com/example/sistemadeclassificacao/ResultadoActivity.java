package com.example.sistemadeclassificacao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * ResultadoActivity - Segunda tela da aplicação
 *
 * Exibe:
 * - Nome do jogo
 * - Imagem do jogo
 * - Nota recebida (em estrelas)
 * - Classificação textual (Regular, Bom, Ótimo, Excelente, Espetacular)
 * - Botão Voltar para retornar à MainActivity
 *
 * Exercício A2: Adiciona uma 6ª estrela e exibe a classificação selecionada
 * em uma segunda tela com todas as informações da votação.
 */
public class ResultadoActivity extends AppCompatActivity {

    private RatingBar rtbResultado;
    private TextView txtClassificacao;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Inicializar componentes
        rtbResultado = findViewById(R.id.rtbResultado);
        txtClassificacao = findViewById(R.id.txtClassificacao);
        btnVoltar = findViewById(R.id.btnVoltar);

        // Receber a classificação da MainActivity
        int rating = getIntent().getIntExtra("rating", 0);

        // Definir a nota na RatingBar (somente leitura)
        rtbResultado.setRating(rating);

        // Exibir a classificação textual
        String status = getStatusFromRating(rating);
        txtClassificacao.setText(status);

        // Definir a cor conforme a classificação
        int statusColor = getStatusColor(rating);
        txtClassificacao.setTextColor(statusColor);

        // Listener para o botão Voltar
        btnVoltar.setOnClickListener(v -> {
            finish(); // Retorna à MainActivity
        });
    }

    /**
     * Retorna o status em texto conforme o valor da classificação
     */
    private String getStatusFromRating(int rating) {
        switch (rating) {
            case 1:
                return "Regular";
            case 2:
                return "Bom";
            case 3:
                return "Ótimo";
            case 4:
                return "Excelente";
            case 5:
                return "Espetacular";
            default:
                return "Ruim";
        }
    }

    /**
     * Retorna a cor correspondente ao status
     */
    private int getStatusColor(int rating) {
        switch (rating) {
            case 1:
                return getResources().getColor(R.color.status_regular, null);
            case 2:
                return getResources().getColor(R.color.status_bom, null);
            case 3:
                return getResources().getColor(R.color.status_otimo, null);
            case 4:
                return getResources().getColor(R.color.status_excelente, null);
            case 5:
                return getResources().getColor(R.color.status_espetacular, null);
            default:
                return getResources().getColor(R.color.status_ruim, null);
        }
    }
}
