package de.alferink.bee

import de.alferink.bee.beehiveaction.BeehiveActionType

class BeehiveTagLib {

    static namespace = "b"

    static defaultEncodeAs = [taglib: 'html']
    static encodeAsForTags = [panel: [taglib: 'none'], panelGrid: [taglib: 'none']]
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def springSecurityService

    def setBeehiveAction = { attrs, body ->
        BeehiveActionType actionType = BeehiveActionType.values().find {
            this.pageScope."$it.propertyName"
        }
        if (actionType) {
            this.pageScope.beehiveAction = this.pageScope."$actionType.propertyName"
        }
    }

    /**
     * @attr bean Name of the source bean in the GSP model.
     * @attr property REQUIRED The name of the property to display. This is resolved
     * against the specified bean or the bean in the current scope.
     * @attr value Specifies the initial value to display in the field. The default is
     * the current value of the property.
     * @attr default A default initial value to display if the actual property value
     * evaluates to {@code false}.
     * @attr required Specifies whether the user is required to enter a value for this
     * property. By default, this is determined by the constraints of the property.
     * @attr invalid Specifies whether this property is invalid or not. By default, this
     * is determined by whether there are any errors associated with it.
     * @attr label Overrides the default label displayed next to the input field.
     * @attr prefix Prefix to add to input element names.
     * @attr wrapper Specify the folder inside _fields where to look up for the wrapper template.
     * @attr widget Specify the folder inside _fields where to look up for the widget template.
     * @attr templates Specify the folder inside _fields where to look up for the wrapper and widget template.
     */
    def field = { attrs, body ->
        attrs.'widget-class' = attrs.'widget-class' ? attrs.'widget-class' + ' form-control' : 'form-control'
        out << f.field(attrs, body)
    }

    /**
     * @attr label
     * @attr headerActions
     * @attr headerUrl
     * @attr footer
     */
    def panel = { attrs, body ->

        String label = message(code: attrs.label, default: attrs.label)

        out << '<div class="panel panel-default">'
        out << '<div class="panel-heading">'
        if(attrs.headerUrl) {
            out << g.link(url: attrs.headerUrl){ label }
        } else {
            out << label
        }
        out << '<div class="pull-right">'
        attrs.headerActions.each {
            out << it
        }
        out << '</div>'
        out << '</div>'
        out << '<div class="panel-body">'
        out << body()
        out << '</div>'
        if (attrs.footer) {
            out << '<div class="panel-footer">'
            out << attrs.footer
            out << '</div>'
        }
        out << '</div>'
    }


    /**
     * @attr in REQUIRED
     * @attr createUrl
     */
    def panelGrid = { attrs, body ->
        Integer width = attrs.width ? attrs.width as Integer : 4
        Integer currentWidth = 0

        out << '<div class="row">'
        attrs.in.eachWithIndex{ element, index ->
            out << '<div class="col-sm-' + attrs.width + '">'
            out << body([(attrs.var ?: 'it'): element])
            out << '</div>'
            currentWidth += width

            if((currentWidth + width) > 12) {
                out << '</div>'
                out << '<div class="row">'
                currentWidth = 0
            }
        }

        out << '<div class="col-sm-' + attrs.width + '">'
        out << panel(label: attrs.createLabel, headerUrl: attrs.createUrl)
        out << '</div>'

        out << '</div>'
    }

    def currentUser = { attrs, body ->
        out << springSecurityService.currentUser?.username
    }
}