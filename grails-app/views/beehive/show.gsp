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
                ${value?.yearOfBirth}
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

        <g:set var="actionCreate">
            <div class="dropdown">
                <a id="dLabel" class="dropdown-toggle" data-target="#" href="http://example.com"
                   data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><span class="caret"></span>
                </a>

                <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dLabel">
                    <g:each var="type"
                            in="${de.alferink.bee.beehiveaction.BeehiveActionType.values() - de.alferink.bee.beehiveaction.BeehiveActionType.CREATING}">
                        <li>
                            <g:link resource="beehive/${type.propertyName}" action="create" beehiveId="${beehive.id}">
                                ${type.label}
                            </g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </g:set>

        <b:panel label="beehive.panel.actions.label" headerActions="${[actionCreate]}">
            <ul class="list-group">
                <g:each in="${beehive.actions.reverse()}">
                    <li class="list-group-item">
                        <div>
                            <h4>
                                ${it.type.label}

                                <small>
                                    <time class="timeline-time" datetime="${it.date}">
                                        <span>(<g:formatDate date="${it.date}" type="date"/>)</span>
                                    </time>

                                    <g:link resource="beehive/${it.type.propertyName}" beehiveId="${it.beehive.id}"
                                            id="${it.id}" action="edit">
                                        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                    </g:link>
                                </small>
                            </h4>

                        </div>

                        <div>
                            <g:render template="/${it.type.propertyName}/summary" model="[beehiveAction: it]"/>
                        </div>
                    </li>
                </g:each>
                <li class="list-group-item">
                    <div>
                        <h4>
                            ${beehive.beehiveCreation.type.label}

                            <small>
                                <time class="timeline-time" datetime="${beehive.beehiveCreation.created}">
                                    <span>(<g:formatDate date="${beehive.beehiveCreation.created}" type="date"/>)</span>
                                </time>

                                <g:link resource="beehiveCreation" id="${beehive.beehiveCreation.id}" action="edit">
                                    <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                </g:link>
                            </small>
                        </h4>
                    </div>

                    <div>
                        <g:render template="/beehiveAction/summary/beehiveAction"
                                  model="[beehiveAction: beehive.beehiveCreation]"/>
                    </div>
                </li>
            </ul>
        </b:panel>
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
