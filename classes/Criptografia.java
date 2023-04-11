package classes; //Pacote classes

import java.io.*;

//Classe Criptografia
public class Criptografia {

    // Metodo boolean, retorna verdadeiro caso consiga sucesso na operacao
    public static boolean encrypt(String origem) {

        // Condicao para verificar se o arquivo existe
        if (!new File(origem).exists()) {
            return false;
        }

        // Nome temporario do arquivo
        String fileTemp = origem + ".tmp";

        // Tratamento de excecao
        try {

            // Objeto fileOrigem / fileDestino / arquivo temporario
            File fileOrigem = new File(origem);
            File fileDestino = new File(fileTemp);

            // Arquivo de entrada em modo binario e saida
            FileInputStream entrada = new FileInputStream(fileOrigem);
            FileOutputStream saida = new FileOutputStream(fileDestino);

            // Leitura do arquivo de entrada e saida
            BufferedInputStream in = new BufferedInputStream(entrada);
            BufferedOutputStream out = new BufferedOutputStream(saida);

            // Guarda os bytes
            int x;
            while ((x = in.read()) != -1) {
                out.write(x + 5);
            }

            // Fecha o arquivo
            in.close();
            out.close();

            // Deleta o arquivo de origem e renomeia o arquivo temporario
            fileOrigem.delete();
            new File(fileTemp).renameTo(new File(origem));

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    // Metodo para descriptografar o arquivo
    public static boolean decrypt(String origem) {

        if (!new File(origem).exists()) {
            return false;
        }

        String fileTemp = origem + ".tmp";

        try {

            File fileOrigem = new File(origem);
            File fileDestino = new File(fileTemp);

            FileInputStream entrada = new FileInputStream(fileOrigem);
            FileOutputStream saida = new FileOutputStream(fileDestino);

            BufferedInputStream in = new BufferedInputStream(entrada);
            BufferedOutputStream out = new BufferedOutputStream(saida);

            int x;
            while ((x = in.read()) != -1) {
                out.write(x - 5);
            }

            in.close();
            out.close();

            fileOrigem.delete();
            new File(fileTemp).renameTo(new File(origem));

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}