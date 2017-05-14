package org.office.leavemanagement.util;

import java.util.UUID;

public class TableUtil {
	public String getUUId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
}
