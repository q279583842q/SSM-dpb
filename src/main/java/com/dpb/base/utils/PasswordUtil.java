package com.dpb.base.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {
	
	public static String MD5encode(String rawpassword){
		byte[] encoded = Base64.encodeBase64(DigestUtils.md5(rawpassword));
		return new String(encoded);
	}
}
