/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Service;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Admin;
import Reto3.Model.Cliente;
import Reto3.Repo.RepositorioCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosCliente {
    
    @Autowired
    private RepositorioCliente metodosCrud;
     
    public List<Cliente> getAll(){
        return metodosCrud.getAll();
    }
     
    public Optional<Cliente> getClient(int clientId) {
        return metodosCrud.getCliente(clientId);
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.deleteClient(clientId);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public Cliente save(Cliente client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Cliente> e= metodosCrud.getCliente(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }
    public Cliente updateCliente(Cliente client){

        if(client.getIdClient()!=null){

            Optional<Cliente> a = metodosCrud.getCliente(client.getIdClient());

            if(!a.isEmpty()){

                if(client.getName()!=null){
                    a.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    a.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    a.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    a.get().setAge(client.getAge());
                }
                metodosCrud.update(a.get());

                return a.get();
            }else{
                return client;
            }
        }else{
            return client;
        }

    }
    
}
