<%  


%>

<%@ page import="it.focus.model.ProductBean"%>
  <%@ page import="it.focus.model.ProductBeanDAO"%>
    <%@ page import="it.focus.model.CartBean"%>
        <%@ page import="it.focus.model.UserBean"%>
    
      <%@ page import="java.util.ArrayList"%>

            <%CartBean cart = (CartBean) session.getAttribute("cart");%>
                        <%UserBean user = (UserBean) session.getAttribute("userBean");%>
            
