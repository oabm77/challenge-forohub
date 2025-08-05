package com.oabm77.forohub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private Boolean activo;

    public Curso(DatosRegistroCurso datos) {
        this.titulo = datos.titulo();
        this.categoria = datos.categoria();
        this.activo = true;
    }

    public void actualizarInformacion(@Valid DatosActualizacionCurso datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.categoria() != null) {
            this.categoria = datos.categoria();
        }
    }
    
    public void desactivar() {
        this.activo = false;
    }
}
