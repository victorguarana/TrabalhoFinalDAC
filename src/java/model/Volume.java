package model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Volume implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String sigla;
    private int edicao;
    private String cidade;
    private String data_inicio;
    private String descricao;
    private String descricao_en;
    private List<Artigo> lista_artigos;

    public Volume() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla; 
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getEdicao() {
        return edicao; 
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public String getCidade() {
        return cidade; 
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDataInicio() {
        return data_inicio; 
    }

    public void setDataInicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getDescricao() {
        return descricao; 
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricaoEn() {
        return descricao_en; 
    }

    public void setDescricaoEn(String descricao_en) {
        this.descricao_en = descricao_en;
    }
    
    public List<Artigo> getListaArtigos() {
        return lista_artigos; 
    }

    public void setListaArtigos(List<Artigo> lista_artigos) {
        this.lista_artigos = lista_artigos;
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
        if (!(object instanceof Volume)) {
            return false;
        }
        Volume other = (Volume) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public void empty(){
        this.cidade = "";
        this.sigla = "";
        this.descricao = "";
        this.descricao_en = "";
        this.id = Long.parseLong("0");
    }
    
}
