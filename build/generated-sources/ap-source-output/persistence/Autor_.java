package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Autor.class)
public abstract class Autor_ {

	public static volatile SingularAttribute<Autor, String> nome_ultimo;
	public static volatile SingularAttribute<Autor, Integer> ordem_artigo;
	public static volatile SingularAttribute<Autor, String> nome_primeiro;
	public static volatile SingularAttribute<Autor, String> afiliacao;
	public static volatile SingularAttribute<Autor, String> afiliacao_en;
	public static volatile SingularAttribute<Autor, String> orcid;
	public static volatile SingularAttribute<Autor, Long> id;
	public static volatile SingularAttribute<Autor, String> nome_meio;
	public static volatile SingularAttribute<Autor, Artigo> artigo;
	public static volatile SingularAttribute<Autor, String> email;
	public static volatile SingularAttribute<Autor, String> pais;

}

