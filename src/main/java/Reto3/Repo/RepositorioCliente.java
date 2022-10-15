package Reto3.Repo;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Cliente;
import Reto3.Interface.InterfaceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    @Autowired
    private InterfaceCliente crudC;


    public List<Cliente> getAll(){
        return (List<Cliente>) crudC.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return crudC.findById(id);
    }

    public Cliente save(Cliente client){
        return crudC.save(client);
    }

    public void deleteClient(int id){
       crudC.deleteById(id);
    }

    public Cliente update(Cliente client){
        return crudC.save(client);
    }


}
