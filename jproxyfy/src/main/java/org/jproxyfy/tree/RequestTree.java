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
package org.jproxyfy.tree;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

import org.jproxyfy.Request;
import org.jproxyfy.enums.CountryCode;

public class RequestTree {
	private Map<CountryCode, List<Request>> requestByCountry;
	private Map<UUID, Request> requestByUUID;
	private Map<CountryCode, Map<String, List<Request>>> requestByRegion;

	public RequestTree() {
		requestByCountry = new TreeMap<CountryCode, List<Request>>();
		requestByUUID = new HashMap<UUID, Request>();
		requestByCountry.put(CountryCode.RANDOM, new LinkedList<Request>());
		requestByRegion = new HashMap<CountryCode, Map<String, List<Request>>>();
	}

	public UUID addRequest(URL url) {
		Request request = new Request(url);
		requestByCountry.get(CountryCode.RANDOM).add(request);
		requestByUUID.put(request.getUuid(), request);
		return request.getUuid();
	}

	public UUID addRequest(URL url, CountryCode countryCode) {
		checkIfCountryCodeExists(countryCode);
		Request request = new Request(url);
		requestByCountry.get(countryCode).add(request);
		requestByUUID.put(request.getUuid(), request);
		return request.getUuid();
	}

	private void checkIfCountryCodeExists(CountryCode countryCode) {
		if (!requestByCountry.containsKey(countryCode)) {
			requestByCountry.put(countryCode, new LinkedList<Request>());
		}
	}
}
