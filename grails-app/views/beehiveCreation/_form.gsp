<%@ page import="de.alferink.bee.Queen" %>
<fieldset class="form">
    <f:with bean="beehiveCreation">
        <b:field property="name"/>
        <b:field property="created" widget-inputType="date"/>
        <b:field property="anmerkungen"/>
        <b:field property="apiary"/>
        <b:field property="hiveType"/>
        <b:field property="brutraum"/>
        <b:field property="honigraum"/>
    </f:with>
</fieldset>
<fieldset class="form">
    <label><g:message code="beehive.queen.label" /></label>
    <f:field bean="beehiveCreation" property="hasQueen" wrapper="inline" />
    <g:render template="/queen/form" model="[queen: beehiveCreation.queen ?: new de.alferink.bee.Queen(), prefix: 'queen.']" />
</fieldset>

