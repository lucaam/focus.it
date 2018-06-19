<%  
Cookie [] cookies = request.getCookies();


	      Cookie usrcookie =null;
	      Cookie emailcookie=null;
	      Cookie rolecookie=null;
	      Cookie namecookie=null;
	      Cookie surnamecookie=null;
	      Cookie phonecookie=null;
	      
	
		      if(cookies != null){
		      	for (Cookie temp : cookies){
		      		if("usr".equals(temp.getName())){
		      			 usrcookie = temp;}
		      		 if("email".equals(temp.getName())){
		      		 	 emailcookie = temp;}
		      		 if("role".equals(temp.getName())){
		      		 	 rolecookie = temp;}
		      		if("surname".equals(temp.getName())){
		      			surnamecookie = temp;}
		      		if("name".equals(temp.getName())){
		      		 	 namecookie = temp;}
		      		if("phone".equals(temp.getName())){
		      		 	 phonecookie = temp;}
		}
	}
		      

%>
	        