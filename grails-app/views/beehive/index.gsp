<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label', default: 'Beehive')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<content tag="breadcrumb">
    <ol class="breadcrumb">
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li class="active"><g:message code="default.list.label" args="[entityName]"/></li>
    </ol>
</content>

<g:render template="beehiveGrid" />

</body>
</html>