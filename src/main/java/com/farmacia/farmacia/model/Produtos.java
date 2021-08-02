package com.farmacia.farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String cliente;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String cosmetico;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String remedio;
	
	@NotNull
	@Size(min = 5, max = 50)
	private Float preço;
	
	@ManyToOne
	@JsonIgnoreProperties ("tb_produtos")
	private Categoria categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCosmetico() {
		return cosmetico;
	}

	public void setCosmetico(String cosmetico) {
		this.cosmetico = cosmetico;
	}

	public String getRemedio() {
		return remedio;
	}

	public void setRemedio(String remedio) {
		this.remedio = remedio;
	}

	public Float getPreço() {
		return preço;
	}

	public void setPreço(Float preço) {
		this.preço = preço;
	}
	
	
}
