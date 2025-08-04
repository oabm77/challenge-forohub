package com.oabm77.forohub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionCurso(
        @NotNull Long id,
        String titulo,
        Categoria categoria
) {
}
