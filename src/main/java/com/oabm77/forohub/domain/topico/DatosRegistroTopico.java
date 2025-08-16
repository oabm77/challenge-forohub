package com.oabm77.forohub.domain.topico;

import com.oabm77.forohub.domain.curso.Curso;
import com.oabm77.forohub.domain.usuario.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistroTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        @Future
        LocalDateTime fechaCreacion,
        Status status,
        @NotNull
        Long idAutor,
        @NotNull
        Long idCurso
) {
}