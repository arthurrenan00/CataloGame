package com.example.catalogame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Gravar extends AppCompatActivity {

    private Type tipo;
    private EditText editTexto;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravar);
        
        editTexto = (EditText) findViewById(R.id.editTextsalvar);
        tipo = (Type) getIntent().getSerializableExtra(Armazenamentos.STORAGE_TYPE);
    }
    
    public void fSalvar(View view){
        String texto = editTexto.getText().toString();
        String path;
        
        try{
            if (tipo == Type.INTERNAL){
                path = salvarInterno(texto);
            } else{
                path = salvarExterno(texto);
            }
            Toasr.makeText(this, "O arquivo foi salvo em" + path,Toast.LENGTH_SHORT).show();
            finish();
        } cath (IOException e){
            Toast.makeText(this, "Erro: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
    
    private String salvarInterno(String texto) throws IOException {
        FileOutputStream out = openFileOutput (Armazenamentos.FILE_NAME, MODE_PRIVATE);
        PrintWriter pw = new PrintWriter(out);
        
        try{
            pw.print(texto);
            return getFilesDir().getPath() + File.separator
                + Armazenamentos.FILE_NAME; 
        } finally {
            pw.close();
        } 
    }
    
    
    private String salvarExterno(String texto) throws IOException {
    
        String status = Environment.getExternalStorageState();
        
        if( !status.equals(Environment.MEDIA_MOUNTED)){
            throw new IOException("O Cartão SD não está inserido ou não disponível!");
        }
        
        File dir = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(dir, Armazenamentos.FILE_NAME);
        PrintWriter pw = new PrintWriter(file);
        
        try{
            pw.print(texto);
            return file.getPath();
        }finally {
            pq.close();
        }
    
    
    
    }
}
