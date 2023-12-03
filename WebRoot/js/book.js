	function login() {
		var url = "qtlogin.jsp";
		window.location = url;
	}

	function register() {
		var url = "register.jsp";
		window.location = url;
	}

	function search() {
		var name = document.getElementById("bookName").value;
		var author = document.getElementById("author").value;
		var url = "ShowBookByLikeServlet?name=" + name + "&author=" + author;
		window.location = url;
	}
	
	function logout() {
		var url = "QtlogoutServlet";
		window.location = url;
	}