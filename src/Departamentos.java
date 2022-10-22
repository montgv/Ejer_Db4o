//Creamos la clase departamentos
public class Departamentos {
    //Declaramos los diferentes atributos que tiene esta clase
    private int dept_no;
    private String dNombre;
    private String loc;

    //Creamos el constructor con todos sus atributos
    public Departamentos(int dept_no, String dNombre, String loc) {
        this.dept_no = dept_no;
        this.dNombre = dNombre;
        this.loc = loc;
    }
    //Creamos el constructor vacio
    public Departamentos() {
    }

    //Creamos todos los getter y setter de todos los atributos
    public int getDept_no() {
        return dept_no;
    }
    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getdNombre() {
        return dNombre;
    }
    public void setdNombre(String dNombre) {
        this.dNombre = dNombre;
    }

    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }
}
