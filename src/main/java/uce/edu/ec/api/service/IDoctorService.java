package uce.edu.ec.api.service;

import java.util.List;

import uce.edu.ec.api.repository.model.Doctor;

public interface IDoctorService {

    public Doctor buscarPorId(Integer id);
    public List<Doctor> buscarTodos(String genero);
    public void guardar(Doctor doctor);   
    
}
