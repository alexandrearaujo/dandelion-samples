package com.github.dandelion.datatables.web.extension;

import com.github.dandelion.datatables.core.configuration.DatatableBundles;
import com.github.dandelion.datatables.core.constants.DTConstants;
import com.github.dandelion.datatables.core.extension.AbstractExtension;
import com.github.dandelion.datatables.core.extension.feature.PaginationType;
import com.github.dandelion.datatables.core.html.HtmlColumn;
import com.github.dandelion.datatables.core.html.HtmlRow;
import com.github.dandelion.datatables.core.html.HtmlTable;

public class MyAwesomeExtension extends AbstractExtension {

	@Override
	public String getName() {
		return "myExtension";
	}

	@Override
	public void setup(HtmlTable table) {

		// Add a new CSS class to the table
		table.addCssClass("myClass");
		
		// Add a new CSS class to each header column
		// The CSS class is passed through the custom 'data-custom-attr' column
		// attribute
		for (HtmlRow row : table.getHeadRows()) {
			for (HtmlColumn column : row.getColumns()) {
				column.addCssClass(column.getDynamicAttributeValue("data-custom-attr"));
				column.removeDynamicAttribute("data-custom-attr");
			}
		}
		
		// Override the generated configuration
		addParameter(DTConstants.DT_DOM, "tp");
		
		// Activate the 'four_button' pagination type
		addBundle(DatatableBundles.DDL_DT_PAGING_FOURBUTTON);
		addParameter(DTConstants.DT_PAGINATION_TYPE, PaginationType.FOUR_BUTTON.toString());
	}
}