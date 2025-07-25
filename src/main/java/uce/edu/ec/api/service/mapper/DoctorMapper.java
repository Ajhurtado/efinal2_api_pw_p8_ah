package uce.edu.ec.api.service.mapper;

import uce.edu.ec.api.repository.model.Doctor;
import uce.edu.ec.api.service.to.DoctorTo;

public class DoctorMapper {

    public static DoctorTo toTo(Doctor doctor) {
        DoctorTo doctorTo = new DoctorTo();
        doctorTo.setId(doctor.getId());
        doctorTo.setCedula(doctor.getCedula());
        doctorTo.setNombre(doctor.getNombre());
        doctorTo.setApellido(doctor.getApellido());
        doctorTo.setGenero(doctor.getGenero());
        return doctorTo;
    }

    public static Doctor toEntity(DoctorTo doctorTo) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorTo.getId());
        doctor.setCedula(doctorTo.getCedula());
        doctor.setNombre(doctorTo.getNombre());
        doctor.setApellido(doctorTo.getApellido());
        doctor.setGenero(doctorTo.getGenero());
        return doctor;
    }
    
}
