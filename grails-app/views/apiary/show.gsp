<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'apiary.label', default: 'Apiary')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<div class="row">
    <div class="col-md-6">
        <g:set var="edit">
            <g:link resource="apiary" id="${apiary.id}" action="edit">
                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
            </g:link>
        </g:set>

        <b:panel label="beehive.apiary.main.label" headerActions="${[edit]}">
            <f:display bean="apiary" property="name"/>
            <f:display bean="apiary" property="standort"/>
        </b:panel>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <b:panelGrid var="beehive"
                     width="3"
                     in="${apiary.sortedBeehives}"
                     createLabel="${g.message(code:'default.create.label', args: [g.message(code: 'beehive.label')])}"
                     createUrl="[resource: 'beehiveCreation', action: 'create', params: [apiary: apiary.id]]">
            <b:panel label="${beehive.name}" headerUrl="[resource: 'beehive', action: 'show', id: beehive.id]">
                ${beehive.name}<br/>
                ${beehive.queen?.year}<br/>
            </b:panel>
        </b:panelGrid>
    </div>
</div>

</body>
</html>
