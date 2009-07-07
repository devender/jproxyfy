package org.jproxyfy.providers;

import java.util.List;

import org.jproxyfy.ProxyProvider;
import org.jproxyfy.Request;
import org.jproxyfy.ipinfo.IpInfo;
import org.jproxyfy.tree.RequestTree;

public abstract class AbstractProxyProvider implements ProxyProvider {

	@Override
	public void fullfillRequests(RequestTree requestTree) {
		IpInfo ipInfo = rent();
		List<Request> list = requestTree.getRequestThatCanBeFullfilledByIP(ipInfo);
		for (Request request : list) {
			process(request);
		}
	}

	private void process(Request request) {
		// TODO Auto-generated method stub

	}

	protected abstract IpInfo rent();

}
