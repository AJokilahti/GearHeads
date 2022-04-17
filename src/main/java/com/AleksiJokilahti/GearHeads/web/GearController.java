package com.AleksiJokilahti.GearHeads.web;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.AleksiJokilahti.GearHeads.domain.CategoryRepository;
import com.AleksiJokilahti.GearHeads.domain.Instrument;
import com.AleksiJokilahti.GearHeads.domain.InstrumentRepository;
import com.AleksiJokilahti.GearHeads.domain.UserRepository;
import com.AleksiJokilahti.GearHeads.domain.User;

@Controller
public class GearController {

	@Autowired
	private InstrumentRepository instrumentrepository;
	
	@Autowired
	private CategoryRepository categoryrepository;
	
	@Autowired
	private UserRepository userrepository;
	
	
		//RESTful service to get all gear
	    // Java-kielinen Gear-luokan oliolista muunnetaan JSON-instrumenttilistaksi ja 
	    // lähetetään web-selaimelle vastauksena
		/*@RequestMapping(value = "/gear", method = RequestMethod.GET)
		public String Instruments(Model model) {
			model.addAttribute("gear", instrumentrepository.findAll());
			return "gear";
		}*/
		
		@RequestMapping(value = "/gear", method = RequestMethod.GET)
		public String OwnerInstruments(Model model,  Principal principal) {
			String username = principal.getName(); //get logged in username

			User user = userrepository.findByUsername(username);
			if (user.getUsername() == "Admin") {
				model.addAttribute("gear", instrumentrepository.findAll());
			} else {
			model.addAttribute("gear", instrumentrepository.findByOwner(user));
			}
			return "gear";
		}
		
		@PreAuthorize("hasAuthority('USER')")
		@RequestMapping(value = "/addinstrument")
		public String addInstrument(Model model, Principal principal) {
			String username = principal.getName(); //get logged in username

			User user = userrepository.findByUsername(username);
			model.addAttribute("owner", user.getUserId());
			System.out.println(user.getUsername() + " JA ID: " + user.getUserId());
			model.addAttribute("instrument", new Instrument(user));
			model.addAttribute("categories", categoryrepository.findAll());
			return "addinstrument";
		}
		
		@PreAuthorize("hasAuthority('USER')")
		@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String save(Instrument instrument) {
			System.out.println("TAPAHTUUKO MITÄÄN? " + instrument);
			instrumentrepository.save(instrument);
			return "redirect:gear";
		}
		
		
		@PreAuthorize("hasAuthority('USER')")
		@RequestMapping(value="/editinfo/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
			model.addAttribute("instrument", instrumentrepository.findById(id));
			model.addAttribute("categories", categoryrepository.findAll());
			return "editinstrument";
		}
		
		
		@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable("id") Long id) {
			instrumentrepository.deleteById(id);
			return "redirect:../gear";
		}

}
