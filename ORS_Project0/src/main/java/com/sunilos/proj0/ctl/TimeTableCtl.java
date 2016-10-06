package com.sunilos.proj0.ctl;

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

import com.sunilos.proj0.dto.TimeTableDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.TimeTableForm;
import com.sunilos.proj0.service.TimeTableServiceInt;

@Controller
@RequestMapping(value = "/ctl/TimeTable")
public class TimeTableCtl extends BaseCtl {
	private static Logger logger = Logger.getLogger(TimeTableCtl.class);
	@Autowired
	private TimeTableServiceInt service;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET)
	public String display(Locale locale,
			@RequestParam(required = false) Long id,
			@ModelAttribute("form") TimeTableForm form, Model model)
			throws ApplicationException {
		logger.debug("timetable ctl display started" + id);
		if (id != null && id > 0) {
			TimeTableDTO dto = service.findByPK(id);
			form.populate(dto);

		}
		return "TimeTable";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale, @RequestParam String operation,
			@ModelAttribute("form") @Valid TimeTableForm form,
			BindingResult bindingResult, Model model) {

		logger.debug("TimeTable submit method started");

		if (bindingResult.hasErrors()) {
			return "TimeTable";
		}

		TimeTableDTO dto = (TimeTableDTO) form.getDto();

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

				return "redirect:TimeTable/search";
			}

		} catch (Exception e) {
			logger.error(e);
			model.addAttribute("error",
					"Critical Issue ,TimeTable Name is already Exist");
		}
		return "TimeTable";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") TimeTableForm form,
			Model model) throws ApplicationException {
		model.addAttribute("list",
				service.search(null, form.getPageNo(), form.getPageSize()));
		return "TimeTableList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale,
			@ModelAttribute("form") TimeTableForm form,
			@RequestParam(required = false) String operation, Model model)
			throws ApplicationException {

		logger.debug("in TimeTableCtl searchList method");

		// Calculate next page number
		int pageNo = form.getPageNo();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		}

		pageNo = (pageNo < 1) ? 1 : pageNo;

		form.setPageNo(pageNo);

		

		// Get search attributes
		TimeTableDTO dto = (TimeTableDTO) form.getDto();

		model.addAttribute("list",
				service.search(dto, pageNo, form.getPageSize()));

		return "TimeTableList";

	}
}