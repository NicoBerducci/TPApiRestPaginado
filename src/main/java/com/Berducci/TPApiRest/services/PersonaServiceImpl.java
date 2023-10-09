package com.Berducci.TPApiRest.services;

import com.Berducci.TPApiRest.entities.Persona;
import com.Berducci.TPApiRest.repositories.BaseRepository;
import com.Berducci.TPApiRest.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService{

    @Autowired
    private PersonaRepository personaRepositoryRepository;

    public PersonaServiceImpl(BaseRepository<Persona, Long> baseRepository){
        super(baseRepository);
    }
    @Override
    public List<Persona> search(String filtro) throws Exception{
        try{
            //List<Persona> personas = personaRepositoryRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepositoryRepository.search(filtro);
            List<Persona> personas = personaRepositoryRepository.searchNativo(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Page<Persona> search(String filtro, Pageable pageable) throws Exception{
        try{
            //Page<Persona> personas = personaRepositoryRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
            //Page<Persona> personas = personaRepositoryRepository.search(filtro, pageable);
            Page<Persona> personas = personaRepositoryRepository.searchNativo(filtro,pageable);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
