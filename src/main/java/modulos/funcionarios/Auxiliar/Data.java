package modulos.funcionarios.Auxiliar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Data {
    public static boolean validarData(String dataString, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);
        sdf.setLenient(false); // Define o modo rigoroso para a análise da data

        try {
            sdf.parse(dataString); // Tenta analisar a data
            return true; // Se a data for válida, retorna verdadeiro
        } catch (ParseException e) {
            return false; // Se houver erro na análise, retorna falso
        }
    }

    public static Date converterStringParaDate(String dataString, String formato) {
        SimpleDateFormat sdf = new SimpleDateFormat(formato);

        try {
            return sdf.parse(dataString); // Converte a string para um objeto Date
        } catch (ParseException e) {
            e.printStackTrace(); // Trata exceções de análise de data
            return null; // Retorna null em caso de erro
        }
    }
}
