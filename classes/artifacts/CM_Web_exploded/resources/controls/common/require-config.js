require.config({
    waitSeconds: 15,
    baseUrl: "resources",
    paths: {
        jquery: "vendors/jquery-2.1.0.min",
        knockout: "vendors/knockout",
        text: "vendors/text",
        jqueryUI: "vendors/jquery-ui-1.10.4",
        jqueryTmpl: "vendors/jquery.tmpl",
        jqueryBlockUI: "vendors/jquery.blockUI",
        wijmoOpen: "vendors/wijmo/jquery.wijmo-open.all.3.20141.34.min",
        wijmoComplete: "vendors/wijmo/jquery.wijmo-pro.all.3.20141.34",
        knockoutWijmo: "vendors/wijmo/knockout.wijmo.3.20132.9",
        knockoutJqueryUI: "vendors/knockout-jquery-ui-widget",
        formValidate: "vendors/jquery-validate/jquery.validate",
        formValidateRu: "vendors/jquery-validate/messages_ru",
        select2: "vendors/select2/select2",
        select2Locale: "vendors/select2/select2_locale_ru",
        bootstrap: "vendors/bootstrap"
    },
    shim: {
        jquery: {exports: '$'},
        formValidate: {deps: [ 'jquery' ]},
        formValidateRu: {deps: ['formValidate']},
        jqueryTmpl: {deps: [ 'jquery' ]},
        jqueryUI: {deps: [ 'jquery' ]},
        jqueryBlockUI: {deps: [ 'jquery' ]},
        select2: {deps: [ 'jquery' ]},
        bootstrap: {deps: [ 'jquery' ]},
        knockoutWijmo: {deps: ['knockout']}
    }
});

require([
    'jquery',
    'knockout',
    'controls/common/work-area/WorkArea'
], function($, ko, WorkArea) {
    var self = this;
    self.pWorkArea = new WorkArea($(document).find("#workspace"));
//    self.pWorkArea.bindModel();
});