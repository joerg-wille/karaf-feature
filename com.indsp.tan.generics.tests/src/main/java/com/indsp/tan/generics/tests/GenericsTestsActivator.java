package com.indsp.tan.generics.tests;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.indsp.tan.generics.tests.discovery.DiscoveryTest;
import com.indsp.tan.generics.tests.parameter.ParameterTester;
import com.indsp.tan.generics.tests.profile.TestProfileImpl;

public class GenericsTestsActivator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		new TestProfileImpl();
		ParameterTester.initLocalPg();
		new DiscoveryTest();
		ParameterTester.updateLocal();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}
