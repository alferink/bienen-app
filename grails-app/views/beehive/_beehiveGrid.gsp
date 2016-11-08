<b:panelGrid var="beehive"
             width="3"
             in="${apiary.beehiveList}"
             createLabel="${g.message(code:'default.create.label', args: [g.message(code: 'beehive.label')])}"
             createUrl="[resource: 'beehive', action: 'create']">
    <b:panel label="${beehive.name}" headerUrl="[resource: 'beehive', action: 'show', id: beehive.id]">
        ${beehive.name}<br/>
        ${beehive.queen?.yearOfBirth}<br/>
    </b:panel>
</b:panelGrid>

%{--<div class="row">--}%


%{--<g:each var="beehive" status="index" in="${beehiveList}">--}%
    %{--<div class="col-sm-4">--}%
        %{--<div class="panel panel-default">--}%
            %{--<div class="panel-heading">--}%
                %{--<g:link resource="beehive"--}%
                        %{--id="${beehive.id}"--}%
                        %{--method="GET">--}%
                    %{--${beehive.name}--}%
                %{--</g:link>--}%
            %{--</div>--}%

            %{--<div class="panel-body">--}%
                %{--${beehive.name}<br/>--}%

                %{--<g:link resource="apiary/beehive" bienenstandId="${apiary.id}">${apiary.beehives.size()} Völker</g:link>--}%
            %{--</div>--}%
        %{--</div>--}%
    %{--</div>--}%
    %{--<g:if test="${index > 0 && index % 3 == 0}">--}%
        %{--</div>--}%
        %{--<div class="row">--}%
    %{--</g:if>--}%
%{--</g:each>--}%

%{--<div class="col-sm-4">--}%
    %{--<div class="panel panel-default">--}%
        %{--<div class="panel-heading"><g:link resource="beehive" class="create" action="create">--}%
            %{--<g:message code="default.new.label" args="[entityName]"/></g:link>--}%
        %{--</div>--}%

        %{--<div class="panel-body">--}%
            %{--??--}%
        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%
</div>
