import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombreDirectorio;
        String nombreArchivo;
        String texto;
        System.out.println("Ingrese un nombre divertido para crear un directorio");
        nombreDirectorio = sc.next();
        System.out.println("Ingrese el nombre de su mascota para crear un archivo .txt, (si no tiene no importa, invente una)");
        nombreArchivo = sc.next();
        System.out.println("Ingrese el texto que desea buscar");
        texto = sc.next();
        crearArchivo(nombreDirectorio,nombreArchivo);
        buscarTexto(nombreDirectorio,nombreArchivo,texto);
    }
    public static void crearArchivo(String nombreDirectorio, String nombreArchivo) {

        File directorio = new File("src/"+nombreDirectorio);
        File archivo = new File("src/"+nombreDirectorio+"/"+nombreArchivo+".txt");

        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
                try {
                    archivo.createNewFile();
                    FileWriter fileW = new FileWriter(archivo);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileW);
                    ArrayList<String> lista = new ArrayList<String>();
                    lista.add("Perro");
                    lista.add("Gato");
                    lista.add("Juan");
                    lista.add("Daniel");
                    lista.add("Juan");
                    lista.add("Gato");
                    lista.add("Perro");
                    lista.add("Camila");
                    lista.add("Daniel");
                    lista.add("Camila");
                    for (Iterator iterator = lista.iterator(); iterator.hasNext();) {

                        String elemento = (String) iterator.next();

                        bufferedWriter.write(elemento);
                        bufferedWriter.newLine();
                    }


                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.printf("Error al crear el directorio %s",nombreDirectorio);
                }
            } else {
                System.out.println("Error al crear directorio");
            }
        } else {
            System.out.println("Directorio ya esta creado");

        }
    }

    public static void buscarTexto(String nombreDirectorio,String nombreArchivo,String texto) {

            File archivo = new File("src/"+nombreDirectorio+"/"+nombreArchivo+".txt");

        if (!archivo.exists()) {
            System.out.println("El archivo ingresado no existe");
            return;
        }

        int contador = 0;

        try  {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                int index = 0;
                while ((index = linea.indexOf(texto, index)) != -1) {
                    contador++;
                    index += texto.length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Cantidad de repeticiones del texto -> %d", contador);
    }

}