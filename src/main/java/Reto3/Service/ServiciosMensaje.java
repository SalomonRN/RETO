/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Service;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Doctor;
import Reto3.Model.Mensaje;
import Reto3.Repo.RepositorioMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosMensaje {
    
    @Autowired
    private RepositorioMensaje metodosCrud;

    public List<Mensaje> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Mensaje> getMessage(int messageId) {
        return metodosCrud.getMessage(messageId);
    }
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            metodosCrud.deleteMessage(messageId);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public Mensaje save(Mensaje message){
        if(message.getIdMessage()==null){
            return metodosCrud.save(message);
        }else{
            Optional<Mensaje> e= metodosCrud.getMessage(message.getIdMessage());
            if(e.isEmpty()){
                return metodosCrud.save(message);
            }else{
                return message;
            }
        }
    }
    public Mensaje updateMensaje(Mensaje men){

        if(men.getIdMessage()!=null){

            Optional<Mensaje> a = metodosCrud.getMessage(men.getIdMessage());

            if(!a.isEmpty()){

                if(men.getMessageText()!=null){
                    a.get().setMessageText(men.getMessageText());
                }
                metodosCrud.update(a.get());
                return a.get();
            }else{
                return men;
            }
        }else{
            return men;
        }

    }

}
