package com.oabm77.forohub.domain.curso;

public record DatosDetalleCurso(
        Long id,
        String titulo,
        Categoria categoria
) {
    public DatosDetalleCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getTitulo(),
                curso.getCategoria()
        );
    }
}
