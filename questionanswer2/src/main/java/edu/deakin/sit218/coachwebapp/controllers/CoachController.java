package edu.deakin.sit218.coachwebapp.controllers;

import javax.validation.Valid;

import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.deakin.sit218.coachwebapp.dao.Vivadao;
import edu.deakin.sit218.coachwebapp.dao.Vivadaoimp;
import edu.deakin.sit218.coachwebapp.entity.*;

@Controller
@RequestMapping("/workout")
public class CoachController {

	@RequestMapping("/processForm")
	public String workout(@Valid @ModelAttribute("client") Client client ,
				BindingResult ValidationErrors,
				Model model) {
		
		
			if(ValidationErrors.hasErrors())
			return "question-answer";
		Vivadao vivadao = new Vivadaoimp();
	
			vivadao.insertData(client);

		
		model.addAttribute("message"," Your Question Is "+client.getQuestion()
				+"  Answer Submitted "+client.getAnswer()
						+ " Area of Knowledge"+client.getAreaofKnowledge());
		return "workout";
	
} 
}