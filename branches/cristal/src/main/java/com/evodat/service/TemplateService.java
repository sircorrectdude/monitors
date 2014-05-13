package com.evodat.service;

import java.util.List;

import javax.jws.WebService;

import com.evodat.model.Template;
import com.evodat.model.User;

@WebService
public interface TemplateService {
	Template getTemplate(String templateId);

	Template saveTemplate(Template template) throws MonitorExistsException;

	void removeTemplate(String templateId);

	List<Template> getTemplates(User user);
}
