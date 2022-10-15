package Reto3.Repo;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Reservaciones;
import Reto3.Interface.InterfaceReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservaciones {
    
    @Autowired
    private InterfaceReservaciones crudR;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crudR.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crudR.findById(id);
    }

    public Reservaciones save(Reservaciones reservation){
        return crudR.save(reservation);
    }

    public void deleteReservation(int reservationID){
        crudR.deleteById(reservationID);
    }
    public Reservaciones update(Reservaciones reservation){
        return crudR.save(reservation);
    }

}
