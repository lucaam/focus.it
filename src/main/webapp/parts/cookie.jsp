<%  


%>

<%@ page import="it.lucaamoriello.focusit.model.ProductBean"%>
  <%@ page import="it.lucaamoriello.focusit.model.ProductBeanDAO"%>
    <%@ page import="it.lucaamoriello.focusit.model.CartBean"%>
        <%@ page import="it.lucaamoriello.focusit.model.UserBean"%>
    
      <%@ page import="java.util.ArrayList"%>

            <%CartBean cart = (CartBean) session.getAttribute("cart");%>
                        <%UserBean user = (UserBean) session.getAttribute("userBean");%>
            
