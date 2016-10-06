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

import com.sunilos.proj0.dto.MarksheetDTO;
import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.MarksheetForm;
import com.sunilos.proj0.service.MarksheetServiceInt;
import com.sunilos.proj0.service.StudentServiceInt;

@Controller
@RequestMapping(value = "/ctl/Marksheet")
public class MarksheetCtl extends BaseCtl {
	private static Logger log = Logger.getLogger(MarksheetCtl.class);

	@Autowired
	private MarksheetServiceInt service;

	@Autowired
	private StudentServiceInt studentService;

	@Autowired
	private MessageSource messageSource;

	@Override
	public void preload(Model model) {
		try {
			List list = studentService.list();
			model.addAttribute("studentList", list);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String display(@RequestParam(required = false) Long id,
			@ModelAttribute("form") MarksheetForm form, Model model)
			throws ApplicationException {
		if (id != null && id > 0) {
			MarksheetDTO dto = service.findByPK(id);
			System.out.println(dto.getId());
			form.populate(dto);
		}
		return "Marksheet";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale,
			@RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid MarksheetForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			/*
			 * int i= bindingResult.getErrorCount(); List list=
			 * bindingResult.getFieldErrors(); System.out.println(list.get(0));
			 */
			return "Marksheet";
		}

		if (OP_CANCEL.equalsIgnoreCase(operation)) {
			return "redirect:Marksheet";
		}
		try {
			if (OP_SAVE.equalsIgnoreCase(operation)) {

				MarksheetDTO dto = (MarksheetDTO) form.getDto();
				StudentDTO sdto = studentService.findByPK(form.getStudentId());
				dto.setName(sdto.getValue());

				if (dto.getId() > 0) {
					service.update(dto);
					model.addAttribute("success", "Data updated successfully");
				} else {
					Long id = service.add(dto);
					form.setId(id);
					String msg = messageSource.getMessage("message.success",
							null, locale);
					model.addAttribute("success", msg);
				}

			} else if (OP_DELETE.equalsIgnoreCase(operation)) {

				service.delete(form.getId());

				String msg = messageSource.getMessage("message.success", null,
						locale);
				model.addAttribute("success", msg);

				return "redirect:Marksheet/search";

			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error",
					"Critical Issue ,Student Name already exist ");
		}

		return "Marksheet";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") MarksheetForm form,
			Model model) throws ApplicationException {
		model.addAttribute("list",
				service.search(null, form.getPageNo(), form.getPageSize()));
		return "MarksheetList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale,
			@ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, Model model)
			throws ApplicationException {

		log.debug("in searchList method");

		// Calculate next page number
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

			String msg = messageSource.getMessage("message.success", null,
					locale);
			model.addAttribute("success", msg);
		}

		// Get search attributes
		MarksheetDTO dto = (MarksheetDTO) form.getDto();
		model.addAttribute("list",
				service.search(dto, form.getPageNo(), form.getPageSize()));

		return "MarksheetList";
	}

	@RequestMapping(value = "/meritlist", method = RequestMethod.GET)
	public String getMeritList(@ModelAttribute("form") MarksheetForm form,
			Model model) throws ApplicationException {
		List meritlist = service.getMeritList(0, 0);
		for (int i = 0; i < meritlist.size(); i++) {
			System.out.println(meritlist.get(i).toString());
		}
		model.addAttribute("list", meritlist);
		return "GetMeritList";

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public String getMarksheet(@ModelAttribute("form") MarksheetForm form,
			Model model) {
		log.debug("Marksheet Ctl getMarksheet method started");
		return "GetMarksheet";
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public String getMarksheet(@ModelAttribute("form") MarksheetForm form,
			@RequestParam(required = false) String operation, Model model,
			Locale locale) throws ApplicationException {
		log.debug("MarksheetCtl getMarksheet method started");

		if (OP_GET.equalsIgnoreCase(operation)) {
			MarksheetDTO dto = service.findByRollNo(form.getRollNo());
			if (dto != null) {

				form.populate(dto);
			} else {
				model.addAttribute("error", "Invalid Roll Number");
			}

		}

		return "GetMarksheet";
	}

}
