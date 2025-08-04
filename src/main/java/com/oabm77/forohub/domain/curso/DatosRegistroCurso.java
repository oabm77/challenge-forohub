package com.oabm77.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroCurso(
        @NotBlank String titulo,
        @NotNull Categoria categoria
) {

}
