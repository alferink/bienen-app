<%@ page import="java.time.ZoneId" %>
<g:field
        type="date"
        name="${prefix}${property}"
        required="${required}"
        value="${value ? Date.from(value.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) : null}"
        class="${pageScope.class}"/>
