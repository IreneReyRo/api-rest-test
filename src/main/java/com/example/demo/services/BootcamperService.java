package com.example.demo.services;

import com.example.demo.models.Bootcamper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BootcamperService {
    private List<Bootcamper> bootcamperList = new ArrayList<>();

    public List<Bootcamper> getAll(){
        bootcamperList.add(new Bootcamper("uno", Math.random()*10));
        bootcamperList.add(new Bootcamper("dos", Math.random()*10));
        bootcamperList.add(new Bootcamper("tres", Math.random()*10));
        return bootcamperList;
    }
    public void add(Bootcamper bootcamper){
        bootcamperList.add(bootcamper);
    }

    public Bootcamper get(String nombre){
        Optional<Bootcamper> bootcamperOptional = getAll().stream().filter(b -> b.getNombre().equals(nombre)).findAny();
        return !bootcamperOptional.isEmpty() ? bootcamperOptional.get() : new Bootcamper();
    }

    public Bootcamper put(String nombre, Bootcamper bootcamper){
        Bootcamper bootcamperRecuperado = get(nombre);
        bootcamperRecuperado.setNombre(bootcamper.getNombre());
        bootcamperRecuperado.setValor(bootcamper.getValor());

        return bootcamperRecuperado;
    }

    public void delete(String nombre){
        getAll().removeIf(b -> b.getNombre().equals(nombre));
    }

}
