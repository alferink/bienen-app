<div class="row">
    <div class="col-sm-6">
        <g:if test="${beehiveAction.ei}">
            <f:display bean="beehiveAction" property="egg" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.larva}">
            <f:display bean="beehiveAction" property="larva" wrapper="inline" widget="rating"/>
        </g:if>
        <g:if test="${beehiveAction.cellCapped}">
            <f:display bean="beehiveAction" property="cellCapped" wrapper="inline" widget="rating"/>
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
        <g:if test="${beehiveAction.broodChamber}">
            <f:display bean="beehiveAction" property="broodChamber" wrapper="inline" widget="addremove"/>
        </g:if>
        <g:if test="${beehiveAction.honeyChamber}">
            <f:display bean="beehiveAction" property="honeyChamber" wrapper="inline" widget="addremove"/>
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