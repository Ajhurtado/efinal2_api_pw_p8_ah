package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.model.Paciente;
import uce.edu.ec.api.service.to.PacienteTo;

public class PacienteMapper {

    public static PacienteTo toTo(Paciente paciente) {
        PacienteTo pacienteTo = new PacienteTo();
        pacienteTo.setId(paciente.getId());
        pacienteTo.setNombre(paciente.getNombre());
        pacienteTo.setApellido(paciente.getApellido());
        pacienteTo.setFechaNacimiento(paciente.getFechaNacimiento());
        return pacienteTo;
    }

    public static Paciente toEntity(PacienteTo pacienteTo) {
        Paciente paciente = new Paciente();
        paciente.setId(pacienteTo.getId());
        paciente.setNombre(pacienteTo.getNombre());
        paciente.setApellido(pacienteTo.getApellido());
        paciente.setFechaNacimiento(pacienteTo.getFechaNacimiento());
        return paciente;
    }
    
}
