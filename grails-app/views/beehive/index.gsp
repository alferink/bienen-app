<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label', default: 'Beehive')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<g:render template="beehiveGrid" />

</body>
</html>