<%@ page import="de.alferink.bee.beehiveaction.BeehiveActionType; java.time.ZoneId" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'beehive.label', default: 'Beehive')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<content tag="header">
    <div class="row">
        <div class="col-sm-12">
            <div class="pull-right" style="padding: 10px">
                <g:set var="prevBeehive" value="${beehive.apiary?.getPrevBeehive(beehive)}"/>
                <g:if test="${prevBeehive}">
                    <g:link class="btn btn-default" resource="beehive" id="${prevBeehive.id}" action="show">
                        <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                        ${prevBeehive}
                    </g:link>
                </g:if>
                <g:set var="nextBeehive" value="${beehive.apiary?.getNextBeehive(beehive)}"/>
                <g:if test="${nextBeehive}">
                    <g:link class="btn btn-default" resource="beehive" id="${nextBeehive.id}" action="show">
                        <span class="glyphicon glyphicon-arrow-right" aria-hidden="true"></span>
                        ${nextBeehive}
                    </g:link>
                </g:if>
                <g:link class="btn btn-default" resource="apiary" id="${beehive.apiary?.id}" action="show">
                    <span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span>
                    ${beehive.apiary}
                </g:link>
            </div>
        </div>
    </div>
</content>

<g:applyLayout name="2columns" >
    <content tag="content">
        <g:render template="show/content"/>
    </content>
    <content tag="sidebar">
        <g:render template="show/actions-panel"/>
    </content>
</g:applyLayout>

</body>
</html>
