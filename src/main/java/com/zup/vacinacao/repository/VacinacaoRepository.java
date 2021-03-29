package com.zup.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.vacinacao.model.Vacinacao;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {

}
