<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'queenInstallation.label')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.queenInstallation]"/>
</content>

<div id="edit-queenInstallation" class="content" role="main">
    <g:form url="[resource: 'beehive/queenInstallation', action: 'update', beehiveId: params.beehiveId, id: queenInstallation.id]"
            method="PUT">
        <g:hiddenField name="beehive" value="${params.beehiveId}"/>

        <g:set var="backUrl" value="[resource: 'beehive', action: 'show', id: params.beehiveId]"/>
        <b:panel label="${queenInstallation.type.label}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
            <g:render template="form" />
        </b:panel>
    </g:form>
</div>
</body>
</html>
