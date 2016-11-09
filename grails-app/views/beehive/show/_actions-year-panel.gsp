<div class="panel panel-default">
    <div class="panel-heading" role="tab" id="collapseListGroupHeading${year}">
        <h4 class="panel-title">
            <a href="#collapseListGroup${year}" class="collapsed" role="button" data-toggle="collapse"
               aria-expanded="false"
               aria-controls="collapseListGroup${year}">${year}</a>
        </h4>
    </div>

    <div class="collapse ${expanded ? 'in' : ''} panel-collapse" role="tabpanel" id="collapseListGroup${year}"
         aria-labelledby="collapseListGroupHeading${year}">

        <ul class="list-group">
            <g:each in="${yearActions}">
                <li class="list-group-item">
                    <div>
                        <h4>
                            ${it.type.label}
                            <small>
                                <span>(<g:formatDate date="${it.date}" type="date"/>)</span>
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
        </ul>
    </div>
</div>