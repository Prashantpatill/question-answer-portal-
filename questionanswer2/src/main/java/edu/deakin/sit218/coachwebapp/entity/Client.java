package edu.deakin.sit218.coachwebapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name ="viva")
public class Client {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	protected int no ;
	
	@NotNull(message = "Mandatory Field")
	@Size(min = 1,message = "Cannot be blank")
	@Column(name = "question")
	protected String question;
	
	@NotNull(message = "Mandatory Field")
	@Size(min = 1,message = "Cannot be blank ")
	@Column(name = "answer")
	protected String answer;
	
	@NotNull(message = "Mandatory Field")
	@Size(min = 1,message = "Cannot be blank ")
	@Column(name = "areaofknowledge")
	protected String areaofKnowledge;
 	  public String getAreaofKnowledge() {
		return areaofKnowledge;
	}

	public void setAreaofKnowledge(String areaofKnowledge) {
		this.areaofKnowledge = areaofKnowledge;
	}

	public String getQuestion() { return question; }
	  
	  public void setQuestion(String question) { this.question = question; }
	  
	  public String getAnswer() { return answer; }
	  
	  public void setAnswer(String answer) { this.answer = answer; }
	  
	  public Client() {
		}
	  
	  public Client(String question, String answer, String areaofKnowledge) {
			super();
			this.question = question;
			this.answer = answer;
			this.areaofKnowledge=areaofKnowledge;
		}
	  @Override
		public String toString() {
			return "client = [question: "+getQuestion()+", answer: "+getAnswer()+
					", areaofKnowledge: "+ getAreaofKnowledge()+"]";
		}
}
