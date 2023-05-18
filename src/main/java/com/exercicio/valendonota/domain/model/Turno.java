package com.exercicio.valendonota.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.exercicio.valendonota.domain.Enum.TipoTurno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer" })
public class Turno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "turno_id")
    private Long id;

    @Column(name = "tipo_turno")
    private TipoTurno tipoTurno;

    @Column(name = "hora_entrada")
    private String horaEntrada;

    @Column(name = "hora_saida")
    private String horaSaida;

    @Column(name = "hora_descanso")
    private String horaDescanso;

    @Column(name = "duracao_descanso")
    private Integer duracaoDescanso;

    @OneToMany(mappedBy = "turno")
    @JsonManagedReference
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Turno(TipoTurno turno) {
        this.tipoTurno = turno;
        this.horaEntrada = turno.getHorarioEntrada();
        this.horaDescanso = turno.getHorarioDescanso();
        this.horaSaida = turno.getHorarioSaida();
        this.duracaoDescanso = 1;
    }
}
