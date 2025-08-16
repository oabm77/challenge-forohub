package com.oabm77.forohub.controller;

import com.oabm77.forohub.domain.topico.DatosListaTopico;
import com.oabm77.forohub.domain.topico.DatosRegistroTopico;
import com.oabm77.forohub.domain.topico.RegistroDeTopicos;
import com.oabm77.forohub.domain.topico.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registro;

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos) {
        var detalleTopico = registro.registrar(datos);
        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListaTopico>> listar(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        var page = repository.findAllByActivoTrue(paginacion)
                .map(DatosListaTopico::new);

        return ResponseEntity.ok(page);
    }
}
