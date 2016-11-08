<fieldset class="form">
    <f:with bean="varroaCheck">
        <b:field property="date" widget-inputType="date" />
        <b:field property="quantity" />
        <b:field property="days" />
        <f:display property="quantityPerDay" >
            ${value ?: g.message(code: 'default.value.calculated.message')}
        </f:display>
        <b:field property="anmerkungen" />
    </f:with>
</fieldset>
