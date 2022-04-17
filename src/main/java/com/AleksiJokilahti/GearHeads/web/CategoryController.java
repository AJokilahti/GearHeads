package com.AleksiJokilahti.GearHeads.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AleksiJokilahti.GearHeads.domain.Category;
import com.AleksiJokilahti.GearHeads.domain.CategoryRepository;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository repository;
	
	@RequestMapping(value="/categorylist", method = RequestMethod.GET)
	public String CategoryList(Model model) {
		model.addAttribute("categorylist", repository.findAll());
		return "categorylist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category){
		repository.save(category);
		return "redirect:categorylist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/deletecategory/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") Long id) {
		repository.deleteById(id);
		return "redirect:../categorylist";
	}
}
