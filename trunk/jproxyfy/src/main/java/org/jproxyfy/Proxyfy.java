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

import org.jproxyfy.enums.CountryCode;



/**
 * 
 * @author devender
 * 
 */
public interface Proxyfy {
	
	/**
	 * Add a request to hit a particular url from a random IP
	 * @param url
	 * @return {@link UUID}
	 */
	UUID addRequest(URL url);
	
	/**
	 * Add a request to hit a particular url from the given country code, will retry for 24 hours.
	 * 
	 * @param url
	 * @param city
	 * @return {@link UUID}
	 */
	UUID addRequest(URL url, CountryCode countryCode);
	
	/**
	 * Add a request to hit a particular url from the given country code, will retry for 24 hours.
	 * 
	 * @param url
	 * @param city
	 * @return {@link UUID}
	 */
	UUID addRequest(URL url, CountryCode countryCode, String region);
	

}
