package br.com.navarro.validator;

import java.util.List;

public class Validator {

	public static boolean isValid(@SuppressWarnings("rawtypes") List list) {
		return list != null && !list.isEmpty();
	}

	public static boolean isValid(Object obj) {
		return obj != null;
	}
}
