package com.prueba.automatizacion.tcs.utilities;

public class ExtractData {

    public static String CiclosInciales(String texto){
        String ciniciales = texto.substring(30,32);
    return ciniciales;
    }

    public static String Coordenada(String texto, int numerovalores){
        int tamaño = texto.length();
        int datocol;
        int sumacol=0;
        int datofil;
        int sumafil=0;
        double coordena;
        double tamañomatriz=0;

        for (int i=0; i<tamaño; i++){
            if(texto.substring(i,i+1).equals("(")){
                for (int j= i; j<=i+4;j++){
                    if(texto.substring(j,j+1).equals(",")){
                        datocol=Integer.parseInt(texto.substring(i+1,j));
                        sumacol=sumacol+datocol;
                    }
                    if (j==tamaño-1){
                        j=100;
                    }
                }
            }
        }

        for (int i=0; i<tamaño; i++){
            if(texto.substring(i,i+1).equals(",")){
                for (int j= i; j<=i+4;j++){
                    if(texto.substring(j,j+1).equals(")")){
                        datofil=Integer.parseInt(texto.substring(i+1,j));
                        sumafil=sumafil+datofil;
                    }
                    if (j==tamaño-1){
                        j=100;
                    }
                }
            }
        }

        tamañomatriz = Math.sqrt(numerovalores);
        coordena = ((sumacol+1)+(tamañomatriz*sumafil));
        return Double.toString(coordena);
    }

    public static String NumeroFila(String texto){
        int tamaño = texto.length();
        int datofil;
        int sumafil=0;

        for (int i=0; i<tamaño; i++){
            if(texto.substring(i,i+1).equals(",")){
                for (int j= i; j<=i+4;j++){
                    if(texto.substring(j,j+1).equals(")")){
                        datofil=Integer.parseInt(texto.substring(i+1,j));
                        sumafil=sumafil+datofil;
                    }
                    if (j==tamaño-1){
                        j=100;
                    }
                }
            }
        }

        return Integer.toString(sumafil);
    }

    public static String CicloActual(String texto){
        int tamaño = texto.length();
        String dato="";

        for (int i=0; i<tamaño; i++){
            if(texto.substring(i,i+1).equals("o")){
                for (int j= i; j<=i+4;j++){
                    if(texto.substring(j,j+1).equals("d")){
                        dato=texto.substring(i+2,j-1);
                    }
                    if (j==tamaño-1){
                        j=100;
                    }
                }
            }
        }

        return dato;
    }

    public static int TamañoMatriz(int numerovalores) {
        int tamañomatriz = 0;
        tamañomatriz = (int) Math.sqrt(numerovalores);
        return tamañomatriz;
    }


}
