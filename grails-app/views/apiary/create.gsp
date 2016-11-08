<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'apiary.label', default: 'Apiary')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.apiary]"/>
</content>

<g:form action="save">
    <div class="row">
        <div class="col-md-6">
            <b:panel label="Stammdaten" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
                <fieldset class="form" >
                    <f:field bean="apiary" property="name" widget-class="form-control"/>
                    <f:field bean="apiary" property="standort" widget-class="form-control"/>
                </fieldset>
            </b:panel>
            %{----}%
            %{--<g:applyLayout name="panel">--}%
                %{--<content tag="body">--}%
                %{--</content>--}%
                %{--<content tag="footer">--}%
                    %{--<div>--}%
                        %{--<fieldset class="buttons">--}%
                            %{--<button type="submit" class="btn btn-default">--}%
                                %{--<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>--}%
                                %{--${message(code: 'default.button.create.label', default: 'Update')}--}%
                            %{--</button>--}%
                            %{--<g:link resource="apiary" action="index" class="btn btn-default">--}%
                                %{--<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>--}%
                                %{--<g:message code="default.cancel.label"/>--}%
                            %{--</g:link>--}%
                        %{--</fieldset>--}%
                    %{--</div>--}%
                %{--</content>--}%
            %{--</g:applyLayout>--}%
        </div>
    </div>
</g:form>
</body>
</html>
