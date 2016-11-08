<fieldset class="buttons">
    <div class="pull-right">
        <g:submitButton name="create" class="btn btn-default"
                        value="${message(code: (params.action == 'create' ? 'default.button.update.label' : 'default.button.update.label'))}"/>
        <g:link class="btn btn-default" url="${backUrl}">
            <g:message code="default.button.cancel.label" />
        </g:link>
    </div>
</fieldset>
