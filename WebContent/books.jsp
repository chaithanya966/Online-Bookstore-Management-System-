<%@ page import="java.util.*,com.vcube.models.Book" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/views/header.jsp" %>
<h3>Available Books</h3>
<%
  List<Book> books = (List<Book>) request.getAttribute("books");
  if (books==null) { out.println("<p>No books found.</p>"); }
%>
<div class="row">
<% if (books!=null) {
     for(Book b: books) { %>
  <div class="col-md-4">
    <div class="card mb-3">
      <div class="card-body">
        <h5 class="card-title"><%=b.getTitle()%></h5>
        <p class="card-text">Author: <%=b.getAuthor()%></p>
        <p class="card-text">Price: ₹<%=b.getPrice()%></p>
        <form method="post" action="handlers/CartHandler">
          <input type="hidden" name="bookId" value="<%=b.getId()%>"/>
          <input type="number" name="qty" value="1" min="1" max="<%=b.getStock()%>" class="form-control mb-2"/>
          <button class="btn btn-primary">Add to Cart</button>
        </form>
      </div>
    </div>
  </div>
<%   }
   } %>
</div>
<%@ include file="WEB-INF/views/footer.jsp" %>
