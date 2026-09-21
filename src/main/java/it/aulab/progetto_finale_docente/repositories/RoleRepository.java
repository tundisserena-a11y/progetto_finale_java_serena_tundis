package it.aulab.progetto_finale_docente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.aulab.progetto_finale_docente.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    // Ricerca del ruolo tramite il nome
    Role findByName(String name);
}
