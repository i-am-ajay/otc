package com.filix.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * PrimeFaces calendar supports java.util.Date. Therefor to use LocalDate we have created a converter. 
 * How to use a converter?
 * Create a converter class that implements a generic converter, with single generic parameter i.e. of type to which we want to converter our 
   string value captured from view.
 * Use @FacesConverter annotation that takes fully qualified name of your converter class, we use this fully qualified name as converterId
   in our view.		
 * Register converter at the view in our p:calendar using f:converter tag. 
 	<f:converter converterId = "fully qualified class name"
 * @author AJAY
 *
 */
@FacesConverter("com.filix.utilities.DateConverter")
public class DateConverter implements Converter<LocalDate>{
	@Override
	public LocalDate getAsObject(FacesContext context, UIComponent component, String stringDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date = LocalDate.parse(stringDate, formatter);
		return date;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return date.format(formatter);
	}
}
