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

import java.io.IOException;

import org.jproxyfy.enums.CountryCode;
import org.jproxyfy.ipinfo.impl.IpInfoProviderImpl;

import junit.framework.TestCase;

public class IpInfoDBImpl extends TestCase {
	public void test() throws IOException {
		String ip = "74.125.45.100";

		IpInfoProvider infoService = new IpInfoProviderImpl();
		IpInfo actual = infoService.get(ip);

		assertEquals("74.125.45.100", actual.getIp());
		assertEquals("OK", actual.getStatus());
		assertEquals(CountryCode.US, actual.getCountryCode());
		assertEquals("06", actual.getReagionCode());
		assertEquals("California", actual.getRegionName());
		assertEquals("Mountain View", actual.getCity());
	}
}
