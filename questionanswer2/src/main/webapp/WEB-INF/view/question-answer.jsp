<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question and Answer Portal </title>
<style>
.body{
background-color: #ffbf00;

}
.form
{
	background-color:white;
	font-family: "Times New Roman";
}
</style>
</head>
<body class="body">
<h1> Deakin Question Portal </h1>
<form:form class="form" action="${pageContext.request.contextPath}/workout/processForm" 
		modelAttribute="client" >
	
		Enter Your Question<form:input path="question"/>
		<form:errors path="question" style ="color:red" /><br> <br>
	 	Submit your Answer<form:input path="answer"/>
	 	<form:errors path="answer" style ="color:red" /><br> <br>
	 	Select Area of Knowledge  <form:input  path="areaofKnowledge"/>
	 		<form:errors path="areaofKnowledge" style ="color:red" /><br> <br>
	 	 <br> <br>
		
	<input type="submit" value="Submit" />
		
</form:form>		



</body>
	
</html>