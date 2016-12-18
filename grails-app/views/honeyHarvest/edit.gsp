<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'honeyHarvest.label')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<content tag="header">
    <div class="row">
        <div class="col-sm-12">

            <ul class="list-inline page-title">
                <li><i class="fa fa-bars fa-5x" style="color: saddlebrown;"></i></li>
                <li><ol class="breadcrumb">
                    <li>
                        <g:link resource="apiary" id="${honeyHarvest.beehive.apiary?.id}" action="show">
                            <g:message code="apiary.label"/> ${honeyHarvest.beehive.apiary?.name}
                        </g:link>
                    </li>
                    <li>
                        <g:link resource="beehive" id="${honeyHarvest.beehive?.id}" action="show">
                            <g:message code="beehive.label"/> ${honeyHarvest.beehive?.name}
                        </g:link>
                    </li>
                    <li>
                        <g:message code="honeyHarvest.label"/>
                    </li>
                </ol>
                    <h1><g:message code="honeyHarvest.label"/></h1>
                </li>
            </ul>
        </div>
    </div>
</content>

<content tag="errors">
    <g:render template="/templates/errors" model="[instance: this.honeyHarvest]"/>
</content>

<div id="edit-honeyHarvest" class="content" role="main">
    <g:form url="[resource: 'beehive/honeyHarvest', action: 'update', beehiveId: params.beehiveId, id: honeyHarvest.id]"
            method="PUT">
        <g:hiddenField name="beehive" value="${params.beehiveId}"/>

        <g:set var="backUrl" value="[resource: 'beehive', action: 'show', id: params.beehiveId]"/>
        <b:panel label="${honeyHarvest.type.label}" footer="${g.render(template: '/templates/saveAndCancelButtons')}">
            <g:render template="form" />
        </b:panel>
    </g:form>
</div>
</body>
</html>
