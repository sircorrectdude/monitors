package com.evodat.dao;

import com.evodat.model.Template;

public interface TemplateDao extends GenericDao<Template, Long> {
	Template saveTemplate(Template template);
}
