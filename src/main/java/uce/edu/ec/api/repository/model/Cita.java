package uce.edu.ec.api.repository.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Cita {
     
    private Integer id;

    private Map<String, String> agendadas = new HashMap<>();
    
    //Relaciones
    @JsonIgnore
    @OneToMany(mappedBy = "cita")
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @JsonIgnore
    @OneToMany(mappedBy = "cita")
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    
}
