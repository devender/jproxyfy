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
package org.jproxyfy.ipinfo;

import org.jproxyfy.enums.CountryCode;

/**
 * A simple pojo that holds all the data regarding an IP address.
 * 
 * @author Devender Gollapally
 */
public class IpInfo {
	private final String ip;
	private final int port;
	private String status;
	private CountryCode countryCode;
	private String reagionCode;
	private String regionName;
	private String city;

	public IpInfo(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	/**
	 * The ip address for which this objects holds info
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * Status of this IP
	 * 
	 * @return String "OK"
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Set the status of the IP of this object and this normally should be "OK"
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public CountryCode getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(CountryCode countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * Region Code can be either State of Province
	 * 
	 * @return String
	 */
	public String getReagionCode() {
		return reagionCode;
	}

	/**
	 * Set the State/Province Code of the IP
	 * 
	 * @param reagionCode
	 */
	public void setReagionCode(String reagionCode) {
		this.reagionCode = reagionCode;
	}

	/**
	 * Set the name of the State/Province
	 * 
	 * @return String
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * Set the region name of a given IP
	 * 
	 * @param regionName
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * Get the city of this IP
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Set the city of this IP
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get port used if any for this IP
	 * 
	 * @return
	 */
	public int getPort() {
		return port;
	}

}
