package model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private int ordem_volume;
    private String idioma;
    private String titulo;
    private String titulo_en;
    private String resumo;
    private String resumo_en;
    private String palavras_chave;
    private String palavras_chave_en;
    private Volume volume;
    private List<Autor> lista_autores;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getOrdemVolume() {
        return ordem_volume; 
    }

    public void setOrdemVolume(int ordem_volume) {
        this.ordem_volume = ordem_volume;
    }

    public String getIdioma() {
        return idioma; 
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() {
        return titulo; 
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTituloEn() {
        return titulo_en; 
    }

    public void setTituloEn(String titulo_en) {
        this.titulo_en = titulo_en;
    }

    public String getResumo() {
        return resumo; 
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
    
    public String getResumoEn() {
        return resumo_en; 
    }

    public void setResumoEn(String resumo_en) {
        this.resumo_en = resumo_en;
    }

    public String getPalavrasChave() {
        return palavras_chave; 
    }

    public void setPalavrasChave(String palavras_chave) {
        this.palavras_chave = palavras_chave;
    }

    public String getPalavrasChaveEn() {
        return palavras_chave_en; 
    }

    public void setPalavrasChaveEn(String palavras_chave_en) {
        this.palavras_chave_en = palavras_chave_en;
    }
    
    public Volume getVolume() {
        return volume; 
    }

    public void setVolume(Volume volume) {
        this.volume = volume;
    }

    public List<Autor> getListaAutores() {
        return lista_autores; 
    }

    public void setListaAutores(List<Autor> lista_autores) {
        this.lista_autores = lista_autores;
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
        if (!(object instanceof Artigo)) {
            return false;
        }
        Artigo other = (Artigo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.ArtigoEntity[ id=" + id + " ]";
    }
    
    public void empty(){
        this.id = Long.parseLong("0");
        this.idioma = "";
        this.palavras_chave = "";
        this.palavras_chave_en = "";
        this.resumo = "";
        this.resumo_en = "";
        this.titulo = "";
        this.titulo_en = "";
    }
}
