%{--<g:message code="varroaTreatment.summary" args="[beehiveAction.menge, beehiveAction.mittel, beehiveAction.methode]"/>--}%
<div class="row">
    <div class="col-sm-6">
        <g:if test="${beehiveAction.ei}">
            <f:display bean="beehiveAction" property="ei" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.made}">
            <f:display bean="beehiveAction" property="made" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.verdeckelt}">
            <f:display bean="beehiveAction" property="verdeckelt" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.wabensitz}">
            <f:display bean="beehiveAction" property="wabensitz" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.sanftmut}">
            <f:display bean="beehiveAction" property="sanftmut" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.volksstaerke}">
            <f:display bean="beehiveAction" property="volksstaerke" wrapper="inline" widget="rating"/>
        </g:if>
    </div>

    <div class="col-sm-6">
        <g:if test="${beehiveAction.brutraum}">
            <f:display bean="beehiveAction" property="brutraum" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.honigraum}">
            <f:display bean="beehiveAction" property="honigraum" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.mittelwaende}">
            <f:display bean="beehiveAction" property="mittelwaende" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.leerwaben}">
            <f:display bean="beehiveAction" property="leerwaben" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.brutwaben}">
            <f:display bean="beehiveAction" property="brutwaben" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.futterwaben}">
            <f:display bean="beehiveAction" property="futterwaben" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.drohnenwaben}">
            <f:display bean="beehiveAction" property="drohnenwaben" wrapper="inline" widget="addremove"/>
        </g:if>
    </div>
</div>