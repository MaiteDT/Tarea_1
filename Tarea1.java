import java.util.Scanner;
import java.io.*;

public class Tarea1 {
    public static Lista<Estudiante> leeYCreaLista() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        Lista<Estudiante> listado = new Lista();

        try {
            Scanner sc = new Scanner(System.in);
            String nombreAr;
            System.out.println("Ingrese el nombre del archivo a leer");
            nombreAr = sc.nextLine();
            archivo = new File(nombreAr);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                String alumno = linea;
                alumno = alumno.substring(1, alumno.length() - 1);
                int indice = alumno.indexOf(",");
                String nombre = alumno.substring(0, indice).trim();
                String materia = alumno.substring(indice + 2, alumno.length()).trim();
                Estudiante nuevo = new Estudiante(nombre, materia);
                listado.agregar(nuevo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return listado;
    }

    /**
     * metodo que busca a un estudiante por su nombre y devuelve las materias a las
     * que está inscrito
     * 
     * @param lista de estudiantes donde se buscará
     */
    public static String busquedaNombre(Lista<Estudiante> lista) {
        String aBuscar;
        Lista<String> materias = new Lista();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre del estudiante que desea buscar");
        aBuscar = in.nextLine();
        for (Estudiante e : lista) {
            if (aBuscar.equals(e.getNombre())) {
                materias.agregar(e.getMateria());
            }
        }
        return materias.toString();
    }

    public static String busquedaMateria(Lista<Estudiante> lista) {
        String aBuscar;
        Lista<String> alumnos = new Lista();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la materia a buscar");
        aBuscar = in.nextLine();
        for (Estudiante e : lista) {
            if (aBuscar.equals(e.getMateria()))
                alumnos.agregar(e.getNombre());
        }
        return alumnos.toString();
    }

    /**
     * 
     * public static void serializaLista(Lista<Estudiante> lis) { FileWriter
     * escritor = null; Scanner in = new Scanner(System.in);
     * 
     * try { System.out.println("Introduce el nombre del nuevo archivo"); String
     * nombre = new String(); nombre = in.nextLine(); escritor = new
     * FileWriter(nombre); for (Estudiante e : lis) { escritor.write(e.toString() +
     * "\n" ); } } catch (IOException e) { System.out.println(e); } finally { try {
     * if (escritor != null) { escritor.close(); } } catch (IOException e) {
     * System.out.println(e); } } }
     * 
     * @param lis
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        Lista<Estudiante> lista = leeYCreaLista();
        // String salida;
        do {
            System.out.println("Elija una opción: ");
            System.out.println("1. Buscar por nombre del alumno para ver sus materias");
            System.out.println("2. Buscar por materia para ver los alumnos inscritos a ella");
            System.out.println("3. Salir");
            opcion = in.nextInt();
        } while (opcion != 1 && opcion != 2);
        switch (opcion) {
            case 1:
                String materias = busquedaNombre(lista);
                if (!materias.equals("[]")) {
                    System.out.println("Está inscrito en: " + materias);
                } else {
                    System.out.println("Alumno no encontrado");
                }
            case 2:
                String inscritos = busquedaMateria(lista);
                if (!inscritos.equals("[]")) {
                    System.out.println("Los alumnos incritos a la materia son: " + inscritos);
                } else {
                    System.out.println("Materia no encontrada");
                }
            case 3:
                break;
        }
    }
}