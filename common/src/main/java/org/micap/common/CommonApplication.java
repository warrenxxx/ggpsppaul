package org.micap.common;

import org.micap.common.entity.Variable;
import org.micap.common.repository.Error.ErrorDao;
import org.micap.common.repository.Error.ErrorDaoMongoImpl;

import java.util.List;
import java.util.Map;

public class CommonApplication {
	public static ErrorDao ERROR_DAO=new ErrorDaoMongoImpl();
	public static Map<String,List<Variable> > VARIABLES;
}
