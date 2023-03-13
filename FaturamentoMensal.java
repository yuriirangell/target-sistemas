import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FaturamentoMensal {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        ArrayList<Double> faturamento = new ArrayList<Double>();
        int dias_com_faturamento_acima_da_media = 0;
        
        try {
            // Lê o arquivo JSON com os valores de faturamento diário
            Object obj = parser.parse(new FileReader("faturamento.json"));
            JSONObject json = (JSONObject) obj;
            
            // Calcula o menor e o maior valor de faturamento ocorrido em um dia do mês
            for (Object valor : json.values()) {
                double valor_double = (Double) valor;
                faturamento.add(valor_double);
            }
            double menor_valor = Collections.min(faturamento);
            double maior_valor = Collections.max(faturamento);
            
            // Calcula a média mensal de faturamento, desconsiderando dias sem faturamento
            double soma_faturamento = 0.0;
            int dias_com_faturamento = 0;
            for (Object valor : json.values()) {
                double valor_double = (Double) valor;
                if (valor_double > 0.0) {
                    soma_faturamento += valor_double;
                    dias_com_faturamento += 1;
                }
            }
            double media_mensal = soma_faturamento / dias_com_faturamento;
            
            // Conta o número de dias em que o valor de faturamento diário foi superior à média mensal
            for (Object valor : json.values()) {
                double valor_double = (Double) valor;
                if (valor_double > media_mensal) {
                    dias_com_faturamento_acima_da_media += 1;
                }
            }
            
            // Exibe os resultados
            System.out.println("Menor valor de faturamento diário: R$" + menor_valor);
            System.out.println("Maior valor de faturamento diário: R$" + maior_valor);
            System.out.println("Número de dias com faturamento acima da média mensal: " + dias_com_faturamento_acima_da_media);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
