package com.indsp.tan.generics.tests.profile;

import java.rmi.RemoteException;

import com.indsp.tan.generics.tests.parameter.ParameterTester;
import com.indsp.tan.generics.tests.pg.IPGTest;
import com.indsp.tan.profile.impl.AbstractProfile;

@SuppressWarnings("serial")
public class TestProfileImpl extends AbstractProfile implements ITestProfile {

	final IPGTest testPg = ParameterTester.newTestPg();

	public TestProfileImpl() throws RemoteException {
		super();
		publish();
	}

	@Override
	public IPGTest test() throws RemoteException {
		return testPg;
	}

}
