package com.AleksiJokilahti.GearHeads.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AleksiJokilahti.GearHeads.domain.CategoryRepository;
import com.AleksiJokilahti.GearHeads.domain.InstrumentRepository;

@Controller
public class GearController {

	@Autowired
	private InstrumentRepository instrumentrepository;
	
	@Autowired
	private CategoryRepository categoryrepository;
	
		@RequestMapping(value = "/gear", method = RequestMethod.GET)
		public String Instruments(Model model) {
			model.addAttribute("gear", instrumentrepository);
			return "gear";
		}
		
		
}
