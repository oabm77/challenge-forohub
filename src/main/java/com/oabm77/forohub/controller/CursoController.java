package com.oabm77.forohub.controller;

import com.oabm77.forohub.domain.curso.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroCurso datos,
                                    UriComponentsBuilder uriComponentsBuilder) {
        var curso = new Curso(datos);
        repository.save(curso);

        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleCurso(curso));
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaCurso>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable pageable) {
        var page = repository.findAllByActivoTrue(pageable).map(DatosListaCurso::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionCurso datos) {
        var curso = repository.getReferenceById(datos.id());
        curso.actualizarInformacion(datos);

        return ResponseEntity.ok(new DatosDetalleCurso(curso));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id) {
        var curso = repository.getReferenceById(id);
        curso.desactivar();
        
        return  ResponseEntity.noContent().build();
    }
}
