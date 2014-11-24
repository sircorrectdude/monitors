package com.evodat.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evodat.dao.LicenseDao;
import com.evodat.model.License;
import com.evodat.model.User;

@Repository("licenseDao")
public class LicenseDaoHibernate extends GenericDaoHibernate<License, Long>
		implements LicenseDao {
	public LicenseDaoHibernate() {
		super(License.class);
	}

	public List<License> getLicensesByUser(User currentUser) {
		List<License> licenses = getHibernateTemplate().find(
				"from License license where license.user=?", currentUser);
		return licenses;
	}
}
