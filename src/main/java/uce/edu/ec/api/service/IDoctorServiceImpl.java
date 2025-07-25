package uce.edu.ec.api.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.ec.api.repository.IDoctorRepo;
import uce.edu.ec.api.repository.model.Doctor;

@ApplicationScoped
public class IDoctorServiceImpl implements IDoctorService{

    @Inject
    private IDoctorRepo doctorRepo;

    @Override
    public Doctor buscarPorId(Integer id) {
        return this.doctorRepo.seleccionarPorId(id);
    }

    @Override
    public List<Doctor> buscarTodos(String genero) {
        return this.doctorRepo.seleccionarTodos(genero);
    }

    @Override
    public void guardar(Doctor doctor) {
        this.doctorRepo.insertar(doctor);
    }
    
}
