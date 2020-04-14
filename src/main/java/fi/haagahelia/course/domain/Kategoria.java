package fi.haagahelia.course.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Kategoria {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long kategoriaid;
	private String nimi;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
	private List<Peli> pelit;
	
	public Kategoria() {}
	
	public Kategoria(String nimi) {
		super();
		this.nimi = nimi;
	}
	
	public Long getKategoriaid() {
		return kategoriaid;
	}
	
	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	public List<Peli> getPelit() {
		return pelit;
	}

	public void setPelit(List<Peli> pelit) {
		this.pelit = pelit;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", nimi=" + nimi + "]";
	}
}