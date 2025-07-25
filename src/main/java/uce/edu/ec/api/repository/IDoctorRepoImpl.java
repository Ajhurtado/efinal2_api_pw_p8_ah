package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.model.Doctor;

@Transactional
@ApplicationScoped
public class IDoctorRepoImpl implements IDoctorRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Doctor seleccionarPorId(Integer id) {
        return this.entityManager.find(Doctor.class, id);
    }

    @Override
    public List<Doctor> seleccionarTodos(String genero) {
        TypedQuery<Doctor> myQuery = this.entityManager.createQuery(
            "SELECT d FROM Doctor d WHERE d.genero = :genero", Doctor.class);
        myQuery.setParameter("genero", genero);
        return myQuery.getResultList();
    }
    
    @Override
    public void insertar(Doctor doctor) {
        this.entityManager.persist(doctor);
    }

  
}
