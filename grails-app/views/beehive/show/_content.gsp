<b:panel label="beehive.panel.main.label">
    <g:if test="${beehive.beehiveDissolved}">
        <div class="alert alert-danger" role="alert"><g:message code="beehive.dissolved.message"/></div>
    </g:if>
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
    <f:display bean="beehive" property="brutraum" label="review.brutraum.honigraum.label" >
        ${value} / ${beehive.honigraum}
    </f:display>
    <f:display bean="beehive" property="apiary"/>
</b:panel>


<g:set var="showStatistics">
    <g:link resource="beehive/beehiveMeasurement" beehiveId="${beehive.id}" action="index" class="header-link">
        <i class="fa fa-bar-chart" aria-hidden="true"></i>
    </g:link>
</g:set>

<b:panel label="Statistik" headerActions="${[showStatistics]}">

    <g:set var="honeyHarvestLabel"
           value="${g.message(code: 'beehiveStatistics.honeyHarvest.years.label', args: [beehiveStatistics.dateTime.year.toString(), (beehiveStatistics.dateTime.year - 1).toString()])}"/>

    <f:display bean="beehiveStatistics" property="honeyQuantity" label="${honeyHarvestLabel}">
        ${value} kg (${beehiveStatistics.honeyQuantityLastYear} kg)
    </f:display>
    <fieldset class="form">
        <label>Messungen (<f:displayWidget bean="beehiveStatistics" property="latestMeasurement.dateTime"/>)</label>
        <f:display bean="beehiveStatistics" property="latestMeasurement.outsideTemperature">
            ${value?.round(1)} °C
        </f:display>
        <f:display bean="beehiveStatistics" property="latestMeasurement.insideTemperature">
            ${value?.round(1)} °C
        </f:display>
        <f:display bean="beehiveStatistics" property="latestMeasurement.outsideHumidity">
            ${value?.round(0)} %
        </f:display>
        <f:display bean="beehiveStatistics" property="latestMeasurement.weight">
            ${value?.round(1)} kg (${beehiveStatistics.latestMeasurement?.weightDifference?.round(1)} kg)
        </f:display>
    </fieldset>
</b:panel>
