package com.indsp.tan.generics.tests.discovery;

import java.rmi.RemoteException;

import com.indsp.tan.federation.IDiscoveryListener;
import com.indsp.tan.federation.IFilter;
import com.indsp.tan.federation.ILocalFederation;
import com.indsp.tan.federation.IServiceInfo;
import com.indsp.tan.federation.impl.Federations;
import com.indsp.tan.federation.impl.Filters;
import com.indsp.tan.generics.tests.parameter.ParameterTester;
import com.indsp.tan.generics.tests.profile.ITestProfile;

public class DiscoveryTest implements IDiscoveryListener {

	public DiscoveryTest() {
		ILocalFederation fed = Federations.getLocal();
		IFilter filter = Filters.create().setInterface(ITestProfile.class).build();
		fed.getDiscovery().watch(filter, this);
	}

	@Override
	public void online(IFilter filter, Object service, IServiceInfo info) {
		if (filter.getInterfaces().contains(ITestProfile.class)) {
			ITestProfile p = (ITestProfile) service;
			try {
				ParameterTester.bind(p.test());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

}
