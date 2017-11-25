package com.dpb.base.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public class RequestUtils {
	private static final IntParser INT_PARSER = new IntParser();

	private static final LongParser LONG_PARSER = new LongParser();

	private static final FloatParser FLOAT_PARSER = new FloatParser();

	private static final DoubleParser DOUBLE_PARSER = new DoubleParser();

	private static final BooleanParser BOOLEAN_PARSER = new BooleanParser();

	private static final StringParser STRING_PARSER = new StringParser();

	/**
	 * Get an Integer parameter, or <code>null</code> if not present. Throws
	 * an exception if it the parameter value isn't a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the Integer value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static Integer getIntParameter(ServletRequest request, String name) {

		if (request.getParameter(name) == null) {
			return null;
		}
		return new Integer(getRequiredIntParameter(request, name));
	}

	/**
	 * Get an int parameter, with a fallback value. Never throws an exception.
	 * Can pass a distinguished value as default to enable checks of whether it
	 * was supplied.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static int getIntParameter(ServletRequest request, String name,
			int defaultVal) {
		try {
			return getRequiredIntParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of int parameters, return an empty array if not found.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static int[] getIntParameters(ServletRequest request, String name) {
		try {
			return getRequiredIntParameters(request, name);
		} catch (Exception ex) {
			return new int[0];
		}
	}

	/**
	 * Get an int parameter, throwing an exception if it isn't found or isn't a
	 * number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static int getRequiredIntParameter(ServletRequest request,
			String name) {

		return INT_PARSER.parseInt(name, request.getParameter(name));
	}

	/**
	 * Get an array of int parameters, throwing an exception if not found or one
	 * is not a number..
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter with multiple possible values @ a subclass of
	 *            ServletException, so it doesn't need to be caught
	 */
	public static int[] getRequiredIntParameters(ServletRequest request,
			String name) {

		return INT_PARSER.parseInts(name, request.getParameterValues(name));
	}

	/**
	 * Get a Long parameter, or <code>null</code> if not present. Throws an
	 * exception if it the parameter value isn't a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the Long value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static Long getLongParameter(ServletRequest request, String name) {

		if (request.getParameter(name) == null) {
			return null;
		}
		return new Long(getRequiredLongParameter(request, name));
	}

	/**
	 * Get a long parameter, with a fallback value. Never throws an exception.
	 * Can pass a distinguished value as default to enable checks of whether it
	 * was supplied.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static long getLongParameter(ServletRequest request, String name,
			long defaultVal) {
		try {
			return getRequiredLongParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of long parameters, return an empty array if not found.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static long[] getLongParameters(ServletRequest request, String name) {
		try {
			return getRequiredLongParameters(request, name);
		} catch (Exception ex) {
			return new long[0];
		}
	}

	/**
	 * Get a long parameter, throwing an exception if it isn't found or isn't a
	 * number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static long getRequiredLongParameter(ServletRequest request,
			String name) {

		return LONG_PARSER.parseLong(name, request.getParameter(name));
	}

	/**
	 * Get an array of long parameters, throwing an exception if not found or
	 * one is not a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter with multiple possible values @ a subclass of
	 *            ServletException, so it doesn't need to be caught
	 */
	public static long[] getRequiredLongParameters(ServletRequest request,
			String name) {

		return LONG_PARSER.parseLongs(name, request.getParameterValues(name));
	}

	/**
	 * Get a Float parameter, or <code>null</code> if not present. Throws an
	 * exception if it the parameter value isn't a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the Float value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static Float getFloatParameter(ServletRequest request, String name) {

		if (request.getParameter(name) == null) {
			return null;
		}
		return new Float(getRequiredFloatParameter(request, name));
	}

	/**
	 * Get a float parameter, with a fallback value. Never throws an exception.
	 * Can pass a distinguished value as default to enable checks of whether it
	 * was supplied.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static float getFloatParameter(ServletRequest request, String name,
			float defaultVal) {
		try {
			return getRequiredFloatParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of float parameters, return an empty array if not found.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static float[] getFloatParameters(ServletRequest request, String name) {
		try {
			return getRequiredFloatParameters(request, name);
		} catch (Exception ex) {
			return new float[0];
		}
	}

	/**
	 * Get a float parameter, throwing an exception if it isn't found or isn't a
	 * number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static float getRequiredFloatParameter(ServletRequest request,
			String name) {

		return FLOAT_PARSER.parseFloat(name, request.getParameter(name));
	}

	/**
	 * Get an array of float parameters, throwing an exception if not found or
	 * one is not a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter with multiple possible values @ a subclass of
	 *            ServletException, so it doesn't need to be caught
	 */
	public static float[] getRequiredFloatParameters(ServletRequest request,
			String name) {

		return FLOAT_PARSER.parseFloats(name, request.getParameterValues(name));
	}

	/**
	 * Get a Double parameter, or <code>null</code> if not present. Throws an
	 * exception if it the parameter value isn't a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the Double value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static Double getDoubleParameter(ServletRequest request, String name) {

		if (request.getParameter(name) == null) {
			return null;
		}
		return new Double(getRequiredDoubleParameter(request, name));
	}

	/**
	 * Get a double parameter, with a fallback value. Never throws an exception.
	 * Can pass a distinguished value as default to enable checks of whether it
	 * was supplied.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static double getDoubleParameter(ServletRequest request,
			String name, double defaultVal) {
		try {
			return getRequiredDoubleParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of double parameters, return an empty array if not found.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static double[] getDoubleParameters(ServletRequest request,
			String name) {
		try {
			return getRequiredDoubleParameters(request, name);
		} catch (Exception ex) {
			return new double[0];
		}
	}

	/**
	 * Get a double parameter, throwing an exception if it isn't found or isn't
	 * a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static double getRequiredDoubleParameter(ServletRequest request,
			String name) {

		return DOUBLE_PARSER.parseDouble(name, request.getParameter(name));
	}

	/**
	 * Get an array of double parameters, throwing an exception if not found or
	 * one is not a number.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter with multiple possible values @ a subclass of
	 *            ServletException, so it doesn't need to be caught
	 */
	public static double[] getRequiredDoubleParameters(ServletRequest request,
			String name) {

		return DOUBLE_PARSER.parseDoubles(name, request
				.getParameterValues(name));
	}

	/**
	 * Get a Boolean parameter, or <code>null</code> if not present. Throws an
	 * exception if it the parameter value isn't a boolean.
	 * <p>
	 * Accepts "true", "on", "yes" (any case) and "1" as values for true; treats
	 * every other non-empty value as false (i.e. parses leniently).
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the Boolean value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static Boolean getBooleanParameter(ServletRequest request,
			String name) {

		if (request.getParameter(name) == null) {
			return null;
		}
		return (getRequiredBooleanParameter(request, name) ? Boolean.TRUE
				: Boolean.FALSE);
	}

	/**
	 * Get a boolean parameter, with a fallback value. Never throws an
	 * exception. Can pass a distinguished value as default to enable checks of
	 * whether it was supplied.
	 * <p>
	 * Accepts "true", "on", "yes" (any case) and "1" as values for true; treats
	 * every other non-empty value as false (i.e. parses leniently).
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static boolean getBooleanParameter(ServletRequest request,
			String name, boolean defaultVal) {
		try {
			return getRequiredBooleanParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of boolean parameters, return an empty array if not found.
	 * <p>
	 * Accepts "true", "on", "yes" (any case) and "1" as values for true; treats
	 * every other non-empty value as false (i.e. parses leniently).
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static boolean[] getBooleanParameters(ServletRequest request,
			String name) {
		try {
			return getRequiredBooleanParameters(request, name);
		} catch (Exception ex) {
			return new boolean[0];
		}
	}

	/**
	 * Get a boolean parameter, throwing an exception if it isn't found or isn't
	 * a boolean.
	 * <p>
	 * Accepts "true", "on", "yes" (any case) and "1" as values for true; treats
	 * every other non-empty value as false (i.e. parses leniently).
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static boolean getRequiredBooleanParameter(ServletRequest request,
			String name) {

		return BOOLEAN_PARSER.parseBoolean(name, request.getParameter(name));
	}

	/**
	 * Get an array of boolean parameters, throwing an exception if not found or
	 * one isn't a boolean.
	 * <p>
	 * Accepts "true", "on", "yes" (any case) and "1" as values for true; treats
	 * every other non-empty value as false (i.e. parses leniently).
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static boolean[] getRequiredBooleanParameters(
			ServletRequest request, String name) {

		return BOOLEAN_PARSER.parseBooleans(name, request
				.getParameterValues(name));
	}

	/**
	 * Get a String parameter, or <code>null</code> if not present. Throws an
	 * exception if it the parameter value is empty.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @return the String value, or <code>null</code> if not present @ a
	 *         subclass of ServletException, so it doesn't need to be caught
	 */
	public static String getStringParameter(ServletRequest request, String name) {

		if (request.getParameter(name) == null) {
			return "";
		}
		return getRequiredStringParameter(request, name);
	}

	/**
	 * Get a String parameter, with a fallback value. Never throws an exception.
	 * Can pass a distinguished value to default to enable checks of whether it
	 * was supplied.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter
	 * @param defaultVal
	 *            the default value to use as fallback
	 */
	public static String getStringParameter(ServletRequest request,
			String name, String defaultVal) {
		try {
			return getRequiredStringParameter(request, name);
		} catch (Exception ex) {
			return defaultVal;
		}
	}

	/**
	 * Get an array of String parameters, return an empty array if not found.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 *            the name of the parameter with multiple possible values
	 */
	public static String[] getStringParameters(ServletRequest request,
			String name) {
		try {
			return getRequiredStringParameters(request, name);
		} catch (Exception ex) {
			return new String[0];
		}
	}

	/**
	 * Get a String parameter, throwing an exception if it isn't found or is
	 * empty.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static String getRequiredStringParameter(ServletRequest request,
			String name) {

		return STRING_PARSER.validateRequiredString(name, request
				.getParameter(name));
	}

	/**
	 * Get an array of String parameters, throwing an exception if not found or
	 * one is empty.
	 * 
	 * @param request
	 *            current HTTP request
	 * @param name
	 * the name of the parameter @ a subclass of ServletException, so it doesn't
	 *            need to be caught
	 */
	public static String[] getRequiredStringParameters(ServletRequest request,
			String name) {

		return STRING_PARSER.validateRequiredStrings(name, request
				.getParameterValues(name));
	}

	private abstract static class ParameterParser {

		protected final Object parse(String name, String parameter) {
			validateRequiredParameter(name, parameter);
			try {
				return doParse(parameter);
			} catch (NumberFormatException ex) {
				throw new IllegalArgumentException("Required " + getType() + " parameter '"
						+ name + "' with value of '" + parameter
						+ "' is not a valid number");
			}
		}

		protected final void validateRequiredParameter(String name,
				Object parameter) {

//			if (parameter == null) {
//				throw new IllegalArgumentException("Required " + getType() + " parameter '"
//						+ name + "' is not present");
//			}
//			if ("".equals(parameter)) {
//				throw new IllegalArgumentException("Required " + getType() + " parameter '"
//						+ name + "' contains no value");
//			}
		}

		protected abstract String getType();

		protected abstract Object doParse(String parameter)
				throws NumberFormatException;
	}

	private static class IntParser extends ParameterParser {

		protected String getType() {
			return "int";
		}

		protected Object doParse(String s) throws NumberFormatException {
			return Integer.valueOf(s);
		}

		public int parseInt(String name, String parameter) {
			return ((Number) parse(name, parameter)).intValue();
		}

		public int[] parseInts(String name, String[] values) {
			validateRequiredParameter(name, values);
			int[] parameters = new int[values.length];
			for (int i = 0; i < values.length; i++) {
				parameters[i] = parseInt(name, values[i]);
			}
			return parameters;
		}
	}

	private static class LongParser extends ParameterParser {

		protected String getType() {
			return "long";
		}

		protected Object doParse(String parameter) throws NumberFormatException {
			return Long.valueOf(parameter);
		}

		public long parseLong(String name, String parameter) {
			return ((Number) parse(name, parameter)).longValue();
		}

		public long[] parseLongs(String name, String[] values) {
			validateRequiredParameter(name, values);
			long[] parameters = new long[values.length];
			for (int i = 0; i < values.length; i++) {
				parameters[i] = parseLong(name, values[i]);
			}
			return parameters;
		}
	}

	private static class FloatParser extends ParameterParser {

		protected String getType() {
			return "float";
		}

		protected Object doParse(String parameter) throws NumberFormatException {
			return Float.valueOf(parameter);
		}

		public float parseFloat(String name, String parameter) {
			return ((Number) parse(name, parameter)).floatValue();
		}

		public float[] parseFloats(String name, String[] values) {
			validateRequiredParameter(name, values);
			float[] parameters = new float[values.length];
			for (int i = 0; i < values.length; i++) {
				parameters[i] = parseFloat(name, values[i]);
			}
			return parameters;
		}
	}

	private static class DoubleParser extends ParameterParser {

		protected String getType() {
			return "double";
		}

		protected Object doParse(String parameter) throws NumberFormatException {
			return Double.valueOf(parameter);
		}

		public double parseDouble(String name, String parameter) {
			return ((Number) parse(name, parameter)).doubleValue();
		}

		public double[] parseDoubles(String name, String[] values) {
			validateRequiredParameter(name, values);
			double[] parameters = new double[values.length];
			for (int i = 0; i < values.length; i++) {
				parameters[i] = parseDouble(name, values[i]);
			}
			return parameters;
		}
	}

	private static class BooleanParser extends ParameterParser {

		protected String getType() {
			return "boolean";
		}

		protected Object doParse(String parameter) throws NumberFormatException {
			return (parameter.equalsIgnoreCase("true")
					|| parameter.equalsIgnoreCase("on")
					|| parameter.equalsIgnoreCase("yes")
					|| parameter.equals("1") ? Boolean.TRUE : Boolean.FALSE);
		}

		public boolean parseBoolean(String name, String parameter) {
			return ((Boolean) parse(name, parameter)).booleanValue();
		}

		public boolean[] parseBooleans(String name, String[] values) {
			validateRequiredParameter(name, values);
			boolean[] parameters = new boolean[values.length];
			for (int i = 0; i < values.length; i++) {
				parameters[i] = parseBoolean(name, values[i]);
			}
			return parameters;
		}
	}

	private static class StringParser extends ParameterParser {

		protected String getType() {
			return "string";
		}

		protected Object doParse(String parameter) throws NumberFormatException {
			return parameter;
		}

		public String validateRequiredString(String name, String value) {
			validateRequiredParameter(name, value);
			return value;
		}

		public String[] validateRequiredStrings(String name, String[] values) {
			validateRequiredParameter(name, values);
			for (int i = 0; i < values.length; i++) {
				validateRequiredParameter(name, values[i]);
			}
			return values;
		}
	}
	
	
	public static boolean isMultipart(HttpServletRequest request) {

		if (!"POST".equalsIgnoreCase(request.getMethod())) {
			return false;
		}

		String contentType = request.getContentType();
		if ((contentType != null)
				&& contentType.startsWith("multipart/form-data")) {
			return true;
		} else {
			return false;
		}
	}

}
