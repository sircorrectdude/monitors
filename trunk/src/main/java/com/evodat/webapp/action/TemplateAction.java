package com.evodat.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.evodat.model.Template;
import com.evodat.model.TemplateType;
import com.evodat.model.User;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@InterceptorRef("jsonValidationWorkflowStack")
@Validations(requiredStrings = { @RequiredStringValidator(fieldName = "template.name", type = ValidatorType.FIELD, key = "error.template.name.required") })
public class TemplateAction extends BaseAction implements Preparable {

	private static final long serialVersionUID = 1618519184179033297L;
	private List<Template> templates;
	private Template template;
	private String id;
	private TemplateType templateType;

	public void prepare() throws Exception {
		if (getRequest().getMethod().equalsIgnoreCase("post")
				&& (!"".equals(getRequest().getParameter("template.id")))) {
			template = templateManager.getTemplate(getRequest().getParameter(
					"template.id"));
		}
		log.info(getCurrentUser());
	}

	/**
	 * Default: just returns "success"
	 * 
	 * @return "success"
	 */
	public String execute() {
		return SUCCESS;
	}

	public String cancel() {
		if (!"list".equals(from)) {
			return "mainMenu";
		}
		return "cancel";
	}

	public String list() {
		User currentUser = getCurrentUser();
		templates = templateManager.getTemplates(currentUser);
		return SUCCESS;
	}

	public String edit() throws IOException {

		if (id != null) {
			template = templateManager.getTemplate(id);
		} else {
			template = new Template();
			System.out.println(templateType);
			System.out.println(templateType.name());
			System.out.println(templateType.ordinal());
			template.setTemplateType(templateType);
		}

		return SUCCESS;
	}

	public String save() throws Exception {
		log.info(template.getText());
		log.info(template.getName());
		template.setEditable(true);
		template.setUser(getCurrentUser());
		templateManager.saveTemplate(template);

		if (!"list".equals(from)) {
			// add success messages
			saveMessage(getText("template.saved"));
			return "mainMenu";
		} else {
			// add success messages
			List<Object> args = new ArrayList<Object>();
			args.add(template.getName());
			saveMessage(getText("template.added", args));
			// Send an account information e-mail
			return SUCCESS;
		}
	}

	public String delete() {
		templateManager.removeTemplate(template.getId().toString());
		List<Object> args = new ArrayList<Object>();
		args.add(template.getName());
		saveMessage(getText("template.deleted", args));

		return SUCCESS;
	}

	public List<Template> getTemplates() {
		return templates;
	}

	public void setTemplates(List<Template> templates) {
		this.templates = templates;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

}
