<fieldset class="form">
    <f:with bean="beehiveCreation">
        <b:field property="name"/>
        <b:field property="created" widget-inputType="date"/>
        <b:field property="anmerkungen"/>
        <b:field property="apiary"/>
        <b:field property="hiveType"/>
        <b:field property="brutraum"/>
        <b:field property="honigraum"/>
        <b:field property="queen"/>
    %{--<b:field prefix="queen" property="queen.yearOfBirth"/>--}%
    </f:with>
</fieldset>
