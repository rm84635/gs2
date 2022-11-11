package br.com.fiap.gs.models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;

@Entity
public class Veiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private double quilometragem;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "Ambiente_id")
	private Ambiente ambiente;
	
	public Veiculo() {}
	
	public Veiculo(Long id, String marca, String modelo, String placa, double quilometragem, Ambiente ambiente) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.quilometragem = quilometragem;
		this.ambiente = ambiente;
	}
	
	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public double getQuilometragem() {
		return quilometragem;
	}
	
	public Ambiente getAmbiente() {
		return ambiente;
	}
}
