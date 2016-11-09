<fieldset class="form">
    <f:with bean="queenInstallation">
        <b:field property="date" widget-inputType="date"/>
        <g:render template="/queen/form" model="[queen: queenInstallation.queen, prefix: 'queen.']" />
        <b:field property="anmerkungen"/>
    </f:with>
</fieldset>
