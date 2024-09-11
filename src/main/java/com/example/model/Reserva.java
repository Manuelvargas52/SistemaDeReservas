package com.example.model;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "reserva")
public class Reserva {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date fecha_reserva;
    private Date fecha_servicio;
    private Time hora_servicio;
    private String estado;
    private Double monto_total;
    private String notas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;
    
    

    
	public Reserva() {
		super();
	}

	public Reserva(Date fecha_reserva, Date fecha_servicio, Time hora_servicio, String estado, Double monto_total,
			String notas, Cliente cliente, Servicio servicio) {
		super();
		this.fecha_reserva = fecha_reserva;
		this.fecha_servicio = fecha_servicio;
		this.hora_servicio = hora_servicio;
		this.estado = estado;
		this.monto_total = monto_total;
		this.notas = notas;
		this.cliente = cliente;
		this.servicio = servicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_reserva() {
		return fecha_reserva;
	}

	public void setFecha_reserva(Date fecha_reserva) {
		this.fecha_reserva = fecha_reserva;
	}

	public Date getFecha_servicio() {
		return fecha_servicio;
	}

	public void setFecha_servicio(Date fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
	}

	public Time getHora_servicio() {
		return hora_servicio;
	}

	public void setHora_servicio(Time hora_servicio) {
		this.hora_servicio = hora_servicio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(Double monto_total) {
		this.monto_total = monto_total;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
    
    
}
