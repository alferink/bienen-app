<%@ page import="de.alferink.bee.beehiveaction.BeehiveActionType; java.time.ZoneId" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label', default: 'Beehive')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<content tag="header" >
    <div class="row">
        <div class="col-sm-12">
            <div class="pull-right" style="padding: 10px">
                <g:link class="btn btn-default" resource="apiary" id="${beehive.apiary?.id}" action="show" >
                    <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
                    ${beehive.apiary}
                </g:link>
                <g:set var="prevBeehive" value="${beehive.apiary?.getPrevBeehive(beehive)}" />
                <g:if test="${prevBeehive}">
                    <g:link class="btn btn-default" resource="beehive" id="${prevBeehive.id}" action="show" >
                        <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                        ${prevBeehive}
                    </g:link>
                </g:if>
                <g:set var="nextBeehive" value="${beehive.apiary?.getNextBeehive(beehive)}" />
                <g:if test="${nextBeehive}">
                    <g:link class="btn btn-default" resource="beehive" id="${nextBeehive.id}" action="show" >
                        <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                        ${nextBeehive}
                    </g:link>
                </g:if>
        </div>
    </div>
</content>

<div class="row">
    <div class="col-md-6">

        <b:panel label="beehive.panel.main.label">
            <f:display bean="beehive" property="created"/>
            <f:display bean="beehive" property="name"/>
            <f:display bean="beehive" property="queen">
                <g:if test="${value}">
                    <a data-toggle="collapse" href="#queenCollapse" aria-expanded="false" aria-controls="queenCollapse">
                        ${value} <span class="caret"></span>
                    </a>

                    <div class="collapse" id="queenCollapse">
                        <div class="well">
                            <g:render template="/queen/show" model="[queen: beehive.queen]"/>
                        </div>
                    </div>
                </g:if>
                <g:else>
                    -
                </g:else>
            </f:display>
            <f:display bean="beehive" property="hiveType"/>
            <f:display bean="beehive" property="brutraum"/>
            <f:display bean="beehive" property="honigraum"/>
            <f:display bean="beehive" property="apiary"/>
        </b:panel>

        <b:panel label="Statistik" headerActions="${[edit]}">
            <g:link resource="beehive/beehiveMeasurement" beehiveId="${beehive.id}"
                    action="index">Statistik</g:link>
        </b:panel>
    </div>

    <div class="col-md-6">
        <g:render template="show/actions-panel" />
    </div>
</div>
</body>
</html>
