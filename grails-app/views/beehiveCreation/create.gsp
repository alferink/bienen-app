<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>

<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.beehiveCreation]"/>
</content>

<div id="create-beehiveCreation" class="content scaffold-create" role="main">
    <g:form url="[action: 'save']">
        <g:set var="backUrl" value="[resource: 'apiary']"/>
        <b:panel label="${entityName}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
            <g:render template="form" />
        </b:panel>
    </g:form>
</div>
</body>
</html>
