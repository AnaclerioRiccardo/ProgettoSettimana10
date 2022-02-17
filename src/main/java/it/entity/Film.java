package it.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(name = "film.selectByRegista", query = "SELECT f FROM Film f WHERE f.regista=?1")
@NamedQuery(name = "film.getAll", query = "SELECT f FROM Film f")
public class Film {

	//Attributi
	private int id;
	private String titolo;
	private int anno;
	private String regista;
	private String tipo;
	private String incasso;		//Lo metto come Stringa perche' lo criptero'
	
	//Getter e Setter
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Column
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	@Column
	public String getRegista() {
		return regista;
	}
	public void setRegista(String regista) {
		this.regista = regista;
	}
	@Column
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column
	public String getIncasso() {
		return incasso;
	}
	public void setIncasso(String incasso) {
		this.incasso = incasso;
	}
	
}
