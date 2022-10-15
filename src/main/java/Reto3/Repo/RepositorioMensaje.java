/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Repo;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Mensaje;
import Reto3.Interface.InterfaceMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioMensaje {
    
    @Autowired
    private InterfaceMensaje crudM;
    
    public List<Mensaje> getAll(){
        return (List<Mensaje>) crudM.findAll();
    }
    public Optional<Mensaje> getMessage(int id){
        return crudM.findById(id);
    }

    public Mensaje save(Mensaje message){
        return crudM.save(message);
    }
    public void deleteMessage(int messageId){
        crudM.deleteById(messageId);

    }
    public Mensaje update(Mensaje message){
        return crudM.save(message);
    }
}
