package org.baeldung.persistence.model.embedded;
import javax.persistence.Embeddable;


@Embeddable
public class UserAddress {
	
		private String ville;
		private String rue;
		private String numero;
		public String getVille() {
			return ville;
		}
		public void setVille(String ville) {
			this.ville = ville;
		}
		public String getRue() {
			return rue;
		}
		public void setRue(String rue) {
			this.rue = rue;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		@Override
		public String toString() {
			return "Address [ville=" + ville + ", rue=" + rue + ", numero=" + numero + "]";
		}

}
