package uce.edu.ec.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IPacienteRepo;
import uce.edu.ec.api.repository.model.Paciente;

@ApplicationScoped
public class IPacienteServiceImpl implements IPacienteService{

    @Inject
    private IPacienteRepo iPacienteRepo;

    @Override
    public Paciente buscarPorId(Integer id) {
        return this.iPacienteRepo.seleccionarPorId(id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return this.iPacienteRepo.seleccionarTodos();
    }

    @Override
    public void guardar(Paciente paciente) {
        this.iPacienteRepo.insertar(paciente);
    }
    
}
