package com.ehc.test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EHCacheTest {
	public static void main(String[] args) {
		CacheManager cacheManager = new CacheManager();
		Cache myCache = cacheManager.getCache("mycache");
		myCache.put(new Element("key1", "value1"));
		
		Object value = myCache.get("key1");
		System.out.println(value);
	}
}
