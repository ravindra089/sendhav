package com.sunilos.proj0.ctl;

import java.util.Locale;

import javax.management.relation.RoleList;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.RoleForm;
import com.sunilos.proj0.service.RoleServiceInt;

@Controller
@RequestMapping(value = "/ctl/Role")
public class RoleCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(RoleCtl.class);

	@Autowired
	private RoleServiceInt service;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id,
			@ModelAttribute("form") RoleForm form, Model model,
			HttpSession session) throws ApplicationException {
		log.debug("RoleCtl doDisplay started");
		if (id != null && id > 0) {

			form.populate(service.findByPK(id));
		}
		return "Role";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale,
			@ModelAttribute("form") @Valid RoleForm form,
			BindingResult bindingResult,
			@RequestParam(required = false) String operation, Model model) {
		log.debug("RoleCtl submit method started");

		if (OP_CANCEL.equals(operation)) {
			return "redirect:Role";
		}
		if (bindingResult.hasErrors()) {
			return "Role";
		}

		try {
			if (OP_SAVE.equals(operation)) {
				RoleDTO dto = (RoleDTO) form.getDto();
				if (dto.getId() > 0) {
					service.update(dto);

					model.addAttribute("success",
							"Data is updated successfully");
				} else {
					long id = service.add(dto);
					form.setId(id);
					String msg = messageSource.getMessage("message.success",
							null, locale);
					model.addAttribute("success", msg);

				}
			}
		} catch (Exception e) {
			model.addAttribute("error", "RoleId is already Exist" );
			e.printStackTrace();
		}

		return "Role";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") RoleForm form, Model model)
			throws ApplicationException {
		RoleDTO dto = (RoleDTO) form.getDto();
		model.addAttribute("list",
				service.search(dto, form.getPageNo(), form.getPageSize()));

		return "RoleList";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale,
			@ModelAttribute("form") RoleForm form, BindingResult bindingResult,
			@RequestParam(required = false) String operation, Model model)
			throws ApplicationException {
		log.debug("RoleCtl list submit method started");

		int pageNo = form.getPageNo();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;

		if (OP_DELETE.equals(operation) && form.getIds() != null) {
			for (long id : form.getIds()) {
				service.delete(id);
			}
			String msg = messageSource.getMessage("message.success", null,
					locale);
			model.addAttribute("success", msg);
		}
		RoleDTO dto = (RoleDTO) form.getDto();
		model.addAttribute("list",
				service.search(dto, pageNo, form.getPageSize()));
		return "RoleList";

	}
}
