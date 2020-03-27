package br.com.hub.errors.model;


import br.com.hub.errors.model.enum_model.EnvironmentsEnum;
import br.com.hub.errors.model.enum_model.ErrorLevelsEnum;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Log.class)
public class Log_ {
    public static volatile SingularAttribute<Log, ErrorLevelsEnum> errorLevel;
    public static volatile SingularAttribute<Log, EnvironmentsEnum> environment;

}
