/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Service;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Doctor;
import Reto3.Model.Especialidad;
import Reto3.Repo.RepositorioEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosEspecialidad {
    
    @Autowired
    private RepositorioEspecialidad metodosCrud;
    
    public List<Especialidad> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Especialidad> getSpecialty(int idSpecialty){
        return metodosCrud.getSpecialty(idSpecialty);
    }
    public boolean deleteSpecialty(int SpecialtyId) {
        Boolean d = getSpecialty(SpecialtyId).map(especialidad -> {
            metodosCrud.deleteSpecialty(SpecialtyId);
            return true;
        }).orElse(false);
        return d;
    }
        public Especialidad save(Especialidad specialty){
        if(specialty.getId()==null){
            return metodosCrud.save(specialty);
        }else{
            Optional<Especialidad> e= metodosCrud.getSpecialty(specialty.getId());
            if(e.isEmpty()){
                return metodosCrud.save(specialty);
            }else{
                return specialty;
            }
        }
    }

    public Especialidad updateEspecialidad(Especialidad especialidad){

        if(especialidad.getId()!=null){

            Optional<Especialidad> a = metodosCrud.getSpecialty(especialidad.getId());

            if(!a.isEmpty()){

                if(especialidad.getName()!=null){
                    a.get().setName(especialidad.getName());
                }
                if(especialidad.getDescription()!=null){
                    a.get().setDescription(especialidad.getDescription());
                }
                metodosCrud.update(a.get());
                return a.get();
            }else{
                return especialidad;
            }
        }else{
            return especialidad;
        }

    }

    
}
