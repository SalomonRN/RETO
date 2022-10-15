package Reto3.Controller;

import Reto3.Model.Admin;
import Reto3.Service.ServiciosAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerAdmin {


    @Autowired
    private ServiciosAdmin servicio;

    @GetMapping("/all")
    public List<Admin> getAdmin(){

        return servicio.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {

        return servicio.saveAdmin(admin);
    }

   /* @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int adminId) {

        return servicio.getAdmin(adminId);
    }*/



    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin admin){
        return servicio.updateAdmin(admin);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdmin(@PathVariable("id") int adminId){

        servicio.deleteAdmin(adminId);
    }

}
