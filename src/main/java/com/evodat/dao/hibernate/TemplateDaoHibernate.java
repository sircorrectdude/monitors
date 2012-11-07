package com.evodat.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.evodat.dao.TemplateDao;
import com.evodat.model.Template;

@Repository("templateDao")
public class TemplateDaoHibernate extends GenericDaoHibernate<Template, Long>
		implements TemplateDao {

	public TemplateDaoHibernate() {
		super(Template.class);
	}

	public Template saveTemplate(Template template) {
		if (log.isDebugEnabled()) {
			log.debug("template's id: " + template.getId());
		}
		getHibernateTemplate().saveOrUpdate(template);
		getHibernateTemplate().flush();
		return template;
	}

	/**
	 * @param user the user to save
	 * @return the modified user (with a primary key set if they're new)
	 */
	@Override
	public Template save(Template template) {
		return this.saveTemplate(template);
	}

}
