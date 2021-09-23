package com.example.catalogame;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GravarLer {
    private static final String TAG = "GravarLer";
    private Context context;

    public GravarLer(Context context){
        this.context = context;
    }

    /**
     * Escreve no arquivo texto.
     * @param text Texto a ser escrito.
     * @return True se o texto foi escrito com sucesso.
     */
    public boolean GravarArquivo(String text){
        try {
// Abre o arquivo para escrita ou cria se não existir
            FileOutputStream out = context.openFileOutput("romar.txt",
                    Context.MODE_APPEND);
            out.write(text.getBytes());
            out.write("\n".getBytes());
            out.flush();
            out.close();
            return true;

        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    /**
     * Faz a leitura do arquivo
     * @return O texto lido.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String LerArquivo() throws FileNotFoundException, IOException {
        File file = context.getFilesDir();
        File textfile = new File(file + "/favorito.txt");

        FileInputStream input = context.openFileInput("favorito.txt");
        byte[] buffer = new byte[(int)textfile.length()];

        input.read(buffer);

        return new String(buffer);
    }
}
