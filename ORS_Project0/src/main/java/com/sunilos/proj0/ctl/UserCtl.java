package com.sunilos.proj0.ctl;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.swing.text.rtf.RTFEditorKit;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.form.ChangePasswordForm;
import com.sunilos.proj0.form.MyProfileForm;
import com.sunilos.proj0.form.UserForm;
import com.sunilos.proj0.form.UserListForm;
import com.sunilos.proj0.service.RoleServiceInt;
import com.sunilos.proj0.service.UserServiceInt;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(UserCtl.class);

	@Autowired
	private UserServiceInt service;

	@Autowired
	private RoleServiceInt roleservice;

	@Autowired
	MessageSource messageSource;

	@Override
	public void preload(Model model) {
		try {
			List list = roleservice.list();
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).toString());
			}

			model.addAttribute("roleList", list);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id,
			@ModelAttribute("form") UserForm form, Model model)
			throws ApplicationException {
		log.debug("UserCtl dispaly method Started");
		if (id != null && id > 0) {
			UserDTO dto = service.findByPK(id);
			form.populate(dto);
		}
		return "User";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid UserForm form,
			BindingResult bindingResult, HttpSession session, Model model)
			throws ApplicationException {
		log.debug("UserCtl submit started");
		if (bindingResult.hasErrors()) {
			return "User";
		}

		if (OP_SAVE.equals(operation)) {
			UserDTO dto = (UserDTO) form.getDto();
			try {
				System.out.println("form" + form.getRoleId());
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success",
							"User is updated successfully");
				} else {
					long pk = service.add(dto);
					model.addAttribute("success", "User is added successfully");
					form.setId(pk);
				}
			} catch (DuplicateRecordException e) {
				log.error(e);
				model.addAttribute("error", "LoginId already Exist");
				e.printStackTrace();
			}
			return "User";
		} else if (OP_DELETE.equals(operation)) {
			try {
				service.delete(form.getId());
			} catch (Exception e) {
				log.error(e);
				e.printStackTrace();
			}
			return "redirect:User/search";
		} else if (OP_CANCEL.equals(operation)) {
			if (form.getId() > 0) {
				return "redirect:User";
			}
		}
		return "User";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") UserForm form, Model model)
			throws ApplicationException {
		log.debug("searchList method by request  Getmethod started");
		UserDTO dto = (UserDTO) form.getDto();
		/*
		 * int index = ((form.getPageNo() - 1) * form.getPageSize()) + 1;
		 * model.addAttribute("index", index);
		 */
		model.addAttribute("list",
				service.search(dto, form.getPageNo(), form.getPageSize()));
		return "UserList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Model model,
			@ModelAttribute("form") UserForm form,
			@RequestParam(required = false) String operation, Locale locale)
			throws ApplicationException {
		log.debug("In searchList Method");

		int pageNo = form.getPageNo();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;
		form.setPageNo(pageNo);

		if (OP_DELETE.equals(operation) && form.getIds() != null) {
			for (long id : form.getIds()) {
				service.delete(id);
			}
		}

		UserDTO dto = (UserDTO) form.getDto();
		List list = service.search(dto, pageNo, form.getPageSize());
		model.addAttribute("list", list);
		return "UserList";

	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String dispalyProfile(HttpSession session,
			@ModelAttribute("form") MyProfileForm form, Model model)
			throws ApplicationException {
		log.debug("MyProfileCtl dispaly method started");
		UserDTO dto = (UserDTO) session.getAttribute("user");
		UserDTO dto2 = service.findByPK(dto.getId());
		form.populate(dto2);
		return "MyProfile";

	}

	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public String submitProfile(Locale locale,
			@RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid MyProfileForm form,
			BindingResult bindingResult, Model model)
			throws ApplicationException {
		log.debug("MyProfileCtl submit method started");

		if (bindingResult.hasErrors()) {
			return "MyProfile";
		}

		UserDTO dto = service.findByPK(form.getId());
		dto.setLogin(form.getLogin());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setGender(form.getGender());
		dto.setMobileNo(form.getMobileNo());
		dto.setDob(new Date(form.getDob()));
		try {
			service.update(dto);
			/*
			 * String msg = messageSource.getMessage("message.success", null,
			 * locale); model.addAttribute("success", msg);
			 */
			model.addAttribute("success", "Data is successfully updated");
		} catch (DuplicateRecordException e) {
			model.addAttribute("error", "LoginId does not exist");

			e.printStackTrace();
		}
		if (OP_CANCEL.equals(form.getOperation())) {

			return "AboutUs";

		}
		return "MyProfile";

	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String displayChangePassword(
			@ModelAttribute("form") ChangePasswordForm form, Model model) {
		log.debug("dispalyChangePassword started");
		return "ChangePassword";

	}

	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String submitChangePassword(Locale locale,
			@RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid ChangePasswordForm form,
			BindingResult bindingResult, Model model, HttpSession session)
			throws DuplicateRecordException, ApplicationException {
		log.debug("submitChangePassword Started");
		if (OP_CANCEL.equals(operation)) {
			return "Welcome";
		}
		if (bindingResult.hasErrors()) {
			return "ChangePassword";
		}

		if (OP_CANCEL.equals(operation)) {
			return "MyProfile";
		}

		if (form.getNewpassword().equals(form.getConfirmpassword())) {
			UserDTO dto = (UserDTO) session.getAttribute("user");

			dto = service.findByPK(dto.getId());
			if (dto.getPassword().equals(form.getOldpassword())) {
				dto.setPassword(form.getNewpassword());
				service.update(dto);

				model.addAttribute("success", "Password Changed successfully");
			} else {
				model.addAttribute("error", "Old Pasword is not valid");
			}

		} else {
			model.addAttribute("error",
					"New password and confirm Password does not match");
		}

		return "ChangePassword";

	}
}
