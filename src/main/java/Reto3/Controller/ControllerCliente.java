
package Reto3.Controller;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Admin;
import Reto3.Model.Cliente;
import Reto3.Service.ServiciosCliente;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerCliente {

    @Autowired
    private ServiciosCliente servicio;
  
    @GetMapping("/all")
    public List<Cliente> getClients(){

        return servicio.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save(@RequestBody Cliente client) {

        return servicio.save(client);
    }

   /* @GetMapping("/{id}")
    public Optional<Cliente> getClient(@PathVariable("id") int clientId) {

        return servicio.getClient(clientId);
    }*/
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente updateClient(@RequestBody Cliente client){
        return servicio.updateCliente(client);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("id") int clientId){

         servicio.deleteClient(clientId);
    }

}
