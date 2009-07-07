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

	}

	protected abstract IpInfo rent();

}
