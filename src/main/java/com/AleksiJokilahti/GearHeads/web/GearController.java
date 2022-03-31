package com.AleksiJokilahti.GearHeads.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GearController {

	@RequestMapping(value = "/gear", method = RequestMethod.GET)
	public String Instruments(Model model) {
		return "gear";
	}
}
