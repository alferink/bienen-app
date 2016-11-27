<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <g:layoutHead/>
</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Bee</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/"><g:message code="apiary.plural.label" /></a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#contact">
                    <i class="fa fa-envelope-o" aria-hidden="true"></i> Kontakt
                </a>
                </li>
                <li>
                    <g:form controller="logout" method="POST">
                        <button type="submit" class="btn btn-link">
                            <i class="fa fa-sign-out" aria-hidden="true"></i>
                            Abmelden
                        </button>
                    </g:form>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div class="container">
    <g:pageProperty name="page.header"/>

    <div class="content" role="main">
        <g:pageProperty name="page.errors"/>

        <g:layoutBody/>
    </div>

    <g:pageProperty name="page.footer"/>
</div> <!-- /container -->

<asset:javascript src="application.js"/>

</body>
</html>
