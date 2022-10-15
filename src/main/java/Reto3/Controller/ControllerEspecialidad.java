/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.Controller;

import java.util.List;
import java.util.Optional;

import Reto3.Model.Doctor;
import Reto3.Model.Especialidad;
import Reto3.Service.ServiciosEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerEspecialidad {
    
    @Autowired
    private ServiciosEspecialidad servicios;

    @GetMapping("/all")
    public List<Especialidad> getSpecialty(){
        return servicios.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save (@RequestBody Especialidad specialty){
        return servicios.save(specialty);
    }

   /* @GetMapping("/{id}")
    public Optional<Especialidad> getSpecialty(@PathVariable("id") int idSpecialty){
        return servicios.getSpecialty(idSpecialty);
    }*/
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad updateClient(@RequestBody Especialidad especialidad){
        return servicios.updateEspecialidad(especialidad);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSpecialty(@PathVariable("id") int SpecialtyId){
        servicios.deleteSpecialty(SpecialtyId);
    }

}
