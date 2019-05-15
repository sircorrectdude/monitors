package com.evodat.webapp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evodat.service.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.evodat.Constants;
import com.evodat.model.User;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Implementation of <strong>ActionSupport</strong> that contains convenience
 * methods for subclasses. For example, getting the current user and saving
 * messages/errors. This class is intended to be a base class for all Action
 * classes.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class BaseAction extends ActionSupport {
	private static final long serialVersionUID = 3525445612504421307L;

	/**
	 * Constant for cancel result String
	 */
	public static final String CANCEL = "cancel";

	/**
	 * Transient log to prevent session synchronization issues - children can
	 * use instance for logging.
	 */
	protected final transient Log log = LogFactory.getLog(getClass());

	/**
	 * The UserManager
	 */
	protected UserManager userManager;

	/**
	 * The RoleManager
	 */
	protected RoleManager roleManager;

	/**
	 * The MonitorManager
	 */
	protected MonitorManager monitorManager;

	/**
	 * The TemplateManager
	 */
	protected TemplateManager templateManager;

	/**
	 * The CourseManager
	 */
	protected CourseManager courseManager;

	/**
	 * The ScreenManager
	 */
	protected ScreenManager screenManager;

	/**
	 * The CalendarManager
	 */
	protected JCalendarManager jCalendarManager;

	/**
	 * The CarparkManager
	 */
	protected CarparkManager carparkManager;
	
	
	protected LicensePlateManager licensePlateManager;
	
	protected CarparkHistoryManager carparkHistoryManager;

	protected MealManager mealManager;

    protected MealCourseManager mealCourseManager;

	protected MealEventManager mealEventManager;

	protected MealEventRoomManager mealEventRoomManager;

	protected PortionManager portionManager;

	/**
	 * The FloorManager
	 */
	protected FloorManager floorManager;

	/**
	 * Indicator if the user clicked cancel
	 */
	protected String cancel;

	public void setjCalendarManager(JCalendarManager jCalendarManager) {
		this.jCalendarManager = jCalendarManager;
	}

	/**
	 * Indicator for the page the user came from.
	 */
	protected String from;

	/**
	 * Set to "delete" when a "delete" request parameter is passed in
	 */
	protected String delete;

	/**
	 * Set to "save" when a "save" request parameter is passed in
	 */
	protected String save;

	/**
	 * MailEngine for sending e-mail
	 */
	protected MailEngine mailEngine;

	/**
	 * A message pre-populated with default data
	 */
	protected SimpleMailMessage mailMessage;

	/**
	 * Velocity template to use for e-mailing
	 */
	protected String templateName;

	/**
	 * Simple method that returns "cancel" result
	 * 
	 * @return "cancel"
	 */
	public String cancel() {
		return CANCEL;
	}

	/**
	 * Save the message in the session, appending if messages already exist
	 * 
	 * @param msg
	 *            the message to put in the session
	 */
	@SuppressWarnings("unchecked")
	protected void saveMessage(String msg) {
		List messages = (List) getRequest().getSession().getAttribute(
				"messages");
		if (messages == null) {
			messages = new ArrayList();
		}
		messages.add(msg);
		getRequest().getSession().setAttribute("messages", messages);
	}

	/**
	 * Convenience method to get the Configuration HashMap from the servlet
	 * context.
	 * 
	 * @return the user's populated form from the session
	 */
	protected Map getConfiguration() {
		Map config = (HashMap) getSession().getServletContext().getAttribute(
				Constants.CONFIG);
		// so unit tests don't puke when nothing's been set
		if (config == null) {
			return new HashMap();
		}
		return config;
	}

	protected User getCurrentUser() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		if (ctx != null) {
			Authentication auth = ctx.getAuthentication();
			if (auth != null && (auth.getPrincipal() instanceof User)) {
				User user = (User) auth.getPrincipal();
				return user;
			}
		}
		return null;
	}

	/**
	 * Convenience method to get the request
	 * 
	 * @return current request
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * Convenience method to get the response
	 * 
	 * @return current response
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * Convenience method to get the session. This will create a session if one
	 * doesn't exist.
	 * 
	 * @return the session from the request (request.getSession()).
	 */
	protected HttpSession getSession() {
		return getRequest().getSession();
	}

	/**
	 * Convenience method to send e-mail to users
	 * 
	 * @param user
	 *            the user to send to
	 * @param msg
	 *            the message to send
	 * @param url
	 *            the URL to the application (or where ever you'd like to send
	 *            them)
	 */
	protected void sendUserMessage(User user, String msg, String url) {
		if (log.isDebugEnabled()) {
			log.debug("sending e-mail to user [" + user.getEmail() + "]...");
		}

		mailMessage.setTo(user.getFullName() + "<" + user.getEmail() + ">");

		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", user);
		// TODO: figure out how to get bundle specified in struts.xml
		// model.put("bundle", getTexts());
		model.put("message", msg);
		model.put("applicationURL", url);
		mailEngine.sendMessage(mailMessage, templateName, model);
	}

	public void setTemplateManager(TemplateManager templateManager) {
		this.templateManager = templateManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public void setRoleManager(RoleManager roleManager) {
		this.roleManager = roleManager;
	}

	public void setMonitorManager(MonitorManager monitorManager) {
		this.monitorManager = monitorManager;
	}

	public void setMailEngine(MailEngine mailEngine) {
		this.mailEngine = mailEngine;
	}

	public void setMailMessage(SimpleMailMessage mailMessage) {
		this.mailMessage = mailMessage;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setCourseManager(CourseManager courseManager) {
		this.courseManager = courseManager;
	}

	/**
	 * Convenience method for setting a "from" parameter to indicate the
	 * previous page.
	 * 
	 * @param from
	 *            indicator for the originating page
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public void setScreenManager(ScreenManager screenManager) {
		this.screenManager = screenManager;
	}

	public void setCarparkManager(CarparkManager carparkManager) {
		this.carparkManager = carparkManager;
	}

	public void setFloorManager(FloorManager floorManager) {
		this.floorManager = floorManager;
	}

	public void setCarparkHistoryManager(CarparkHistoryManager carparkHistoryManager) {
		this.carparkHistoryManager = carparkHistoryManager;
	}

	public void setLicensePlateManager(LicensePlateManager licensePlateManager) {
		this.licensePlateManager = licensePlateManager;
	}

	public MealManager getMealManager() {
		return mealManager;
	}

	public void setMealManager(MealManager mealManager) {
		this.mealManager = mealManager;
	}

    public MealCourseManager getMealCourseManager() {
        return mealCourseManager;
    }

    public void setMealCourseManager(MealCourseManager mealCourseManager) {
        this.mealCourseManager = mealCourseManager;
    }

	public MealEventManager getMealEventManager() {
		return mealEventManager;
	}

	public void setMealEventManager(MealEventManager mealEventManager) {
		this.mealEventManager = mealEventManager;
	}

	public MealEventRoomManager getMealEventRoomManager() {
		return mealEventRoomManager;
	}

	public void setMealEventRoomManager(MealEventRoomManager mealEventRoomManager) {
		this.mealEventRoomManager = mealEventRoomManager;
	}

	public PortionManager getPortionManager() {
		return portionManager;
	}

	public void setPortionManager(PortionManager portionManager) {
		this.portionManager = portionManager;
	}
}
