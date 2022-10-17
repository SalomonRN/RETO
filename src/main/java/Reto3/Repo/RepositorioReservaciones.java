package Reto3.Repo;
import Reto3.Model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Reto3.Model.Cliente;
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
    public List<Reservaciones> ReservacionTiempoRepositorio (Date a, Date b){

        return crudR.findAllByStartDateAfterAndStartDateBefore(a, b);
    }
    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crudR.countTotalReservationsByCliente();
        for(int i=0; i<report.size(); i++){
            res.add(new ContadorClientes((Long)report.get(i)[1],(Cliente) report.get(i)[0]));
        }
        return res;
    }
    public List<Reservaciones> ReservacionStatusRepositorio(String status){
        return crudR.findAllByStatus(status);
    }
}

