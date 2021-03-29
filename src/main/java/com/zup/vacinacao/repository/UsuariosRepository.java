package com.zup.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.vacinacao.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long>{

}
