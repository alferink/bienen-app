<b:panelGrid var="beehive"
             width="3"
             in="${beehiveList}"
             createLabel="${g.message(code:'default.create.label', args: [g.message(code: 'beehive.label')])}"
             createUrl="[resource: 'beehive', action: 'create']">
    <b:panel label="${beehive.name}" headerUrl="[resource: 'beehive', action: 'show', id: beehive.id]">
        ${beehive.name}<br/>
        ${beehive.queen?.year}<br/>
    </b:panel>
</b:panelGrid>
</div>
