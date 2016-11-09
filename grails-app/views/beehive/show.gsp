<%@ page import="de.alferink.bee.beehiveaction.BeehiveActionType; java.time.ZoneId" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label', default: 'Beehive')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

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

<content tag="footer">
    <g:javascript>
        $(document).ready(function () {
            $('.dropdown-toggle').dropdown();
        });
    </g:javascript>
</content>
</body>
</html>
