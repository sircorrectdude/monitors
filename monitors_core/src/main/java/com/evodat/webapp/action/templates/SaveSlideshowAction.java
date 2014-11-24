package com.evodat.webapp.action.templates;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.InterceptorRef;

import com.evodat.Constants;
import com.evodat.model.Monitor;
import com.evodat.model.Slideshow;
import com.evodat.model.SlideshowImage;
import com.evodat.model.Template;
import com.evodat.model.TemplateType;
import com.evodat.service.MonitorExistsException;
import com.evodat.webapp.action.QuickstartAction;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * @author joris
 * 
 */
@InterceptorRef("jsonValidationWorkflowStack")
@Validations(customValidators = { @CustomValidator(fieldName = "monitor.alias", key = "error.monitor.alias.notunique", type = "monitorAliasUniqueValidator") }, requiredStrings = {
		@RequiredStringValidator(fieldName = "monitor.ipAddress", type = ValidatorType.FIELD, key = "error.monitor.ipAddress.required"),
		@RequiredStringValidator(fieldName = "monitor.alias", type = ValidatorType.FIELD, key = "error.monitor.alias.required") })
public class SaveSlideshowAction extends QuickstartAction {
	private static final long serialVersionUID = -5740184547171210764L;
	// private Template template;
	final String MSG_KEY_ERROR_FILE_TOO_LARGE = "MSG_KEY_ERROR_FILE_TOO_LARGE";
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String qquuid;
	private String qqfilename;
	private String qqtotalfilesize;
	// private String templateId;
	private boolean success;
	private Slideshow slideshow;
	private Monitor monitor;
	private SlideshowImage slideshowImage;

	/**
	 * @return
	 * @throws MonitorExistsException
	 * @throws Exception
	 */
	public String saveSlideshow() {
		slideshow = slideshowManager.save(slideshow);
		log.info(slideshow + " saved");
		template = slideshow.getTemplate();
		log.info(slideshow);
		// saveQuickstartMonitor();
		return SUCCESS;
	}

	/**
	 * Upload the file
	 * 
	 * @return String with result (cancel, input or sucess)
	 * @throws Exception
	 *             if something goes wrong
	 */
	public String upload() {
		if (template.getId() == null) {
			template.setTemplateType(TemplateType.SLIDESHOW);
			template.setEditable(true);
			template.setUser(getCurrentUser());
			slideshow = new Slideshow();
			Set<SlideshowImage> slideshowImages = new HashSet<SlideshowImage>();
			slideshow.setSlideshowImages(slideshowImages);
			slideshow.setTemplate(template);
		} else {
			// template.setId(Long.valueOf(templateId));
			slideshow = slideshowManager.getSlideshow(template);
			log.info("fetching slideshow: " + slideshow);
			template = slideshow.getTemplate();
			log.info(template);
		}
		log.info("upload..." + qquuid);
		log.info("content-type..." + fileContentType);
		// validate();

		String internalFilename = qquuid
				+ qqfilename.substring(qqfilename.lastIndexOf("."));
		if (getActionErrors().contains(MSG_KEY_ERROR_FILE_TOO_LARGE)) {
			log.info("MSG_KEY_ERROR_FILE_TOO_LARGE");
			setSuccess(false);
			return SUCCESS;
		}

		// the directory to upload to
		String uploadDir = ServletActionContext.getServletContext()
				.getRealPath("/images") + "/";

		// write the file to the file specified
		File dirPath = new File(uploadDir);

		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}

		// retrieve the file data
		InputStream stream;
		try {
			stream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			setSuccess(false);
			// setError(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}

		// write the file to the file specified
		OutputStream bos;
		try {
			bos = new FileOutputStream(uploadDir + internalFilename);
		} catch (FileNotFoundException e) {
			setSuccess(false);
			// setError(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}
		int bytesRead;
		byte[] buffer = new byte[8192];

		try {
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			setSuccess(false);
			// setError(e.getMessage());
			e.printStackTrace();
			return ERROR;
		}

		try {
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();

			return SUCCESS;
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// place the data into the request for retrieval on next page
		getRequest().setAttribute("location",
				dirPath.getPath() + Constants.FILE_SEP + internalFilename);

		String link = getRequest().getContextPath() + "/images" + "/";

		getRequest().setAttribute("link", link + internalFilename);
		setSuccess(true);
		SlideshowImage slideshowImage = new SlideshowImage();
		slideshowImage.setSlideshow(slideshow);
		slideshowImage.setName(internalFilename);
		slideshowImage.setOriginalFilename(fileFileName);
		slideshow.getSlideshowImages().add(slideshowImage);
		return saveSlideshow();
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getQquuid() {
		return qquuid;
	}

	public void setQquuid(String qquuid) {
		this.qquuid = qquuid;
	}

	public String getQqfilename() {
		return qqfilename;
	}

	public void setQqfilename(String qqfilename) {
		this.qqfilename = qqfilename;
	}

	public String getQqtotalfilesize() {
		return qqtotalfilesize;
	}

	public void setQqtotalfilesize(String qqtotalfilesize) {
		this.qqtotalfilesize = qqtotalfilesize;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Slideshow getSlideshow() {
		return slideshow;
	}

	public void setSlideshow(Slideshow slideshow) {
		this.slideshow = slideshow;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public SlideshowImage getSlideshowImage() {
		return slideshowImage;
	}

	public void setSlideshowImage(SlideshowImage slideshowImage) {
		this.slideshowImage = slideshowImage;
	}

	// public String getTemplateId() {
	// return templateId;
	// }
	//
	// public void setTemplateId(String templateId) {
	// this.templateId = templateId;
	// }

	// public void validate() {
	// log.info("validating...");
	// List<String> uploadErrors = (List<String>) getActionErrors();
	// if (getFieldErrors().get("upload") != null) {
	// uploadErrors.addAll((List<String>) getFieldErrors().get("upload"));
	// }
	//
	// for (String err : uploadErrors) {
	// if (err.startsWith("File too large")
	// || err.startsWith("the request was rejected because its size")) {
	// clearErrorsAndMessages();
	// addActionError(MSG_KEY_ERROR_FILE_TOO_LARGE);
	// setSuccess(false);
	// break;
	// }
	// }
	// }
}
