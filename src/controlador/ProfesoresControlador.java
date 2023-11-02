/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import entidades.Carreras;
import entidades.Estudiantes;
import entidades.Profesores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author silvi
 */
public class ProfesoresControlador {
     public void crear( Profesores p) {
        EntityManager en = entityManager();
        try {
            en.getTransaction().begin();//iniciar la trasnsacion
            en.persist(p);
            en.getTransaction().commit();//inserta la transsaciion   
        }catch (Exception ex) {
            en.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
    public void editar(Profesores p){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.merge(p);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception ex) {
            en.getTransaction().rollback();
        }
        
    }
       public void eliminar(Profesores p){
        EntityManager en = entityManager();
        try {
         en.getTransaction().begin();//iniciar la trasnsacion
         en.remove(p);
         en.getTransaction().commit();//inserta la transsaciion   
        } catch (Exception ex) {
            en.getTransaction().rollback();
        }
        
    }
    public List<Carreras> todosLosEstudiantes(){
        Query q=entityManager().createQuery("SELECT p FROM Profesores p");
        return q.getResultList();
    }
    public EntityManager entityManager() {
        return Conexion.getInstance().getPersona().createEntityManager();
//         return Conexion..getInstance().getPersona().createEntityManager();
    }
    
}
