package com.example.sistemadeclassificacao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity - Aula 6: Construindo aplicações no Android
 * Sistema de Classificação de Jogos
 *
 * Componentes utilizados:
 * - TextView: exibe "Avalie o jogo abaixo:" e "Deixe seu voto:"
 * - ImageView: exibe a imagem do jogo (Angry Birds)
 * - RatingBar: permite ao usuário selecionar de 1 a 5 estrelas (stepSize=1)
 * - TextView (txtstatus): exibe o status conforme a classificação
 * - AlertDialog: mostra a classificação selecionada com botão OK
 *
 * Lógica:
 * rating == 1 → "Status: Regular"
 * rating == 2 → "Status: Bom"
 * rating == 3 → "Status: Ótimo"
 * rating == 4 → "Status: Excelente"
 * rating == 5 → "Status: Espetacular" (exercício A2)
 * padrão → "Status: Ruim"
 */
public class MainActivity extends AppCompatActivity {

    private TextView txtstatus;
    private RatingBar rtbvotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar componentes
        txtstatus = findViewById(R.id.txtstatus);
        rtbvotacao = findViewById(R.id.rtbvotacao);

        // Definir status inicial
        txtstatus.setText("Status: Ruim");

        // Listener para mudanças na RatingBar
        rtbvotacao.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                if (fromUser) {
                    // Atualizar status conforme a classificação
                    String status = getStatusFromRating((int) rating);
                    txtstatus.setText("Status: " + status);

                    // Atualizar cor do status
                    int statusColor = getStatusColor((int) rating);
                    txtstatus.setTextColor(statusColor);

                    // Mostrar AlertDialog
                    showClassificationDialog(status, (int) rating);
                }
            }
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

    /**
     * Exibe um AlertDialog com a classificação selecionada
     * Ao clicar em OK, navega para ResultadoActivity
     */
    private void showClassificationDialog(String status, int rating) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(status)
                .setMessage("Status: " + status)
                .setPositiveButton("OK", (dialog, which) -> {
                    // Navegar para ResultadoActivity
                    Intent intent = new Intent(MainActivity.this, ResultadoActivity.class);
                    intent.putExtra("rating", rating);
                    startActivity(intent);
                })
                .show();
    }
}
