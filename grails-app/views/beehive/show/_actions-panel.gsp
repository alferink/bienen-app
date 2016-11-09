<%@ page import="java.time.Year" %>

<g:set var="actionCreate">
    <div class="dropdown">
        <a id="dLabel" class="dropdown-toggle" data-target="#" href="#"
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

    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <g:set var="currentYear" value="${java.time.Year.now().getValue()}"/>
        <g:set var="lastYear" value="${currentYear - 1}"/>
        <g:set var="beforeLastYear" value="${currentYear - 2}"/>
        <g:render template="show/actions-year-panel"
                  model="[title: currentYear, year: currentYear, yearActions: beehive.getSortedActions(currentYear..3000), expanded: true]"/>
        <g:render template="show/actions-year-panel"
                  model="[title: lastYear, year: lastYear, yearActions: beehive.getSortedActions(lastYear..lastYear)]"/>
        <g:render template="show/actions-year-panel"
                  model="[title: 'vor ' + beforeLastYear, year: beforeLastYear, yearActions: beehive.getSortedActions(0..beforeLastYear)]"/>
    </div>
</b:panel>