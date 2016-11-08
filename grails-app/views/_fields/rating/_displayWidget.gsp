<g:if test="${value < 2}">
    <g:message code="bee.rating.1.label" />
</g:if>
<g:elseif test="${value < 3}">
    <g:message code="bee.rating.2.label" />
</g:elseif>
<g:elseif test="${value < 4}">
    <g:message code="bee.rating.3.label" />
</g:elseif>
<g:else>
    <g:message code="bee.rating.4.label" />
</g:else>
(${value})
