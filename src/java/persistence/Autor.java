package persistence;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Autor implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int ordem_artigo;
    private String email;
    private String nome_primeiro;
    private String nome_meio;
    private String nome_ultimo;
    private String afiliacao;
    private String afiliacao_en;
    private String pais;
    private String orcid;
    @ManyToOne
    private Artigo artigo;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public int getOrdemArtigo() {
        return ordem_artigo; 
    }

    public void setOrdemArtigo(int ordem_artigo) {
        this.ordem_artigo = ordem_artigo;
    }

    public String getEmail() {
        return email; 
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomePrimeiro() {
        return nome_primeiro; 
    }

    public void setNomePrimeiro(String nome_primeiro) {
        this.nome_primeiro = nome_primeiro;
    }

    public String getNomeMeio() {
        return nome_meio; 
    }

    public void setNomeMeio(String nome_meio) {
        this.nome_meio = nome_meio;
    }

    public String getNomeUltimo() {
        return nome_ultimo; 
    }

    public void setNomeUltimo(String nome_ultimo) {
        this.nome_ultimo = nome_ultimo;
    }

    public String getAfiliacao() {
        return afiliacao; 
    }

    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    public String getAfiliacaoEn() {
        return afiliacao_en; 
    }

    public void setAfiliacaoEn(String afiliacao_en) {
        this.afiliacao_en = afiliacao_en;
    }

    public String getPais() {
        return pais; 
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getOrcid() {
        return orcid; 
    }

    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    public Artigo getArtigo() {
        return artigo; 
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.AutorEntity[ id=" + id + " ]";
    }
    
}
