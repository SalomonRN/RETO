/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Controller;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Cliente;
import Reto3.Model.Doctor;
import Reto3.Service.ServiciosDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;


@RestController
@RequestMapping("/api/Doctor")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerDoctor {
    
    @Autowired
    private ServiciosDoctor servicios;


    @GetMapping("/all")
    public List<Doctor> getDoctors(){
        return servicios.getAll();
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save (@RequestBody Doctor doctor){
        return servicios.save(doctor);
    }


  /*  @GetMapping("/{id}")
    public Optional<Doctor> getDoctor(@PathVariable("id") int idDoctor){
        return servicios.getDoctor(idDoctor);
    }*/


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctor(@PathVariable("id") int doctorID){

        servicios.deleteDoctor(doctorID);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor updateClient(@RequestBody Doctor doc){
        return servicios.updateDoctor(doc);

    }


}
