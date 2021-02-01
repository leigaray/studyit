<%@ include file= "/WEB-INF/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="com.leiskies.app.model.Term" %>
<div class="container">

 	<table class="table table-striped">
		
		<thead>
			<tr>
				<th>#</th>
				<th>Term</th>
				<th>Quantity</th>
				<th>Description</th>
				<th>Action</th>
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach var="term" items="${allTermList}">
			
				<td>
					<c:out value="${ term.id }" />
				</td>
				<td>
					<c:out value="${ term.name }" />
				</td>
				<td>
					<c:out value="${ product.qty }" />
				</td>
				<td>
					<c:out value="${ product.description }" />
				</td>
				<td>
					<a href="edit?id=<c:out value='${ product.id }' />">
						<button class="btn btn-primary">Edit</button>
					</a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="delete?id=<c:out value='${ product.id }' />">
						<button class="btn btn-danger">Delete</button>
					</a>
				</td>
			
			</c:forEach>
		
		</tbody>
	
	</table>
</div>


<%@ include file= "/WEB-INF/footer.jsp" %>