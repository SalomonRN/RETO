/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Controller;


import java.util.List;

import Reto3.Model.ContadorClientes;
import Reto3.Model.Reservaciones;
import Reto3.Service.ServiciosReservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerReservaciones {
    
    @Autowired
    private ServiciosReservaciones servicio;


    @GetMapping("/all")
    public List<Reservaciones> getReservations(){

        return servicio.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }

    /*@GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }*/

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("id") int reservationId){

        return servicio.deleteReservation(reservationId);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones updateReserva(@RequestBody Reservaciones reservaciones){
        return servicio.updateReserva(reservaciones);

    }
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return servicio.reporteClientesServicio();
    }
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return servicio.reporteTiempoServicio(dateOne, dateTwo);
    }
    @GetMapping("/report-status")
    public StatusReservas getReservaciones(){
        return servicio.reporteStatusServicio();
    }

}
