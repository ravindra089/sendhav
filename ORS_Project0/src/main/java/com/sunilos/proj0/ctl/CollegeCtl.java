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

import com.sunilos.proj0.dto.CollegeDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.CollegeForm;
import com.sunilos.proj0.service.CollegeServiceInt;

@Controller
@RequestMapping(value = "/ctl/College")
public class CollegeCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(CollegeCtl.class);

	@Autowired
	private CollegeServiceInt service;

	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String display(Locale locale,
			@RequestParam(required = false) Long id,
			@ModelAttribute("form") CollegeForm form, Model model)
			throws ApplicationException {

		log.debug(" CollegeCtl display started " + id);

		if (id != null && id > 0) {
			CollegeDTO dto = service.findByPK(id);
			form.populate(dto);
		}
		return "College";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid CollegeForm form,
			BindingResult bindingResult, Model model) {

		log.debug("CollegeCtl submit method started");

		if (bindingResult.hasErrors()) {
			return "College";
		}

		CollegeDTO dto = (CollegeDTO) form.getDto();

		try {
			if (OP_SAVE.equalsIgnoreCase(operation)) {
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

				return "redirect:College/search";
			}

		} catch (Exception e) {
			log.error(e);
			model.addAttribute("error",
					"Critical Issue ,College Name is already Exist");
		}
		return "College";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") CollegeForm form,
			Model model, @RequestParam(required = false) Integer pageNo)
			throws ApplicationException {
		if (pageNo == null) {
			pageNo = form.getPageNo();
		}
		List list = service.search(null, 0, 0);
		int size = list.size();
		int noOfPage = (int) Math.ceil(size * 1.0 / form.getPageSize());
		model.addAttribute("list",
				service.search(null, pageNo, form.getPageSize()));
		model.addAttribute("noOfPage", noOfPage);

		return "CollegeList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale,
			@ModelAttribute("form") CollegeForm form,
			@RequestParam(required = false) String operation, Model model)
			throws ApplicationException {

		log.debug("in collegectl searchList method");

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
		CollegeDTO dto = (CollegeDTO) form.getDto();

		model.addAttribute("list",
				service.search(dto, pageNo, form.getPageSize()));

		return "CollegeList";
	}

}
