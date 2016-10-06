package com.sunilos.proj0.ctl;

import java.util.List;
import java.util.Locale;

import javax.persistence.criteria.From;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sunilos.proj0.dto.CollegeDTO;
import com.sunilos.proj0.dto.StudentDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.StudentForm;
import com.sunilos.proj0.service.CollegeServiceInt;
import com.sunilos.proj0.service.StudentServiceInt;

@Controller
@RequestMapping(value = "/ctl/Student")
public class StudentCtl extends BaseCtl {

	private static Logger log = Logger.getLogger(StudentCtl.class);

	@Autowired
	private StudentServiceInt service;

	@Autowired
	private CollegeServiceInt collegeService;

	@Autowired
	MessageSource messageSource;

	@Override
	public void preload(Model model) {
		List list;
		try {
			list = collegeService.list();
			model.addAttribute("collegeList", list);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}

		List studentList;
		try {
			studentList = service.list();
			model.addAttribute("list", studentList);
		} catch (ApplicationException e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(method = RequestMethod.GET)
	public String dispaly(@RequestParam(required = false) Long id,
			@ModelAttribute("form") StudentForm form, Model model)
			throws ApplicationException {
		log.debug("StudentCtl display method started");

		if (id != null && id > 0) {
			form.populate(service.findByPK(id));
		}

		return "Student";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(Locale locale,
			@RequestParam(required = false) String operation,
			@ModelAttribute("form") @Valid StudentForm form,
			BindingResult bindingResult, Model model, HttpSession session) {
		log.debug("StudentCtl submit method started");
		if (OP_CANCEL.equals(operation)) {
			return "redirect:Student";
		}
		if (bindingResult.hasErrors()) {
			return "Student";
		}

		try {
			if (OP_SAVE.equalsIgnoreCase(operation)) {
				StudentDTO dto = (StudentDTO) form.getDto();
				CollegeDTO colDto = collegeService
						.findByPK(form.getCollegeId());
				dto.setCollegeName(colDto.getName());
				if (dto.getId() > 0) {
					service.update(dto);

					model.addAttribute("success",
							"Data is updated successfully");

				} else {
					Long id = service.add(dto);
					form.setId(id);
					String msg = messageSource.getMessage("message.success",
							null, locale);
					model.addAttribute("success", msg);

				}
			}

			else if (OP_DELETE.equalsIgnoreCase(operation)) {
				service.delete(form.getId());

				String msg = messageSource.getMessage("message.success", null,
						locale);
				model.addAttribute("success", msg);

				return "redirect:Student/search";
			}

		} catch (Exception e) {
			model.addAttribute("error", "LoginId alredy Exist ");
			log.error(e);
			e.printStackTrace();
		}

		return "Student";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchList(@ModelAttribute("form") StudentForm form,
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
		log.debug("studentCtl search list method started");
		StudentDTO dto = (StudentDTO) form.getDto();
		model.addAttribute("list",
				service.search(dto, form.getPageNo(), form.getPageSize()));

		return "StudentList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchList(Locale locale,
			@ModelAttribute("form") StudentForm form,
			@RequestParam(required = false) String operation, Model model)
			throws Exception {

		log.debug("StudentCtl search list methos started");

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
		StudentDTO dto = (StudentDTO) form.getDto();

		model.addAttribute("list",
				service.search(dto, pageNo, form.getPageSize()));

		return "StudentList";
	}

}
