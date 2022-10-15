/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Service;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Mensaje;
import Reto3.Model.Reservaciones;
import Reto3.Repo.RepositorioReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosReservaciones {
    
    @Autowired
    private RepositorioReservaciones metodosCrud;

    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.deleteReservation(reservationId);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    public Reservaciones updateReserva(Reservaciones res){

        if(res.getIdReservation()!=null){

            Optional<Reservaciones> a = metodosCrud.getReservation(res.getIdReservation());

            if(!a.isEmpty()){

                if(res.getStatus()!=null){
                    a.get().setStatus(res.getStatus());
                }
                if(res.getScore()!=null){
                    a.get().setStatus(res.getStatus());
                }
                if(res.getDevolutionDate()!=null){
                    a.get().setDevolutionDate(res.getDevolutionDate());
                }

                if(res.getStatus()!=null){
                    a.get().setStatus(res.getStatus());
                }
                metodosCrud.update(a.get());
                return a.get();
            }else{
                return res;
            }
        }else{
            return res;
        }

    }
}
