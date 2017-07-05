package com.indsp.tan.generics.tests.pg;

import com.indsp.tan.generics.tests.parameter.IntegerTestParameter;
import com.indsp.tan.parameter.IParameter.IUpdateSource;
import com.indsp.tan.parametergroup.IParameterGroup;
import com.indsp.tan.parametergroup.IParameterGroupContract;
import com.indsp.tan.parametergroup.impl.ParameterGroups;

public interface IPGTest extends IParameterGroup {

	interface IListener extends IParameterGroup.IListener {
		void testUpdate(IPGTest pg, IntegerTestParameter t, IUpdateSource source);

	}

	IParameterGroupContract<IPGTest, IPGTest.IListener> contract = ParameterGroups.contract(IPGTest.class,
			IPGTest.IListener.class);

	@IParameterGroup.Attribute(version = 1, index = 0)
	IntegerTestParameter test();

}
