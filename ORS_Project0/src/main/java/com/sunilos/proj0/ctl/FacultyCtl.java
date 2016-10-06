package com.sunilos.proj0.ctl;

import java.util.List;
import java.util.Locale;

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

import com.sunilos.proj0.dto.FacultyDTO;
import com.sunilos.proj0.dto.RoleDTO;
import com.sunilos.proj0.dto.UserDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.exception.DuplicateRecordException;
import com.sunilos.proj0.form.FacultyForm;
import com.sunilos.proj0.service.CollegeServiceInt;
import com.sunilos.proj0.service.FacultyServiceInt;
import com.sunilos.proj0.service.UserServiceInt;

@Controller
@RequestMapping(value = "/ctl/Faculty")
public class FacultyCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(FacultyCtl.class);

	@Autowired
	private FacultyServiceInt service;

	@Autowired
	private CollegeServiceInt colService;

	@Autowired
	private UserServiceInt userService;

	@Autowired
	private MessageSource messageSource;

	@Override
	public void preload(Model model) {

		try {
			List colList = colService.list();
			model.addAttribute("colList", colList);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}

		try {
			RoleDTO rolDto = new RoleDTO();
			UserDTO dto = new UserDTO();
			dto.setRoleId((long) rolDto.FACULTY);
			List userList = userService.search(dto);
			model.addAttribute("userList", userList);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}
		super.preload(model);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id,
			@ModelAttribute("form") FacultyForm form, Model model)
			throws ApplicationException {
		log.debug("FacultyCtl display method started");
		if (id != null && id > 0) {
			FacultyDTO dto = service.findByPK(id);
			form.populate(dto);
		}
		return "Faculty";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale,
			@RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid FacultyForm form,
			BindingResult bindingResult, Model model) {
		log.debug("FacultyCtl submit method started");

		if (bindingResult.hasErrors()) {
			return "Faculty";
		}
		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Faculty";
		}

		if (OP_SAVE.equalsIgnoreCase(operation)) {
			FacultyDTO dto = (FacultyDTO) form.getDto();

			try {
				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success",
							"Faculty updated successfully");
				} else {
					service.add(dto);
					String msg = messageSource.getMessage("label.success",
							null, locale);
					model.addAttribute("success", msg);
				}
			} catch (Exception e) {
				model.addAttribute("error", "Faculty already Exits");
				e.printStackTrace();
			}
			return "Faculty";
		} else if (OP_DELETE.equalsIgnoreCase(operation)) {
			try {
				service.delete(form.getId());
			} catch (ApplicationException e) {

				e.printStackTrace();
			}
			return "redirect:Faculty/search";
		}

		return operation;

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(Locale locale,
			@ModelAttribute("form") FacultyForm form, Model model)
			throws ApplicationException {

		log.debug("FacultyCtl search method started");
		FacultyDTO dto = (FacultyDTO) form.getDto();
		model.addAttribute("list",
				service.search(dto, form.getPageNo(), form.getPageSize()));

		return "FacultyList";

	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(@RequestParam(required = false) String operation,
			@ModelAttribute("form") FacultyForm form,
			BindingResult bindingResult, Locale locale)
			throws ApplicationException {

		int pageNo = form.getPageNo();

		if (OP_NEXT.equalsIgnoreCase(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equalsIgnoreCase(operation)) {
			pageNo--;
		}
		pageNo = (pageNo < 1) ? 1 : pageNo;
		form.setPageNo(pageNo);

		if (OP_DELETE.equalsIgnoreCase(operation) && form.getId() > 0) {
			service.delete(form.getId());
		}
		FacultyDTO dto = (FacultyDTO) form.getDto();
		service.search(dto, pageNo, form.getPageSize());
		return "FacultyList";

	}
}
