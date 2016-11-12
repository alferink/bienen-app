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
    <style>
    body {
        padding-top: 50px;
    }
    </style>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <g:layoutHead/>
</head>

<body>

<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li><g:link controller="logout"><b:currentUser /> abmelden</g:link></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<g:pageProperty name="page.header" />

<div class="container">
    <div class="content" role="main">
        <g:pageProperty name="page.errors" />

        <g:layoutBody/>
    </div>
</div> <!-- /container -->

<asset:javascript src="application.js"/>

<g:pageProperty name="page.footer" />

</body>
</html>
