package com.neovisionaries.i18n;

import java.util.Currency;
import java.util.Locale;

/**
 * @author Michiel Meeuwissen
 * @since ...
 */
public interface Region
{

	String getName();

	Locale toLocale();

	Currency getCurrency();


}
