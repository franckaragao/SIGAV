package br.edu.ifpb.SIGAV.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

import br.edu.ifpb.SIGAV.enumerations.EspecieVeiculo;
import br.edu.ifpb.SIGAV.enumerations.Origin;
import br.edu.ifpb.SIGAV.validation.Placa;

/**
 * Classe representa entidade de negócio Veículo.
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
@Entity
@Table(name = "veiculo")
public class Veiculo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank(message = "Indentificação é obrigatório.")
	private String identificacao;

	@NotBlank(message = "Descrição é obrigatório.")
	@Size(min = 1, max = 50, message = "O tamanho da descrição deve estar entre 1 e 50.")
	private String descricao;

	@NotNull(message = "A origem é obrigatória.")
	@Enumerated(EnumType.STRING)
	@Column(name = "origem")
	private Origin origin;

	@NotNull(message = "A especíe de veículo é obrigatória.")
	@Enumerated(EnumType.STRING)
	@Column(name = "especie_veiculo")
	private EspecieVeiculo especieVeiculo;

	@NotNull(message = "O fabricante é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

	@Column(name = "numero_lugares")
	private Integer numeroLugares;

	@NotNull(message = "O Horimetro é obrigatório")
	@DecimalMin(value = "0", message = "Horimetro não pdoe ser negativo.")
	@Column(name = "horimetro")
	private BigDecimal horimetro;

	@Column(name = "ano_aquisicao")
	private Integer anoAquisicao;

	@Placa
	@NotBlank(message = "Placa é obrigatória.")
	private String placa;

	private String foto;

	@Column(name = "content_type")
	private String contentType;

	public Veiculo() {

	}

	/**
	 * Metódo callback do JPA.
	 * 
	 * Executa antes de inserir ou atualizar no BD.
	 */
	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		placa = placa.toUpperCase();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getFoto() {
		return foto;
	}
	
	public String getFotoOrMock(){
		return StringUtils.isEmpty(foto) ? "car-mock.png":foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Origin getOrigin() {
		return origin;
	}

	public void setOrigin(Origin origin) {
		this.origin = origin;
	}

	public EspecieVeiculo getEspecieVeiculo() {
		return especieVeiculo;
	}

	public void setEspecieVeiculo(EspecieVeiculo especieVeiculo) {
		this.especieVeiculo = especieVeiculo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getNumeroLugares() {
		return numeroLugares;
	}

	public void setNumeroLugares(Integer numeroLugares) {
		this.numeroLugares = numeroLugares;
	}

	public BigDecimal getHorimetro() {
		return horimetro;
	}

	public void setHorimetro(BigDecimal horimetro) {
		this.horimetro = horimetro;
	}

	public Integer getAnoAquisicao() {
		return anoAquisicao;
	}

	public void setAnoAquisicao(Integer anoAquisicao) {
		this.anoAquisicao = anoAquisicao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoAquisicao == null) ? 0 : anoAquisicao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((especieVeiculo == null) ? 0 : especieVeiculo.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((horimetro == null) ? 0 : horimetro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identificacao == null) ? 0 : identificacao.hashCode());
		result = prime * result + ((numeroLugares == null) ? 0 : numeroLugares.hashCode());
		result = prime * result + ((origin == null) ? 0 : origin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (anoAquisicao == null) {
			if (other.anoAquisicao != null)
				return false;
		} else if (!anoAquisicao.equals(other.anoAquisicao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (especieVeiculo != other.especieVeiculo)
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (horimetro == null) {
			if (other.horimetro != null)
				return false;
		} else if (!horimetro.equals(other.horimetro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identificacao == null) {
			if (other.identificacao != null)
				return false;
		} else if (!identificacao.equals(other.identificacao))
			return false;
		if (numeroLugares == null) {
			if (other.numeroLugares != null)
				return false;
		} else if (!numeroLugares.equals(other.numeroLugares))
			return false;
		if (origin != other.origin)
			return false;
		return true;
	}

}