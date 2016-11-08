<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'beehiveMeasurement.label', default: 'BeehiveMeasurement')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
    </head>
    <body>


    <div id="tester" style="width:1200px; height:500px;"></div>
    <script>
        /*
         TESTER = document.getElementById('tester');
         Plotly.plot( TESTER, [{
         x: [1, 2, 3, 4, 5],
         y: [1, 2, 4, 8, 16],
         type: 'bar',}],{
         margin: { t: 0 } } );
         */

        %{--var zeitpunkte =  [${raw(beehiveMeasurementList.collect{ '"' +  1 + '"' }.join(','))}]--}%
        var zeitpunkte =  [${raw(beehiveMeasurementList.collect{ '"' + g.formatDate(date: it.date, format: 'yyyy-MM-dd HH:mm') + '"' }.join(','))}]
        var gewichte =  [${raw(beehiveMeasurementList.collect{ it.weight }.join(','))}]
        %{--var gewichtsdifferenz =  [${raw(beehiveMeasurementList.collect{ it.outsideHumidity }.join(','))}]--}%
        var temperaturInnen =  [${raw(beehiveMeasurementList.collect{ it.insideTemperature }.join(','))}]
        var temperaturAussen = [${raw(beehiveMeasurementList.collect{ it.outsideTemperature }.join(','))}]
        var luftfeuchte =  [${raw(beehiveMeasurementList.collect{ it.outsideHumidity }.join(','))}]

        var gewichteDaten = {
            x: zeitpunkte,
            y: gewichte,
            mode: 'lines',
            type: 'bar',
            name: 'Gewicht'
        };
        var temperaturInnenDaten = {
            x: zeitpunkte,
            y: temperaturInnen,
            mode: 'lines',
            type: 'line',
            yaxis: 'y2',
            name: 'Temperatur innen'
        };
        var temperaturAussenDaten = {
            x: zeitpunkte,
            y: temperaturAussen,
            mode: 'lines',
            type: 'line',
            yaxis: 'y2',
            name: 'Temperatur innen'
        };
        var luftfeuchteDaten = {
            x: zeitpunkte,
            y: luftfeuchte,
            mode: 'lines',
            type: 'line',
            yaxis: 'y3',
            name: 'Luftfeuchte'
        };

        var data = [ gewichteDaten, temperaturInnenDaten, temperaturAussenDaten, luftfeuchteDaten ];

        var layout = {
            width: 1200,
            xaxis: {
                type: 'date',
                title: 'Messungen'
            },
            yaxis: {
                title: 'kg',
                range: [-5, 10]
            },
            yaxis2: {
                title: '°C',
                titlefont: {color: 'rgb(148, 103, 189)'},
                tickfont: {color: 'rgb(148, 103, 189)'},
                anchor: 'x',
                overlaying: 'y',
                side: 'right',
                range: [-20, 40]
            },
            yaxis3: {
                title: '%',
                titlefont: {color: 'rgb(148, 103, 189)'},
                tickfont: {color: 'rgb(148, 103, 189)'},
                anchor: 'free',
                overlaying: 'y',
                side: 'right',
                position: 0.9,
                range: [-50, 100]
            },
            title:'Messung: Bienenvolk 1'
        };

        Plotly.plot('tester', data, layout);
    </script>

        %{--<a href="#list-beehiveMeasurement" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>--}%
        %{--<div class="nav" role="navigation">--}%
            %{--<ul>--}%
                %{--<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--}%
                %{--<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--}%
            %{--</ul>--}%
        %{--</div>--}%
        %{--<div id="list-beehiveMeasurement" class="content scaffold-list" role="main">--}%
            %{--<h1><g:message code="default.list.label" args="[entityName]" /></h1>--}%
            %{--<g:if test="${flash.message}">--}%
                %{--<div class="message" role="status">${flash.message}</div>--}%
            %{--</g:if>--}%
            %{--<f:table collection="${beehiveMeasurementList}" />--}%

            %{--<div class="pagination">--}%
                %{--<g:paginate total="${beehiveMeasurementCount ?: 0}" />--}%
            %{--</div>--}%
        %{--</div>--}%

        <f:table collection="${beehiveMeasurementList}" properties="['date', 'outsideTemperature', 'insideTemperature', 'outsideHumidity', 'weight']" />
    </body>
</html>