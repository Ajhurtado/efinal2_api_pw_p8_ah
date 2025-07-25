package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.model.Paciente;

public interface IPacienteService {
    
    public Paciente buscarPorId(Integer id);
    public List<Paciente> buscarTodos();
    public void guardar(Paciente paciente);
}   
