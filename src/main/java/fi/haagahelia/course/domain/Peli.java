package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Peli {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nimi;
    private String kehittaja;
    private int julkaisuvuosi;
    private String alusta;
    private String saavutus;
    
    @ManyToOne
    @JoinColumn(name = "kategoriaid")
    @JsonManagedReference
    private Kategoria kategoria;

    public Peli() {}

	public Peli(String nimi, String kehittaja, int julkaisuvuosi, String alusta, Kategoria kategoria, String saavutus) {
		super();
		this.nimi = nimi;
		this.kehittaja = kehittaja;
		this.julkaisuvuosi = julkaisuvuosi;
		this.alusta = alusta;
		this.kategoria = kategoria;
		this.saavutus = saavutus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public String getKehittaja() {
		return kehittaja;
	}

	public void setKehittaja(String kehittaja) {
		this.kehittaja = kehittaja;
	}

	public int getJulkaisuvuosi() {
		return julkaisuvuosi;
	}

	public void setJulkaisuvuosi(int julkaisuvuosi) {
		this.julkaisuvuosi = julkaisuvuosi;
	}
	
	public String getAlusta() {
		return alusta;
	}

	public void setAlusta(String alusta) {
		this.alusta = alusta;
	}

	public String getSaavutus() {
		return saavutus;
	}

	public void setSaavutus(String saavutus) {
		this.saavutus = saavutus;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	@Override
	public String toString() {
		if (this.kategoria != null)
			return "Peli [id=" + id + ", nimi=" + nimi + ", kehittaja=" + kehittaja + ", julkaisuvuosi=" + julkaisuvuosi + ", alusta=" + alusta + ", kategoria =" + kategoria + ", saavutus=" + saavutus + "]";		
		else
			return "Peli [id=" + id + ", nimi=" + nimi + ", kehittaja=" + kehittaja + ", julkaisuvuosi=" + julkaisuvuosi + ", alusta=" + alusta + ", saavutus=" + saavutus + "]";
	}
}
