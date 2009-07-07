package org.jproxyfy;

import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.jproxyfy.enums.CountryCode;
import org.jproxyfy.enums.RequestStatus;
import org.jproxyfy.tree.RequestTree;

public class ProxyfyImpl implements Proxyfy {
	private List<ProxyProvider> list;
	private RequestTree requestTree;

	public ProxyfyImpl() {
		requestTree = new RequestTree();
	}

	@Override
	public UUID addRequest(URL url) {
		return requestTree.addRequest(url);
	}

	@Override
	public UUID addRequest(URL url, CountryCode countryCode) {
		return requestTree.addRequest(url, countryCode);
	}

	@Override
	public RequestStatus getRequestStatus(UUID uuid) {
		return requestTree.getRequestStatus(uuid);
	}

	@Override
	public Request getResult(UUID uuid) {
		return requestTree.remove(uuid);
	}

	@Override
	public void setProxyProviders(List<ProxyProvider> list) {
		this.list = list;
	}

}
