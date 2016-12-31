package br.edu.ifpb.SIGAV.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IAttribute;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * 
 * @author <a href="https://github.com/FranckAJ">Franck Aragão</a>
 *
 */
public class OrderElementTagProcessor extends AbstractElementTagProcessor{
	
	private static final String TAG_NAME = "order";
	private static final int PROCEDENCE = 1000;

	/**
	 * 
	 * @param dialectPrefix
	 */
	public OrderElementTagProcessor(String dialectPrefix) {

		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false,PROCEDENCE);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		
		IModelFactory modelFactory = context.getModelFactory();
		IModel model = modelFactory.createModel();
		
		IAttribute page = tag.getAttribute("page");
		IAttribute field = tag.getAttribute("field");
		IAttribute text = tag.getAttribute("text");
		
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:replace",
				String.format("fragments/ording :: order (%s, %s, %s)", 
						page.getValue(), field.getValue(), text.getValue())));
		
		structureHandler.replaceWith(model, true); 
		
	}

}
