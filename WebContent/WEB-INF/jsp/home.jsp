<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Liseygrams</title>
</head>
<body>
	<h1>Liseygrams</h1>
	<p>${currentGram.originalSentence}</p>
	<p>${currentGram.encodedSentence}</p>
	<div>
		<c:forEach var="letter" items="${currentGram.encodedList}">
			<div style="display: inline-block">
				<p>${letter}</p>
			</div>
		</c:forEach>
	</div>
	<div>
		<c:forEach var="letter" items="${currentGram.decodedList}">
			<div style="display: inline-block">
				<p>${letter}</p>
			</div>
		</c:forEach>
	</div>
	
	<c:url var="formAction" value="/"/>
	<form action="${formAction}" method="POST">
		<label for="from">Change the letter: </label>
		<input type="text" name="from"/>
		<label for="to">To the letter: </label>
		<input type="text" name="to"/>
		<button type="submit">Submit</button>
	</form>
</body>
</html>