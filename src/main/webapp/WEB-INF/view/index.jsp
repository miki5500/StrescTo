<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>StrescTo - Strona Główna</title>
    <meta name="keywords" content="automatic summarization, summarize, automatyczne streszczenie">
    <meta name="author" content="Krzysztof Bieńko">
    <meta http-equiv="X-Ua-Compatible" content="IE=edge">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" />
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<html>
    <body>
        <header>
            <nav class="navbar navbar-dark bg-primary navbar-expand-md">
            <a class="navbar-brand" href="/strescTo">StrescTo</a>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainmenu">
                <span class="navbar-toggler-icon" ></span>
            </button>
            <div class="collapse navbar-collapse" id="mainmenu">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/strescTo">Start</a>
                    </li>
                </ul>
            </div>


            </nav>
        </header>

        <main>
            <section class="mainpage">
            <header>
            <h1>Tekst do streszczenia: </h1>
            </header>
            <div class="row">
                    <div class="col-sm-12 col-md-8 offset-md-1">
                        <figure>
                            <p>To jest strona główna.</p>
                        </figure>
                    </div>

            </div>
        </main>
    </body>
</html>