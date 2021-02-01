<%@ include file= "/WEB-INF/header.jsp" %>
<div class="container">

	
	<form action="${pageContext.request.contextPath}/AddANewTerm" method="post">
		<table>
			<tr>
				<td colspan="2">
					<div class="container">
						<c:forEach var="tag" items="${allTagList}">
					      	
					      	<button class="button">
					      	<c:out value="${tag.name}"/>
					      	</button>
					      </c:forEach>
					</div>
				</td>
			</tr>
		
			<tr>
				<td>Term
				</td>
				<td><input type="text" name="term"/>
				</td>
				<td>Term Tags
				</td>
			
				<td><textarea name="term_tags"></textarea>
				</td>
			</tr>
			
			
			<tr>	
				
				<td>Attribute
				</td>
				<td><input type="text" name="attribute"/>
				</td>
				<td>Attribute Tags
				</td>
			
				<td><textarea name="attribute_tags"></textarea>
				</td>
			</tr>
		
			<tr>	
				
				<td>Answer
				</td>
				<td><input type="text" name="answer"/>
				</td>
				<td>Answer Tags
				</td>
			
				<td><textarea name="answer_tags"></textarea>
				</td>
			
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td>
								
					<p>Submit
    				<input type="submit" name="submit" value="submit" /></p>
				</td>
			</tr>
		
	    </table>
	</form>
	
</div>



<div class="container">
	<p>message goes here</p>
</div>


<%@ include file= "/WEB-INF/footer.jsp" %>