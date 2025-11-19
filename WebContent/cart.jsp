<%@ page import="java.util.*,com.vcube.models.CartItem" %>
<%@ include file="WEB-INF/views/header.jsp" %>
<h3>Your Cart</h3>
<%
  List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
  if (cart==null || cart.isEmpty()) { out.println("<p>Cart is empty.</p>"); }
  else {
%>
<table class="table">
<thead><tr><th>Book</th><th>Qty</th><th>Price</th></tr></thead>
<tbody>
<%
  double total=0;
  for(CartItem it: cart){ %>
  <tr>
    <td><%=it.getBook().getTitle()%></td>
    <td><%=it.getQty()%></td>
    <td>₹<%=it.getBook().getPrice()*it.getQty()%></td>
  </tr>
<% total += it.getBook().getPrice()*it.getQty(); }
%>
</tbody>
</table>
<p>Total: ₹<%=total%></p>
<form method="post" action="handlers/CheckoutHandler"><button class="btn btn-success">Checkout</button></form>
<% } %>
<%@ include file="WEB-INF/views/footer.jsp" %>
