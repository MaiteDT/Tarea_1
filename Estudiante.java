import java.io.Serializable; 
public class Estudiante implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String nombre;
    public String materia; 

    public Estudiante (String nombre, String materia) {
        this.nombre=nombre; 
        this.materia=materia;
    }

    /**
     * Regresa el nombre del estudiante.
     * @return el nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el nombre del estudiante.
     * @param nombre el nuevo nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa la materia a la que está inscrito.
     * @return la materia a la que está inscrito.
     */
    public String getMateria(){
        return materia;
    }

    /**
     * Define la materia a la que está inscrito.
     * @param materia la nueva materia a la que está inscrito.
     */
    public void setMateria(String materia){
        this.materia = materia;
    }

    @Override 
    public boolean equals(Object objeto) {
        if (!(objeto instanceof Estudiante) || objeto == null)
            return false;
        Estudiante est = (Estudiante)objeto;
        if(this.nombre.equals(est.nombre)){
            return true;
        }
        return false;
    }

    public String toString() {
        return "El nombre del estudiante es: " + nombre + " está incrito en la materia de: " + materia; 
    }

}