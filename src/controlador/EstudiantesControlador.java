
package controlador;

import conexion.Conexion;
import entidades.Carreras;
import entidades.Estudiantes;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class EstudiantesControlador {
    public void crear( Estudiantes e) {
        EntityManager en = entityManager();
        try {
            en.getTransaction().begin();//iniciar la trasnsacion
            en.persist(e);
            en.getTransaction().commit();//inserta la transsaciion   
        }catch (Exception ex) {
            en.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
    public void editar(Estudiantes e){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.merge(e);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception ex) {
            en.getTransaction().rollback();
        }
        
    }
       public void eliminar(Estudiantes e){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.remove(e);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception ex) {
            en.getTransaction().rollback();
        }
        
    }
    public List<Carreras> todosLosEstudiantes(){
        Query q=entityManager().createQuery("SELECT e FROM Estudiantes e");
        return q.getResultList();
    }
    public EntityManager entityManager() {
        return Conexion.getInstance().getPersona().createEntityManager();
//         return Conexion..getInstance().getPersona().createEntityManager();
    }
    
    
}
