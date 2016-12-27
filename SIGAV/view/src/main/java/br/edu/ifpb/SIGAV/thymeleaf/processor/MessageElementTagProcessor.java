package br.edu.ifpb.SIGAV.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
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
public class MessageElementTagProcessor extends AbstractElementTagProcessor {
	
	private static final String TAG_NAME = "message";
	private static final int PROCEDENCE = 1000;

	/**
	 * 
	 * @param dialectPrefix
	 */
	public MessageElementTagProcessor(String dialectPrefix) {

		super(TemplateMode.HTML, dialectPrefix, TAG_NAME, true, null, false,PROCEDENCE);
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
								IElementTagStructureHandler structureHanndler) {
		
		IModelFactory modelFactory  = context.getModelFactory();
		IModel model = modelFactory.createModel();
		
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/error_message"));
		model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/success_message"));
		
		structureHanndler.replaceWith(model, true);
		
	}

}
