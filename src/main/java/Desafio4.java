import java.util.HashMap;
import java.util.Map;

public class Desafio4 {
    public static void main(String[] args) {
        //valores de faturamento mensal por estado
        Map<String, Double> faturamentoEstados = new HashMap<>();
        faturamentoEstados.put("SP", 67836.43);
        faturamentoEstados.put("RJ", 36678.66);
        faturamentoEstados.put("MG", 29229.88);
        faturamentoEstados.put("ES", 27165.48);
        faturamentoEstados.put("Outros", 19849.53);

        //calcula o faturamento total
        double faturamentoTotal = 0.0;
        for (double valor : faturamentoEstados.values()) {
            faturamentoTotal += valor;
        }

        //calcula e exibe o percentual de cada estado
        System.out.println("Percentual de faturamento por estado:");
        for (Map.Entry<String, Double> entry : faturamentoEstados.entrySet()) {
            String estado = entry.getKey();
            double faturamento = entry.getValue();
            double percentual = (faturamento / faturamentoTotal) * 100;

            System.out.printf("%s: %.2f%%\n", estado, percentual);
        }
    }
}