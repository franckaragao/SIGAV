package br.edu.ifpb.SIGAV.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.util.FieldUtils;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class ClassForErrorAttributeTagProcessor extends AbstractAttributeTagProcessor{
	
	private static final String NAME_ATTR = "classforerror";
	private static final int PRECEND = 1000;

	public ClassForErrorAttributeTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, null, false, NAME_ATTR, true, PRECEND, true);
	}
	
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
			String attributeValue, IElementTagStructureHandler structureHandler) {
		
		boolean hasErrors = FieldUtils.hasErrors(context, attributeValue);
		
		if (hasErrors) {
			String existingClasses = tag.getAttributeValue("class");
			structureHandler.setAttribute("class", existingClasses + " has-error");
		}
	}
}
