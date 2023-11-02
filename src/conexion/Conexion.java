
package conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Conexion {
    private static Conexion instance = new Conexion(); // Cambiado a static para evitar recursión infinita
    private EntityManagerFactory persona;

    private Conexion() {
        persona = Persistence.createEntityManagerFactory("institutoJpaPU");
    }

    public static Conexion getInstance() { // Cambiado el nombre a getInstance para seguir el patrón Singleton
        return instance;
    }

    public EntityManagerFactory getPersona() {
        return persona;
    }  
     public EntityManager getEntityManager() {
        return persona.createEntityManager();
    }
    }

