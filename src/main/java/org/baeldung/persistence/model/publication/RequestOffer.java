package org.baeldung.persistence.model.publication;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestOffer {
        @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String titre;
    	@Column(columnDefinition = "LONGTEXT")
        private String offer;
        private String date;
        private String attachmentURL;
        private String externLink;
        private int status;
        public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitre() {
			return titre;
		}

		public void setTitre(String titre) {
			this.titre = titre;
		}

		public String getOffer() {
			return offer;
		}

		public void setOffer(String offer) {
			this.offer = offer;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getAttachmentURL() {
			return attachmentURL;
		}

		public void setAttachmentURL(String attachmentURL) {
			this.attachmentURL = attachmentURL;
		}

		public String getExternLink() {
			return externLink;
		}

		public void setExternLink(String externLink) {
			this.externLink = externLink;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		@Override
		public String toString() {
			return "RequestOffer [id=" + id + ", titre=" + titre + ","
					+ " offer=" + offer + ", date=" + date
					+ ", attachmentURL=" + attachmentURL + ", "
				    + "externLink=" + externLink + ", status=" + status + "]";
		}

		
}
