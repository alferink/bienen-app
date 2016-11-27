
<g:set var="yearActions" value="${beehive.getSortedActions(yearRange)}" />
<g:set var="isBeehiveCreationInYearRange" value="${beehive.beehiveCreation?.isInYears(yearRange)}" />

<g:if test="${yearActions || isBeehiveCreationInYearRange}">
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="collapseListGroupHeading${yearRange.from}">
            <h4 class="panel-title">
                <a href="#collapseListGroup${yearRange.from}" class="collapsed" role="button" data-toggle="collapse"
                   aria-expanded="false"
                   aria-controls="collapseListGroup${yearRange.from}">${title}</a>
            </h4>
        </div>

        <div class="collapse ${expanded ? 'in' : ''} panel-collapse" role="tabpanel" id="collapseListGroup${yearRange.from}"
             aria-labelledby="collapseListGroupHeading${yearRange.from}">

            <ul class="list-group">

                <g:if test="${beehive.beehiveDissolved?.isInYears(yearRange)}">
                    <li class="list-group-item">
                        <div>
                            <h4>
                                ${beehive.beehiveDissolved.type.label}
                                <small>
                                    <span>(<g:formatDate date="${beehive.beehiveDissolved.date}" type="date"/>)</span>
                                    <g:link resource="beehive/${beehive.beehiveDissolved.type.propertyName}" beehiveId="${beehive.id}"
                                            id="${beehive.beehiveDissolved.id}" action="edit">
                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                    </g:link>
                                <g:form resource="beehive/${beehive.beehiveDissolved.type.propertyName}"
                                        beehiveId="${beehive.id}"
                                        id="${beehive.beehiveDissolved.id}"
                                        action="delete"
                                        method="DELETE"
                                        class="form-inline">
                                    <button type="submit"
                                            class="btn btn-link btn-sm btn-inline">
                                        <i class="fa fa-ban icon-alert" aria-hidden="true"></i>
                                    </button>
                                </g:form>
                            </h4>
                        </div>

                        <div>
                            <g:render template="/${beehive.beehiveDissolved.type.propertyName}/summary" model="[beehiveDissolved: beehive.beehiveDissolved]"/>
                        </div>
                    </li>
                </g:if>

                <g:each in="${yearActions}">
                    <li class="list-group-item">
                        <div>
                            <h4>
                                ${it.type.label}
                                <small>
                                    <span>(<g:formatDate date="${it.date}" type="date"/>)</span>
                                    <g:link resource="beehive/${it.type.propertyName}" beehiveId="${it.beehive.id}"
                                            id="${it.id}" action="edit">
                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                    </g:link>
                                    <g:form resource="beehive/${it.type.propertyName}"
                                            beehiveId="${it.beehive.id}"
                                            id="${it.id}"
                                            action="delete"
                                            method="DELETE"
                                            class="form-inline">
                                        <button type="submit"
                                                class="btn btn-link btn-sm btn-inline">
                                            <i class="fa fa-ban icon-alert" aria-hidden="true"></i>
                                        </button>
                                    </g:form>
                            </small>
                            </h4>
                        </div>

                        <div>
                            <g:render template="/${it.type.propertyName}/summary" model="[beehiveAction: it]"/>
                        </div>
                    </li>
                </g:each>

                <g:if test="${beehive.beehiveCreation?.isInYears(yearRange)}">
                    <li class="list-group-item">
                        <div>
                            <h4>
                                ${beehive.beehiveCreation.type.label}
                                <small>
                                    <span>(<g:formatDate date="${beehive.beehiveCreation.created}" type="date"/>)</span>
                                    <g:link resource="beehive/${beehive.beehiveCreation.type.propertyName}" beehiveId="${beehive.id}"
                                            id="${beehive.beehiveCreation.id}" action="edit">
                                        <i class="fa fa-pencil" aria-hidden="true"></i>
                                    </g:link>
                                </small>
                            </h4>
                        </div>

                        <div>
                            <g:render template="/${beehive.beehiveCreation.type.propertyName}/summary" model="[beehiveAction: beehive.beehiveCreation]"/>
                        </div>
                    </li>
                </g:if>
            </ul>
        </div>
    </div>
</g:if>