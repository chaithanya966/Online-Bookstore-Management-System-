<%@ page import="java.util.*,com.vcube.models.Book" %>
<%@ include file="WEB-INF/views/header.jsp" %>
<h3>Admin - Manage Books</h3>
<form method="post" action="handlers/AdminHandler">
 <input type="text" name="title" placeholder="Title" required/>
 <input type="text" name="author" placeholder="Author" required/>
 <input type="number" name="price" placeholder="Price" required/>
 <input type="number" name="stock" placeholder="Stock" required/>
 <button class="btn btn-primary">Add Book</button>
</form>
<hr/>
<h4>Existing Books</h4>
<%
 List<Book> books = (List<Book>) request.getAttribute("books");
 if (books!=null){
%>
<table class="table">
<thead><tr><th>Title</th><th>Author</th><th>Price</th><th>Stock</th></tr></thead>
<tbody>
<% for(Book b: books){ %>
<tr><td><%=b.getTitle()%></td><td><%=b.getAuthor()%></td><td><%=b.getPrice()%></td><td><%=b.getStock()%></td></tr>
<% } %>
</tbody>
</table>
<% } %>
<%@ include file="WEB-INF/views/footer.jsp" %>
