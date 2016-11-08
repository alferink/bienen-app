<%@ page import="java.time.ZoneId" %>
<g:field
        type="datetime-local"
        name="${prefix}${property}"
        required="${required}"
        value="${value ? Date.from(value.atZone(java.time.ZoneId.systemDefault()).toInstant()) : null}"
        class="${pageScope.class}"/>
