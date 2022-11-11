package br.com.fiap.gs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Ambiente {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ambienteSequence")
	@SequenceGenerator(name = "ambienteSequence", sequenceName = "ambienteSequence")
	@Id
	private Long id;

	@Column(nullable = false)
	private String local;
	
	@Column(nullable = false)
	private double temperatura;
	
	@Column(nullable = false)
	private double qualidadeAr;
	
	public Ambiente() {}
	
	public Ambiente(Long id, String local, double temperatura, double qualidadeAr) {
		this.id = id;
		this.local = local;
		this.temperatura = temperatura;
		this.qualidadeAr = qualidadeAr;
	}

	public Long getId() {
		return id;
	}

	public String getLocal() {
		return local;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public double getQualidadeAr() {
		return qualidadeAr;
	}
}
