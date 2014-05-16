package com.evodat.webapp.validators;

import com.evodat.model.Monitor;
import com.evodat.service.MonitorManager;
import com.evodat.service.MonitorNotFoundException;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class MonitorAliasUniqueValidator extends FieldValidatorSupport {

	/**
	 * The MonitorManager
	 */
	protected MonitorManager monitorManager;

	public void validate(Object object) throws ValidationException {

		String fieldName = getFieldName();
		Object value = this.getFieldValue(fieldName, object);
		if (!(value instanceof String)) {
			return;
		}

		String str = ((String) value).trim();

		try {
			Monitor monitorByAlias = monitorManager.getMonitorByAlias(str);

			if (monitorByAlias != null) {
				Object idValue = this.getFieldValue("monitor.id", object);
				Long id = ((Long) idValue);
				System.out.println(id);
				if (!monitorByAlias.getId().equals(id)) {
					addFieldError(fieldName, object);
				}
			}
		} catch (MonitorNotFoundException e) {
			// e.printStackTrace();
		}

	}

	public void setMonitorManager(MonitorManager monitorManager) {
		this.monitorManager = monitorManager;
	}

}
