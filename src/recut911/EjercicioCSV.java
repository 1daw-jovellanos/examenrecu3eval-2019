package recut911;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjercicioCSV {

    public int procesaTransac() {
        int resultado = 0;
        boolean lecturaOk = true;
        int numeroLinea = 0;

        try (PrintWriter ficheroSalida = new PrintWriter(
                new BufferedWriter(
                        new PrintWriter("transac_no_validas.txt")
                )
        );
                Scanner ficheroEntrada = new Scanner(new BufferedReader(
                        new FileReader("transac.txt")
                ))) {
            while (ficheroEntrada.hasNextLine()) {
                String linea = ficheroEntrada.nextLine();
                numeroLinea++;
                //--- empieza el proceso de la linea
                String[] trozos = linea.split(",");
                String iban1 = trozos[0].trim();
                String iban2 = trozos[1].trim();
                double importe = Double.parseDouble(trozos[2].trim());
                if (importe < 0.0001 || !iban1.matches("[A-Za-z]{2}([0-9]| )*") || !iban2.matches("[A-Za-z]{2}([0-9]| )*") ) {
                    ficheroSalida.println(numeroLinea);
                    resultado = 1;
                }
                //--- termina el proceso de la linea
            }

        } catch (Exception ex) {
            System.out.println("Existe algun error con el proceso de escritura");
            resultado = -1;
        }
        return resultado;
    }

}
