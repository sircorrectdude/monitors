package com.evodat.webapp.action;

import java.util.List;

import com.evodat.model.License;
import com.evodat.model.Template;
import com.evodat.model.TemplateType;

public class QuickstartAction extends BaseAction {

	private static final long serialVersionUID = 279309491889142645L;

	protected Template template;
	private String id;
	protected TemplateType templateType;
	private List<License> licenses;

	public String edit() {
		licenses = licenseManager.getLicensesByUser(getCurrentUser());
		if (id != null) {
			template = templateManager.getTemplate(id);
		} else {
			template = new Template();
			template.setTemplateType(templateType);
		}

		return SUCCESS;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public String getId() {
		return id;
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

	public List<License> getLicenses() {
		return licenses;
	}

	public void setLicenses(List<License> licenses) {
		this.licenses = licenses;
	}

}
