import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class FaturamentoDetalhado {

    public static void main(String[] args) {
        
        // Valor de faturamento mensal por estado
        Map<String, Double> faturamentoPorEstado = new HashMap<String, Double>();
        faturamentoPorEstado.put("SP", 67836.43);
        faturamentoPorEstado.put("RJ", 36678.66);
        faturamentoPorEstado.put("MG", 29229.88);
        faturamentoPorEstado.put("ES", 27165.48);
        faturamentoPorEstado.put("Outros", 19849.53);
        
        // Cálculo do valor total mensal da distribuidora
        double valorTotal = 0;
        for (Double valor : faturamentoPorEstado.values()) {
            valorTotal += valor;
        }
        
        // Cálculo do percentual de representação de cada estado
        Map<String, Double> percentualPorEstado = new HashMap<String, Double>();
        DecimalFormat df = new DecimalFormat("#.##");
        for (String estado : faturamentoPorEstado.keySet()) {
            double percentual = faturamentoPorEstado.get(estado) / valorTotal * 100;
            percentualPorEstado.put(estado, Double.parseDouble(df.format(percentual)));
        }
        
        // Impressão do resultado
        System.out.println("Percentual de representação do faturamento mensal por estado:");
        for (String estado : percentualPorEstado.keySet()) {
            System.out.println(estado + ": " + percentualPorEstado.get(estado) + "%");
        }
    }
}
