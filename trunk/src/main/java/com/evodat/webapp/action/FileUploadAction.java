package com.evodat.webapp.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.evodat.Constants;

/**
 * Sample action that shows how to do file upload with Struts 2.
 */

public class FileUploadAction extends BaseAction {
	private static final long serialVersionUID = -9208910183310010569L;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private boolean success;
	// private boolean preventRetry = true;
	// private boolean reset = true;
	// private transient String error = "";
	private String newUuid;
	final String MSG_KEY_ERROR_FILE_TOO_LARGE = "MSG_KEY_ERROR_FILE_TOO_LARGE";

	/**
	 * Upload the file
	 * 
	 * @return String with result (cancel, input or sucess)
	 * @throws Exception
	 *             if something goes wrong
	 */
	public String upload() {
		log.info("upload...");
		validate();
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
			bos = new FileOutputStream(uploadDir + fileFileName);
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
				dirPath.getPath() + Constants.FILE_SEP + fileFileName);

		String link = getRequest().getContextPath() + "/images" + "/";

		getRequest().setAttribute("link", link + fileFileName);
		setSuccess(true);
		return SUCCESS;
	}

	/**
	 * Default method - returns "input"
	 * 
	 * @return "input"
	 */
	public String execute() {
		return INPUT;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	// public boolean isPreventRetry() {
	// return preventRetry;
	// }
	//
	// public void setPreventRetry(boolean preventRetry) {
	// this.preventRetry = preventRetry;
	// }
	//
	// public boolean isReset() {
	// return reset;
	// }
	//
	// public void setReset(boolean reset) {
	// this.reset = reset;
	// }
	//
	// public String getError() {
	// return error;
	// }
	//
	// public void setError(String error) {
	// this.error = error;
	// }

	public void validate() {
		log.info("validating...");
		List<String> uploadErrors = (List<String>) getActionErrors();
		if (getFieldErrors().get("upload") != null) {
			uploadErrors.addAll((List<String>) getFieldErrors().get("upload"));
		}

		for (String err : uploadErrors) {
			if (err.startsWith("File too large")
					|| err.startsWith("the request was rejected because its size")) {
				clearErrorsAndMessages();
				addActionError(MSG_KEY_ERROR_FILE_TOO_LARGE);
				setSuccess(false);
				break;
			}
		}
	}
}
