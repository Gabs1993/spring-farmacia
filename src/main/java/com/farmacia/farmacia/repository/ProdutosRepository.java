package com.farmacia.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.farmacia.farmacia.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	public List<Produtos> findAllByClienteContainingIgnoreCase (String cliente);
}
