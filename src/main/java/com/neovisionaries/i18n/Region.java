package com.neovisionaries.i18n;

import java.util.Currency;
import java.util.Locale;

/**
 * The region interface is implemented by {@link CountryCode}, but other implementations could exist also.
 *
 * @author Michiel Meeuwissen
 * @since 1.24
 */
public interface Region
{

	String getName();

	Locale toLocale();

	Currency getCurrency();


}
