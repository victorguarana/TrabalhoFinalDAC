package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Artigo.class)
public abstract class Artigo_ {

	public static volatile SingularAttribute<Artigo, Volume> volume;
	public static volatile SingularAttribute<Artigo, String> titulo_en;
	public static volatile SingularAttribute<Artigo, String> palavras_chave_en;
	public static volatile SingularAttribute<Artigo, String> resumo_en;
	public static volatile SingularAttribute<Artigo, Integer> ordem_volume;
	public static volatile SingularAttribute<Artigo, String> titulo;
	public static volatile SingularAttribute<Artigo, String> palavras_chave;
	public static volatile SingularAttribute<Artigo, String> idioma;
	public static volatile SingularAttribute<Artigo, String> resumo;
	public static volatile ListAttribute<Artigo, Autor> lista_autores;
	public static volatile SingularAttribute<Artigo, Long> id;

}

