package com.oabm77.forohub.domain.curso;

public record DatosListaCurso(
        Long id,
        String titulo,
        Categoria categoria
) {
    public DatosListaCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getTitulo(),
                curso.getCategoria()
        );
    }
}
