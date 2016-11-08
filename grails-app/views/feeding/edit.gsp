<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'feeding.label', default: 'Feeding')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.feeding]"/>
</content>

<div id="edit-feeding" class="content" role="main">
    <g:form url="[resource: 'beehive/feeding', action: 'update', beehiveId: params.beehiveId, id: feeding.id]"
            method="PUT">
        <g:hiddenField name="beehive" value="${params.beehiveId}"/>

        <g:set var="backUrl" value="[resource: 'beehive', action: 'show', id: params.beehiveId]"/>
        <b:panel label="${feeding.type.label}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
            <g:render template="form" />
        </b:panel>
    </g:form>
</div>
</body>
</html>
