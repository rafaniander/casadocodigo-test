<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <spring:hasBindErrors name="product">
		<ul>
		<c:forEach var="error" items="${errors.allErrors}">	
			<li>${error.code}-${error.field}</li>
		</c:forEach>
		</ul>
	</spring:hasBindErrors>
        <form:form action="${spring:mvcUrl('PC#save').build()}" 
                   method="post" 
                   commandName="product"
                   enctype="multipart/form-data">
            <div>
                <label for="title">Titulo</label>
                <form:input path="title"/>
                <form:errors path="title"/>
            </div>
            <div>
                <label for="description">Descrição</label>
                <form:textarea path="description" rows="10" cols="20"/>
                <form:errors path="description"/>
            </div>
            <div>
                <label for="pages">Número de páginas</label>
                <form:input path="pages"/>
                <form:errors path="pages"/>
            </div>
            <div>
                <label for="releaseDate">Data de lançamento</label>
                <form:input path="releaseDate" type="date"/>												
                <form:errors path="releaseDate"/>
            </div>	
            <div>
                <label for="summary">Sumario do livro</label>
                <input name="summary" type="file"/>                
                <form:errors path="summaryPath"/>				
            </div>	
            <c:forEach items="${types}" var="bookType" varStatus="status">
                <div>
                    <label for="price_${bookType}">${bookType}</label>
                    <input type="text" name="prices[${status.index}].value" id="price_${bookType}"/>
                    <input type="hidden" name="prices[${status.index}].bookType" value="${bookType}"/>
                </div>
            </c:forEach>
            <div>
                <button type="submit">Enviar</button>
            </div>
        </form:form>
    </body>
</html>
