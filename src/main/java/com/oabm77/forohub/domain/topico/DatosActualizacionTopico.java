package com.oabm77.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionTopico(
        @NotBlank
        Status status
) {
}
