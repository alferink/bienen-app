<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.beehiveCreation]"/>
</content>

<div id="edit-feeding" class="content" role="main">
    <g:form url="[action: 'update', id: beehiveCreation.id]"
            method="PUT">
        <g:set var="backUrl" value="[resource: 'beehive', action: 'show', id: beehiveCreation.beehive?.id]"/>
        <b:panel label="${beehiveCreation.type.label}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
            <g:render template="form" />
        </b:panel>
    </g:form>
</div>
</body>
</html>
