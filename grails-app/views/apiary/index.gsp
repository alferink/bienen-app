<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'apiary.label', default: 'Apiary')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<content tag="breadcrumb">
    <ol class="breadcrumb">
        <li><g:link resource="apiary" action="index"><g:message code="apiary.plural.label" /></g:link></li>
    </ol>
</content>

<div class="row">
<g:each var="apiary" status="index" in="${apiaryList}">
    <div class="col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading"><g:link resource="apiary" id="${apiary.id}" action="show">${apiary.name}</g:link></div>

            <div class="panel-body">
                ${apiary.name}<br/>

                <g:link resource="beehive" bienenstandId="${apiary.id}">${apiary.beehives.size()} Völker</g:link>
            </div>
        </div>
    </div>
    <g:if test="${index > 0 && index % 3 == 0}">
        </div>
        <div class="row">
    </g:if>
</g:each>

<div class="col-sm-4">
    <div class="panel panel-default">
        <div class="panel-heading"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></div>

        <div class="panel-body">
            ??
        </div>
    </div>
</div>

</div>


</div>
</body>
</html>