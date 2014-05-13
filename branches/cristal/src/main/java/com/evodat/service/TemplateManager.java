package com.evodat.service;

import java.util.List;

import com.evodat.model.Template;
import com.evodat.model.User;

public interface TemplateManager extends GenericManager<Template, Long> {
	Template getTemplate(String monitorId);

	Template saveTemplate(Template template) throws MonitorExistsException;

	void removeTemplate(String templateId);

	List<Template> getTemplates(User user);
}
