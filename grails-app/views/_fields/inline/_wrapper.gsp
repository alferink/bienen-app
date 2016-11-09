<%@ page defaultCodec="html" %>
<div class="form-group ${invalid ? 'has-error' : ''}">
    <label class="control-label" for="${property}">${label}</label> <%= widget %>
</div>