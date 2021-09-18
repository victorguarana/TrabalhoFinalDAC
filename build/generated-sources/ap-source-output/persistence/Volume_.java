package persistence;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Volume.class)
public abstract class Volume_ {

	public static volatile SingularAttribute<Volume, String> data_inicio;
	public static volatile SingularAttribute<Volume, String> cidade;
	public static volatile SingularAttribute<Volume, String> sigla;
	public static volatile ListAttribute<Volume, Artigo> lista_artigos;
	public static volatile SingularAttribute<Volume, String> descricao_pt;
	public static volatile SingularAttribute<Volume, Long> id;
	public static volatile SingularAttribute<Volume, Integer> edicao;
	public static volatile SingularAttribute<Volume, String> descricao_en;

}

