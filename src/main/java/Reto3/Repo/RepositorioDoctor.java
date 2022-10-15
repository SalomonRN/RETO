package Reto3.Repo;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Doctor;
import Reto3.Interface.InterfaceDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDoctor {
    
    @Autowired
    private InterfaceDoctor crudD;
  
    public List<Doctor> getAll(){
        return (List<Doctor>) crudD.findAll();
    }
    public Optional<Doctor> getDoctor(int id){
        return crudD.findById(id);
    }
    public Doctor save(Doctor doctor){
        return crudD.save(doctor);
    }
    public void deleteDoctor(int id){
        crudD.deleteById(id);
    }
    public Doctor update(Doctor doctor){
        return crudD.save(doctor);
    }
}
