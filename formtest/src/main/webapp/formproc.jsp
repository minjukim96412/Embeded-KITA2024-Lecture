<% 
	String txt = request.getParameter("txt");
	out.print("text : " + txt);
	String rdo = request.getParameter("rdo");
	out.print("rdo : " + rdo);
	String email = request.getParameter("email");
	out.print("email : " + email);
	String date = request.getParameter("date");
	out.print("date : " + date);
	String number = request.getParameter("number");
	out.print("number : " + number);
%>