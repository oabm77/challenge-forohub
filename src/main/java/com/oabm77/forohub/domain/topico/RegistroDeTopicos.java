package com.oabm77.forohub.domain.topico;

import com.oabm77.forohub.domain.ValidacionException;
import com.oabm77.forohub.domain.curso.CursoRepository;
import com.oabm77.forohub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroDeTopicos {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    public DatosDetalleTopico registrar(DatosRegistroTopico datos) {
        if (topicoRepository.existsByTitulo(datos.titulo())) {
            throw new ValidacionException("Ya existe un tópico con este título");
        }

        if (topicoRepository.existsByMensaje(datos.mensaje())) {
            throw new ValidacionException("Ya existe un tópico con este mismo mensaje");
        }

        if (!usuarioRepository.existsById(datos.idAutor())) {
            throw new ValidacionException("No existe un autor con el id informado");
        }

        if (!cursoRepository.existsById(datos.idCurso())) {
            throw new ValidacionException(("No existe in curso con el id informado"));
        }

        var autor = usuarioRepository.findById(datos.idAutor()).get();
        var curso = cursoRepository.findById(datos.idCurso()).get();
        var topico = new Topico(null, datos.titulo(), datos.mensaje(), datos.fechaCreacion(), datos.status(), autor, curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }
}
