package Reto3.Repo;

import Reto3.Interface.InterfaceAdmin;
import Reto3.Model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioAdmin {
    @Autowired
    private InterfaceAdmin crudA;

    public List<Admin> getAllAdmin(){
        return (List<Admin>) crudA.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return crudA.findById(id);
    }

    public Admin saveAdmin(Admin admin){
        return crudA.save(admin);
    }

    public Admin update(Admin admin){
        return crudA.save(admin);
    }
    public void deleteAdmin(int id){
        crudA.deleteById(id);
    }
}
