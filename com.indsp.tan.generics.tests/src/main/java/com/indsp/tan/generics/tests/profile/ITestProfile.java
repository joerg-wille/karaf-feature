package com.indsp.tan.generics.tests.profile;

import java.rmi.RemoteException;

import com.indsp.tan.generics.tests.pg.IPGTest;
import com.indsp.tan.profile.IProfile;

public interface ITestProfile extends IProfile {

	IPGTest test() throws RemoteException;

}
