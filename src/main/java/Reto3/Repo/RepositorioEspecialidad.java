package Reto3.Repo;

import java.util.List;
import java.util.Optional;

import Reto3.Interface.InterfaceEspecialidad;
import Reto3.Model.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspecialidad {
    
    @Autowired
    private InterfaceEspecialidad crudS;
    
    public List<Especialidad> getAll(){
        return (List<Especialidad>) crudS.findAll();
    } 
    public Optional<Especialidad> getSpecialty(int id){
        return crudS.findById(id);
    } 
    public Especialidad save(Especialidad specialty){
        return crudS.save(specialty);
    }
    public void deleteSpecialty(int SpecialtyId){
        crudS.deleteById(SpecialtyId);
    }
    public Especialidad update(Especialidad especialidad){
        return crudS.save(especialidad);
    }

}
