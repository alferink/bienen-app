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

            <ul class="list-inline page-title">
                <li><i class="fa fa-bars fa-5x" style="color: saddlebrown;"></i></li>
                <li><ol class="breadcrumb">
                    <li>
                        <g:link resource="apiary" id="${beehive.apiary?.id}" action="show">
                            <g:message code="apiary.label"/> ${beehive.apiary?.name}
                        </g:link>
                    </li>
                    <li class="active">
                        <div class="dropdown" style="display: inline;">
                            <a id="beehiveDLabel" class="dropdown-toggle" data-target="#" href="#"
                               data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                ${beehive.name}<span class="caret"></span>
                            </a>

                            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="beehiveDLabel">
                                <g:each var="otherBeehive" in="${beehive.apiary?.sortedBeehives}">
                                    <li>
                                        <g:link resource="beehive" action="show" id="${otherBeehive.id}">
                                            ${otherBeehive.label}
                                        </g:link>
                                    </li>
                                </g:each>
                            </ul>
                        </div>
                    </li>
                </ol>

                    <h1><g:message code="beehive.label"/> ${beehive.label}</h1>
                </li>
            </ul>


        </div>
    </div>
</content>

%{--<ul class="nav nav-pills">--}%
    %{--<li role="presentation"><a href="#">Volk</a></li>--}%
    %{--<li role="presentation"><a href="#">Aktionen</a></li>--}%
    %{--<li role="presentation"><a href="#">Messungen</a></li>--}%
    %{--<li role="presentation"><a href="#">Statistik</a></li>--}%
%{--</ul>--}%
%{--<br/>--}%

<g:applyLayout name="2columns">
    <content tag="content">
        <g:render template="show/content"/>
    </content>
    <content tag="sidebar">
        <g:render template="show/actions-panel"/>
    </content>
</g:applyLayout>

</body>
</html>
