package mz.gov.misau.mpc.enums;

public enum TipoPlanoHomologado {

	ACTIVO("Activo"), INACTIVO("Inactivo");

	private String descricao;

	private TipoPlanoHomologado(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {

		return this.descricao;
	}
}
