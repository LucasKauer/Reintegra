package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Embeddable
public class RecomendacaoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "IdUsuarioFez", insertable = false, updatable = false)
	@NotNull
	private long idUsuarioFez;

	@Column(name = "IdUsuarioEgressoRecebeu", insertable = false, updatable = false)
	@NotNull
	private long idUsuarioEgressoRecebeu;

	@Column(name = "IdCompetencia", insertable = false, updatable = false)
	@NotNull
	private long idCompetencia;

	public RecomendacaoPK() {
	}

	public long getIdUsuarioFez() {
		return this.idUsuarioFez;
	}

	public void setIdUsuarioFez(long idUsuarioFez) {
		this.idUsuarioFez = idUsuarioFez;
	}

	public long getIdUsuarioEgressoRecebeu() {
		return this.idUsuarioEgressoRecebeu;
	}

	public void setIdUsuarioEgressoRecebeu(long idUsuarioEgressoRecebeu) {
		this.idUsuarioEgressoRecebeu = idUsuarioEgressoRecebeu;
	}

	public long getIdCompetencia() {
		return this.idCompetencia;
	}

	public void setIdCompetencia(long idCompetencia) {
		this.idCompetencia = idCompetencia;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RecomendacaoPK)) {
			return false;
		}
		RecomendacaoPK castOther = (RecomendacaoPK) other;
		return this.idUsuarioFez == castOther.idUsuarioFez
				&& this.idUsuarioEgressoRecebeu == castOther.idUsuarioEgressoRecebeu
				&& this.idCompetencia == castOther.idCompetencia;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCompetencia ^ (idCompetencia >>> 32));
		result = prime * result + (int) (idUsuarioEgressoRecebeu ^ (idUsuarioEgressoRecebeu >>> 32));
		result = prime * result + (int) (idUsuarioFez ^ (idUsuarioFez >>> 32));
		return result;
	}
}