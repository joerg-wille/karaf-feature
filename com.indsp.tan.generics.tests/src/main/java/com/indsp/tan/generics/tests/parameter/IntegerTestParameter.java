package com.indsp.tan.generics.tests.parameter;

import com.indsp.tan.parameter.IIntegerParameter;
import com.indsp.tan.parameter.IParameter.ParameterInfo;
import com.indsp.tan.parameter.impl.Parameters;

@ParameterInfo(name = "IntegerTestParameter", unit = "none", symbol = "none")
public interface IntegerTestParameter extends IIntegerParameter<IntegerTestParameter> {

	IIntegerDatatype<IntegerTestParameter> dt = Parameters.i(IntegerTestParameter.class);

}
