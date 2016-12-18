<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'apiary.label', default: 'Apiary')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>


<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.apiary]"/>
</content>

<g:form resource="${this.apiary}" method="PUT">
    <g:hiddenField name="version" value="${this.apiary?.version}"/>

    <div class="row">
        <div class="col-md-6">

            <g:set var="backUrl" value="[resource: 'apiary', action: 'show', id: apiary?.id]"/>
            <b:panel label="${entityName}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
                <fieldset class="form">
                    <f:field bean="apiary" property="name" widget-class="form-control"/>
                </fieldset>
            </b:panel>
        </div>
    </div>
</g:form>
</body>
</html>
