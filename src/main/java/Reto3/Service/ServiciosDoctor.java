/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Service;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Admin;
import Reto3.Model.Doctor;
import Reto3.Repo.RepositorioDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;


@Service
public class ServiciosDoctor {
    
    @Autowired
    private RepositorioDoctor metodosCrud;

    public List<Doctor> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Doctor> getDoctor(int idDoctor) {
        return metodosCrud.getDoctor(idDoctor);
    }
    public boolean deleteDoctor(int doctorId) {
        Boolean aBoolean = getDoctor(doctorId).map(doctor -> {
            metodosCrud.deleteDoctor(doctorId);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return metodosCrud.save(doctor);
        }else{
            Optional<Doctor> e=metodosCrud.getDoctor(doctor.getId());
            if(e.isEmpty()){
                return metodosCrud.save(doctor);
            }else{
                return doctor;
            }
        }
    }
    public Doctor updateDoctor(Doctor doc){

        if(doc.getId()!=null){

            Optional<Doctor> a = metodosCrud.getDoctor(doc.getId());

            if(!a.isEmpty()){

                if(doc.getName()!=null){
                    a.get().setName(doc.getName());
                }
                if(doc.getDepartment()!=null){
                    a.get().setDepartment(doc.getDepartment());
                }
                if(doc.getYear()!=null){
                    a.get().setYear(doc.getYear());
                }
                if(doc.getDescription() !=null){
                    a.get().setDescription(doc.getDescription());
                }
                metodosCrud.update(a.get());
                return a.get();
            }else{
                return doc;
            }
        }else{
            return doc;
        }

    }
}
