package mz.gov.misau.mpc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="planoServico")
@SequenceGenerator(name = "seq_plano_servico",sequenceName = "seq_plano_servico",initialValue = 1,allocationSize = 1)
public class PlanoServico implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_plano_servico")
	private Long id;
	
	@Column(nullable = false)
	private int qty;
	
	@Column(nullable = false)
	private double valorEstimado;
	
	@Column(nullable = false)
	private String periodoInicial;
	
	@Column(nullable = false)
	private String periodoFinal;
	
	@Column(nullable = false)
	private String IncioProcesso;
	
	@Column(nullable = false)
	private String FinalProcesso;
	
	@Column(nullable = false)
	private int prazoExecucao;
	
	
	private String observacao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataRegisto;
	
	//LISTA DE CHAVES ESTRANGERAS
	@ManyToOne(targetEntity = Tipo.class)
	@JoinColumn(name = "tipo_id",nullable = false,foreignKey = @ForeignKey(value =ConstraintMode.CONSTRAINT,name = "tipo_fk"))
	private Tipo tipo;
	
	@ManyToOne(targetEntity = Departamento.class)
	@JoinColumn(name = "departamento_id",nullable = false, foreignKey =@ForeignKey(value = ConstraintMode.CONSTRAINT,name = "departamento_fk"))
	private Departamento departamento;
	
	@ManyToOne(targetEntity = FonteRecurso.class)
	@JoinColumn(name = "fonterecurso_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "fonterecurso_fk"))
	private FonteRecurso fonterecurso;
	
	@ManyToOne(targetEntity = MContratacao.class)
	@JoinColumn(name = "mcontratacao_id",nullable = false,foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT,name = "mcontratacao_fk"))
	private MContratacao mcontratacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getValorEstimado() {
		return valorEstimado;
	}

	public void setValorEstimado(double valorEstimado) {
		this.valorEstimado = valorEstimado;
	}

	public String getPeriodoInicial() {
		return periodoInicial;
	}

	public void setPeriodoInicial(String periodoInicial) {
		this.periodoInicial = periodoInicial;
	}

	public String getPeriodoFinal() {
		return periodoFinal;
	}

	public void setPeriodoFinal(String periodoFinal) {
		this.periodoFinal = periodoFinal;
	}

	public String getIncioProcesso() {
		return IncioProcesso;
	}

	public void setIncioProcesso(String incioProcesso) {
		IncioProcesso = incioProcesso;
	}

	public String getFinalProcesso() {
		return FinalProcesso;
	}

	public void setFinalProcesso(String finalProcesso) {
		FinalProcesso = finalProcesso;
	}

	public int getPrazoExecucao() {
		return prazoExecucao;
	}

	public void setPrazoExecucao(int prazoExecucao) {
		this.prazoExecucao = prazoExecucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataRegisto() {
		return dataRegisto;
	}

	public void setDataRegisto(Date dataRegisto) {
		this.dataRegisto = dataRegisto;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public FonteRecurso getFonterecurso() {
		return fonterecurso;
	}

	public void setFonterecurso(FonteRecurso fonterecurso) {
		this.fonterecurso = fonterecurso;
	}

	public MContratacao getMcontratacao() {
		return mcontratacao;
	}

	public void setMcontratacao(MContratacao mcontratacao) {
		this.mcontratacao = mcontratacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PlanoServico other = (PlanoServico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
