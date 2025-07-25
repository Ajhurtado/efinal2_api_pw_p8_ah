package uce.edu.ec.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import uce.edu.ec.api.repository.model.Paciente;

@ApplicationScoped
public interface IPacienteRepo {
    
    public Paciente seleccionarPorId(Integer id);
    public List<Paciente> seleccionarTodos();
    public void insertar(Paciente paciente);
    
}
