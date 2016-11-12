// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require_tree .
//= require_self
//= require /webjars/bootstrap/3.3.7-1/js/bootstrap.min
//= require /webjars/bootstrap-tagsinput/0.6.1/bootstrap-tagsinput
//= require /webjars/typeaheadjs/0.11.1/typeahead.bundle.js
//= require star-rating.js
//= require bee.js

if (typeof jQuery !== 'undefined') {
    (function($) {
        $('#spinner').ajaxStart(function() {
            $(this).fadeIn();
        }).ajaxStop(function() {
            $(this).fadeOut();
        });
    })(jQuery);
}

$(document).ready(function () {
    $('.dropdown-toggle').dropdown();
});