package Reto3.Service;

import Reto3.Model.Admin;
import Reto3.Repo.RepositorioAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiciosAdmin {
    @Autowired
    private RepositorioAdmin metodosCrud;

    public List<Admin> getAll(){
        return metodosCrud.getAllAdmin();
    }

    public Optional<Admin> getAdmin(int clientId) {
        return metodosCrud.getAdmin(clientId);
    }

    public boolean deleteAdmin(int clientId) {
        Boolean aBoolean = getAdmin(clientId).map(client -> {
            metodosCrud.deleteAdmin(clientId);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public Admin updateAdmin(Admin admin){

        if(admin.getID()!=null){

            Optional<Admin> a = metodosCrud.getAdmin(admin.getID());

            if(!a.isEmpty()){

                if(admin.getName()!=null){
                    a.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    a.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    a.get().setPassword(admin.getPassword());
                }
                metodosCrud.update(a.get());
                return a.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }

    }


    public Admin saveAdmin(Admin admin){
        if(admin.getID()==null){
            return metodosCrud.saveAdmin(admin);
        }else{
            Optional<Admin> e= metodosCrud.getAdmin(admin.getID());
            if(e.isEmpty()){
                return metodosCrud.saveAdmin(admin);
            }else{
                return admin;
            }
        }
    }

}


