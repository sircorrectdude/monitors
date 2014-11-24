package com.evodat.dao;

import java.util.List;

import com.evodat.model.Template;
import com.evodat.model.User;

public interface TemplateDao extends GenericDao<Template, Long> {
	Template saveTemplate(Template template);

	List<Template> getAll(User user);
}
