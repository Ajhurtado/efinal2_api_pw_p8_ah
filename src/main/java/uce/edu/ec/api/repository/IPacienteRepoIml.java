package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import uce.edu.ec.api.repository.model.Paciente;

@ApplicationScoped
@Transactional
public class IPacienteRepoIml implements IPacienteRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Paciente seleccionarPorId(Integer id) {
        return this.entityManager.find(Paciente.class, id);
    }

    @Override
    public List<Paciente> seleccionarTodos() {
        return this.entityManager.createQuery("SELECT p FROM Paciente p", Paciente.class)
                .getResultList();
    }

    @Override
    public void insertar(Paciente paciente) {
        this.entityManager.persist(paciente);
    }
    
}
