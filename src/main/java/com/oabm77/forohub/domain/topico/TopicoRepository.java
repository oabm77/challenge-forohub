package com.oabm77.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findAllByActivoTrue(Pageable paginacion);

    boolean existsByTitulo(@NotBlank String titulo);

    boolean existsByMensaje(@NotBlank String mensaje);
}
