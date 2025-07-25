package uce.edu.ec.api.repository;

import java.util.List;

import uce.edu.ec.api.repository.model.Doctor;

public interface IDoctorRepo {

    public Doctor seleccionarPorId(Integer id);
    public List<Doctor> seleccionarTodos(String genero);
    public void insertar(Doctor doctor);
}
