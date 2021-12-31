package com.miw.presentation.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.RequestAware;

import com.miw.model.User;
import com.miw.presentation.user.UserManagerServiceHelper;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Results({ @Result(name = "success", location = "/index.jsp"),
		@Result(name = "register-error", location = "/WEB-INF/content/register-form.jsp"),

		// For validation
		@Result(name = "input", location = "/WEB-INF/content/register-form.jsp") })

@Validations(requiredStrings = {
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newUser.user", message = "You must enter a value for login."),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newUser.password", message = "You must enter a value for password."),
		@RequiredStringValidator(type = ValidatorType.SIMPLE, fieldName = "newUser.cPassword", message = "You must confirm password.") })
public class RegisterAction extends ActionSupport implements RequestAware {
	Logger logger = LogManager.getLogger(this.getClass());
	private static final long serialVersionUID = -3854762737466390371L;
	private User newUser = null;

	private Map<String, Object> request;

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
		this.newUser.setAdmin(false);
	}

	@Override
	public void validate() {
		logger.debug("Invoking validate!");

		if (!this.newUser.getPassword().equals(this.newUser.getcPassword()))
			addFieldError("newUser.cPassword", "Passwords do not match");

		super.validate();
	}

	@Override
	public String execute() throws Exception {

		UserManagerServiceHelper helper = new UserManagerServiceHelper();

		logger.debug("User registered: " + newUser);
		boolean userInserted = helper.insertUser(newUser);

		if (userInserted)
			return SUCCESS;
		else {
			request.put("userexists", "User already exists");
			return "register-error";
		}

	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
