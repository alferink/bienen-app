<g:if test="${inputType == 'date'}">
    <g:field
            type="${'date'}"
            name="${prefix}${property}"
            required="${required}"
            value="${g.formatDate(date: value, format: 'yyyy-MM-dd')}"
            class="${pageScope.class}"/>
</g:if>
<g:else>
    <g:field
            type="${inputType ?: 'datetime-local'}"
            name="${prefix}${property}"
            required="${required}"
            value="${g.formatDate(date: value, format: 'yyyy-MM-dd\'T\'HH:mm')}"
            class="${pageScope.class}"/>
</g:else>
