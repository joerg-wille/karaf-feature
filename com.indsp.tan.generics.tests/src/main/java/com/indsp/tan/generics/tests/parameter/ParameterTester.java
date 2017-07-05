package com.indsp.tan.generics.tests.parameter;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.Uninterruptibles;
import com.indsp.tan.generics.tests.pg.IPGTest;
import com.indsp.tan.parameter.IParameter.IUpdateListener;
import com.indsp.tan.parameter.IParameter.IUpdateSource;
import com.indsp.tan.parametergroup.impl.ParameterGroups;

public class ParameterTester {

	static IPGTest local;
	static IUpdateListener<IntegerTestParameter> listener = new IUpdateListener<IntegerTestParameter>() {

		@Override
		public void onParameterUpdate(IntegerTestParameter parameter, IUpdateSource source) {
			System.err.println(parameter.get());
			System.err.println(parameter.get());
			System.err.println(parameter.get());
		}
	};

	public static IPGTest newTestPg() {
		return ParameterGroups.group(IPGTest.contract, UUID.randomUUID(), null);
	}

	public static void initLocalPg() {
		local = ParameterGroups.group(IPGTest.contract, UUID.randomUUID(), null);
	}

	public static void bind(IPGTest test) {
		local.bind(test);
		local.test().addListener(listener);
	}

	public static void updateLocal() {
		int i = 0;
		while (i < 1000) {
			local.test().update(i++, null, null);
			Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		}
	}

}
