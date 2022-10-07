package edu.deakin.sit218.coachwebapp.controllers;
import edu.deakin.sit218.coachwebapp.entity.*;
import edu.deakin.sit218.coachwebapp.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question-answer")
public class ClientController {

	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		 Client client= new Client();
		 model.addAttribute("client",client);
		 return "question-answer";
		 
				 
		 
	}
}
