<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Todo list</title>
</head>
	<style type="text/css">
	     <%@include file="todo.css" %>
	</style>
	<body>
		<h1>Todo list</h1>
		<div>
			<h2>Pour ajouter une tâche c'est ici : </h2>
			<form method="post" action='accueil'>
				<input type = "text" id="newTodo" name="newTodo" placeholder="Entrez une tâche et cliquez sur 'Ajouter'">
				<input type="submit" id="newTodoButton" name="ajouter" value="Ajouter">
				<c:forEach items="${ tasks }" var="tache" varStatus="status" >
					<p class="item"><c:out value="${ tache.name }"  />
				  		<a href="delete.jsp?id=${ tache.id }">Supprimer cette tâche</a>          
			     	</p>
				</c:forEach>
			</form>
		</div>
	</body>
</html>

