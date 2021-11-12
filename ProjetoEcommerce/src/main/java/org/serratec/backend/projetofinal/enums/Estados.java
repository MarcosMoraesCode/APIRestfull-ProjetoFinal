package org.serratec.backend.projetofinal.enums;

import org.serratec.backend.projetofinal.exceptions.EnumValidationException;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Estados {
	
	
		AC("Acre"), AL("Alagoas"), AP("Amapá"), AM("Amazonas"), BA ("Bahia"), 
		CE("Ceará"), DF("Distrito Federal"), ES("Espírito Santo "), 
		GO("Goiás"), MA("Maranhão"), MT("Mato Grosso"), MS("Mato Grosso do Sul"), 
		MG("Minas Gerais"), PA("Pará"), PB("Paraíba"), PR("Paraná"), PE("Pernambuco"), 
		PI("Piauí"), RJ("Rio de Janeiro"), RN("Rio Grande do Norte"), RS("Rio Grande do Sul"),
		RO("Rondônia"), RR("Roraima"), SC("Santa Catarina"), SP("São Paulo"), 
		SE("Sergipe"), TO("Tocantins");
		
		private String sigla;
		
		Estados(String sigla) {
		this.sigla = sigla;
		}
		
		public String getSigla() {
			return sigla;
		}
		public void setSigla(String sigla) {
			this.sigla = sigla;
		}
		
		@JsonCreator
		public static Estados verifica(String possivelEstado) throws EnumValidationException{
			for (Estados uf : values()) {
				if (possivelEstado.equals(uf.sigla)) {
					return uf;
				}
			}
			throw new EnumValidationException
			("Combustível Preenchido Incorretamente");
		}

	
	

}
