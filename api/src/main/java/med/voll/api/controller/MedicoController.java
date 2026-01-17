package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  metodo POST

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;


    @Transactional
    @PostMapping
    public void registrar(@RequestBody @Valid DatosRegistroMedico datos){
        repository.save(new Medico(datos));
    }

    @GetMapping
    public Page<DatosListaMedicos> listar(@PageableDefault(size = 10, sort = {"nombre"}) Pageable paginacion){
        return repository.findAll(paginacion).map(DatosListaMedicos::new);
    }


    @Transactional
    @PutMapping
    public void actualizar(@RequestBody @Valid DatosActualizacionMedicos datos) {
        var medico = repository.getReferenceById(datos.id());
        medico.actualizarInformacion(datos);
    }


    @Transactional
    @DeleteMapping("/{id}")
    public void eliminar( @PathVariable Long id){
        repository.deleteById(id);
    }
}
