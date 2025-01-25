import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class Desafio3 {
    public static void main(String[] args) {
        try {
            //obtém o arquivo JSON
            InputStream inputStream = Desafio3.class.getClassLoader().getResourceAsStream("dados.json");
            if (inputStream == null) {
                throw new IllegalArgumentException("Arquivo não encontrado!");
            }

            ObjectMapper mapper = new ObjectMapper();
            List<DadoFaturamento> faturamentoDiario = mapper.readValue(
                    inputStream,
                    new TypeReference<List<DadoFaturamento>>() {}
            );

            //filtra os dias com faturamento maior que zero
            List<Double> valoresValidos = faturamentoDiario.stream()
                    .map(DadoFaturamento::getValor)
                    .filter(valor -> valor > 0)
                    .collect(Collectors.toList());

            //calcula o menor, maior e média
            double menor = valoresValidos.stream().min(Double::compare).orElse(0.0);
            double maior = valoresValidos.stream().max(Double::compare).orElse(0.0);
            double media = valoresValidos.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

            //calcula o número de dias acima da média
            long diasAcimaMedia = valoresValidos.stream()
                    .filter(valor -> valor > media)
                    .count();

            //exibe os resultados
            System.out.printf("Menor faturamento diário: R$ %.2f%n", menor);
            System.out.printf("Maior faturamento diário: R$ %.2f%n", maior);
            System.out.printf("Dias com faturamento acima da média: %d%n", diasAcimaMedia);

        } catch (Exception e) {
            System.err.println("Erro ao processar o arquivo: " + e.getMessage());
        }
    }

    // classe auxiliar para mapear os dados do JSON
    static class DadoFaturamento {
        private int dia;
        private double valor;

        public int getDia() {
            return dia;
        }

        public void setDia(int dia) {
            this.dia = dia;
        }

        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }
    }
}
