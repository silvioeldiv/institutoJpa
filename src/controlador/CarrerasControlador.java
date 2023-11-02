
package controlador;

import conexion.Conexion;
import entidades.Carreras;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class CarrerasControlador {
    public void crear( Carreras c) {
        EntityManager en = entityManager();
        try {
            en.getTransaction().begin();//iniciar la trasnsacion
            en.persist(c);
            en.getTransaction().commit();//inserta la transsaciion   
        }catch (Exception e) {
            en.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void editar(Carreras c){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.merge(c);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception e) {
            en.getTransaction().rollback();
        }
        
    }
       public void eliminar(Carreras c){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.remove(c);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception e) {
            en.getTransaction().rollback();
        }
        
    }
    public List<Carreras> todosLosCarreras(){
        Query q=entityManager().createQuery("SELECT c FROM Carreras c");
        return q.getResultList();
    }
    public EntityManager entityManager() {
        return Conexion.getInstance().getPersona().createEntityManager();
//         return Conexion..getInstance().getPersona().createEntityManager();
    }
}


