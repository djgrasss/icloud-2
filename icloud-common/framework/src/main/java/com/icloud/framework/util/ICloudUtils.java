package com.icloud.framework.util;

import java.util.Collection;

public class ICloudUtils {

	public static <T> boolean isEmpty(Collection<T> collection) {
		if (collection == null)
			return true;
		if (collection.size() == 0)
			return true;
		return false;
	}
}
