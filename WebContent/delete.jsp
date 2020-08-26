<%@page import="java.sql.*,java.util.*"%>
<%
	String id = request.getParameter("id") ; 
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo_liste ?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
	Statement st=conn.createStatement();
	int i=st.executeUpdate("DELETE FROM todos WHERE id="+id);

	}
	catch(Exception e)
	{
	System.out.print(e);
	e.printStackTrace();
	}
	response.sendRedirect("http://localhost:8080/todo_lis_app_jee/accueil") ;
%>

