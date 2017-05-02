package net.rajesh.spring.core.buisness.logic;

import java.beans.PropertyEditorSupport;

/**
 * @author Rajesh Kumar<rajsolitary@gmail.com>
 */

public class CurrencyTypeConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(final String text) throws IllegalArgumentException {
		setValue(CurrencyType.valueOf(text.trim()));
	}
}
