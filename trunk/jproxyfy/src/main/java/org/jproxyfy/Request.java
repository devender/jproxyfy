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
import java.util.UUID;

import org.jproxyfy.enums.RequestStatus;
import org.jproxyfy.ipinfo.IpInfo;

public class Request {
	private static final long ONE_DAY = 86400000;
	private final URL requestedURL;
	private final long createdAtInMillis;
	private RequestStatus requestStatus;
	private String result;
	private final UUID uuid;
	private IpInfo ipInfo;

	public Request(URL url) {
		requestedURL = url;
		createdAtInMillis = System.currentTimeMillis();
		uuid = UUID.randomUUID();
	}

	public URL getRequestedURL() {
		return requestedURL;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UUID getUuid() {
		return uuid;
	}

	public IpInfo getIpInfo() {
		return ipInfo;
	}

	public void setIpInfo(IpInfo ipInfo) {
		this.ipInfo = ipInfo;
	}

	public long getCreatedAtInMillis() {
		return createdAtInMillis;
	}

	public boolean isOlderThanADay() {
		long currentTime = System.currentTimeMillis();
		if ((currentTime - createdAtInMillis) > ONE_DAY) {
			return true;
		} else {
			return false;
		}
	}
}
