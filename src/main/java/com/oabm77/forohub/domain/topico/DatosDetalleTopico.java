package com.oabm77.forohub.domain.topico;

import com.oabm77.forohub.domain.curso.Curso;
import com.oabm77.forohub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String nombreAutor,
        String nombreCurso,
        String categoriaCurso
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getTitulo(),
                topico.getCurso().getCategoria().toString()
        );
    }
}
