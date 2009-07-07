/*
 * Copyright 2008 the original author or authors.
 * 
 * http://www.gnu.org/licenses/gpl.txt
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
	private static final long TEN_MIN = 600000;

	public ProxyfyImpl() {
		requestTree = new RequestTree();
	}

	public void run() {
		while (requestTree.hasMoreRequestsToBeFullfilled()) {
			for (ProxyProvider provider : list) {
				provider.fullfillRequests(requestTree);
			}
		}
		sleep();
	}

	@SuppressWarnings("static-access")
	private void sleep() {
		try {
			Thread.currentThread().sleep(TEN_MIN);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
