package com.sunilos.proj0.ctl;

import java.util.Iterator;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunilos.proj0.dto.CourseDTO;
import com.sunilos.proj0.exception.ApplicationException;
import com.sunilos.proj0.form.CourseForm;
import com.sunilos.proj0.service.CourseServiceInt;
@Controller
@RequestMapping(value="/ctl/Course")
public class CourseCtl extends BaseCtl{
	private static Logger logger=Logger.getLogger(CourseCtl.class);
	@Autowired
	private CourseServiceInt service;
	@Autowired
	private MessageSource messageSource;
	@RequestMapping(method=RequestMethod.GET)
	public String display(Locale locale,@RequestParam(required=false)Long id,@ModelAttribute("form")CourseForm form,Model model)throws ApplicationException{
		logger.debug("course Ctl display started"+id);
		if (id!=null&& id>0) {
			CourseDTO dto=service.findByPK(id);
			form.populate(dto);
			
			
		}
		return "Course";
		
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Locale locale,@RequestParam String operation,@ModelAttribute("form")@Valid CourseForm form,BindingResult bindingResult,Model model){
		logger.debug("CourseCtl submit method started");
		if (bindingResult.hasErrors()) {
			return "Course";
			
		}
		CourseDTO dto=(CourseDTO)form.getDto();
		try {
			
			if (OP_SAVE.equalsIgnoreCase(operation)) {
				if (dto.getId()>0) {
					service.update(dto);
					model.addAttribute("success", "data updated successfully");
					
				}else {
					Long id=service.add(dto);
					form.setId(id);
					String msg=messageSource.getMessage("message.success", null,locale);
					model.addAttribute("success", msg);
					
				}
				
			}else 
			if (OP_DELETE.equalsIgnoreCase(operation)) {
				service.delete(form.getId());
				String msg=messageSource.getMessage("message.success", null,locale);
				model.addAttribute("success", msg);
				return "redirect:Course/search";
				
				
			}{
				
			}
		
		} catch (Exception e) {
			logger.error(e);
			model.addAttribute("error", "Critical issue:Course name is already exist");
			
		}

		return "Course";
		
	}
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchList(@ModelAttribute("form") CourseForm form,Model model)throws ApplicationException{
		model.addAttribute("list", service.search(null,form.getPageNo(),form.getPageSize()));
		return "CourseList";
		
		
	}	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	
	public @ResponseBody String searchList(Locale locale,
			@ModelAttribute("form") CourseForm form,
			@RequestParam(required = false) String operation, Model model)
			throws ApplicationException {
		logger.debug("in courseCtl searchList method");
		int pageNo=form.getPageNo();
		if (OP_NEXT.equals(operation)) {
			pageNo++;
			
			
		}else {
			if (OP_PREVIOUS.equals(operation)) {
				pageNo--;
				
			}
			pageNo=(pageNo<1)?1:pageNo;
			form.setPageNo(pageNo);
			if (OP_DELETE.equals(operation) && form.getClass() != null) {
					service.delete(pageNo);
				}

				String msg = messageSource.getMessage("message.success", null,
						locale);
				model.addAttribute("success", msg);

			}

			// Get search attributes
			CourseDTO dto = (CourseDTO) form.getDto();

			model.addAttribute("list",
					service.search(dto, pageNo, form.getPageSize()));

			return "CollegeList";
		}

	}
