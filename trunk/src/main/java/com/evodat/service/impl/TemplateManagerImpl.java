package com.evodat.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evodat.dao.TemplateDao;
import com.evodat.model.Template;
import com.evodat.service.TemplateManager;
import com.evodat.service.TemplateService;

@Service("templateManager")
@WebService(serviceName = "TemplateService", endpointInterface = "com.evodat.service.TemplateService")
public class TemplateManagerImpl extends GenericManagerImpl<Template, Long>
		implements TemplateManager, TemplateService {

	private TemplateDao templateDao;

	@Autowired
	public void setTemplateDao(TemplateDao templateDao) {
		this.dao = templateDao;
		this.templateDao = templateDao;
	}

	public Template getTemplate(String templateId) {
		return templateDao.get(new Long(templateId));
	}

	public List<Template> getTemplates() {
		return templateDao.getAllDistinct();
	}

	public void removeTemplate(String templateId) {
		log.debug("removing template: " + templateId);
		templateDao.remove(new Long(templateId));

	}

	public Template saveTemplate(Template template) {
		return templateDao.saveTemplate(template);

	}

}
