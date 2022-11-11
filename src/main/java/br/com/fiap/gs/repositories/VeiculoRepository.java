package br.com.fiap.gs.repositories;

import br.com.fiap.gs.models.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {}
