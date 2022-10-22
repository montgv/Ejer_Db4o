import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ejer_Db4o {
    //Creamos una valiable de como se va a llamar la base de datos Db4o
    static String bdPracEmbebidas = "EMPLEDEP.yap";

    public static void main(String[] args) {
        //Creamos la base de datos Db4o
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), bdPracEmbebidas);

        //Creamos los objetos de tipo departamento
        Departamentos dep1 = new Departamentos(1, "Informatica", "Depart_1");
        Departamentos dep2 = new Departamentos(2, "Ventas", "Depart_2");
        Departamentos dep3 = new Departamentos(3, "Clientes", "Depart_3");

        //Creamos los objetos de tipo empleado
        Empleados emp1 = new Empleados(1, "Garcia", "Ventas", 1, "2022-01-15", 1200, 300, 2);
        Empleados emp2 = new Empleados(2, "Perez", "Clientes", 2, "2021-01-15", 1500, 350, 3);
        Empleados emp3 = new Empleados(3, "Mendez", "Informatica", 3, "2022-05-15", 1900, 350, 1);

        //Guardamos los objetos anteriones en la base de datos
        db.store(dep1);
        db.store(dep2);
        db.store(dep3);
        db.store(emp1);
        db.store(emp2);
        db.store(emp3);

        //Buscamos todos los empleados de un departamento concreto
        Empleados empleado = new Empleados(0, null, null, 0,null, 0, 0, 2);
        //Esta buscando en la base de datos los empleados
        ObjectSet<Empleados> resultado = db.queryByExample(empleado);

        //Si no hay empleados para esa busqueda, no existem registro, sino que imprima cuantos registros hay
        //y se hace un bucle while para que lea mientras que hay empleados e imprima el empleado donde se encuentra
        if (resultado.size() == 0) {
            System.out.println("No existen registros para esa consulta.");
        } else {
            System.out.println("El departamento tiene " + resultado.size() + " registros.");
            while (resultado.hasNext()) {
                Empleados empleadoBuscar = resultado.next();
                System.out.println(empleadoBuscar.toString());
            }
        }

        //Cerramos la base de datos para que se guarde
        db.close();
    }
}
