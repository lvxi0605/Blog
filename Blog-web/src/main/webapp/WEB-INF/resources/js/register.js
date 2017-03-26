/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

/**
 * Created by lvxi on 2017/3/14.
 */
/**
 * 页面加载完毕调用
 */
$(document).ready(function () {
    //数据校验
    $("#registerForm").bootstrapValidator({
        live: 'disabled',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            account: {
                group: '.col-md-9',
                validators: {
                    notEmpty: {
                        message: '请输入要注册的账号。'
                    },
                    regexp: {
                        regexp: /^[_A-z0-9]{4,30}$/,
                        message: '用户名要是英文字母,数字,下划线_,长度4至30位。'
                    }, callback: {
                        message: '该账号已经被注册了。',
                        callback: function(value, validator) {
                            var accountField = validator.getFieldElements('account');
                            var isExit =accountField.data("isExit");
                            var status =accountField.data('bv.result.callback');
                            var isValid=true;
                            if(status=='VALIDATING' && isExit) isValid = false;
                            //重新赋值
                            accountField.data("isExit",false);
                            return isValid;
                        }
                    }
                }
            },
            password: {
                group: '.col-md-9',
                feedbackIcons: 'false',
                validators: {
                    notEmpty: {
                        message: '请输入密码。'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '密码长度要为6至30位。'
                    }
                }
            },
            confirmPassword: {
                group: '.col-md-9',
                feedbackIcons: 'false',
                validators: {
                    notEmpty: {
                        message: '请确认输入的密码。'
                    },
                    identical: {
                        field: 'password',
                        message: '两次输入的密码不一致。'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '密码长度要为6至30位。'
                    }
                }
            }
        }
    });

});

var regiserApp = angular.module("registerApp", []);
regiserApp.controller("registerFormController", function ($scope, $http) {
    /**
     * 校验用户名是否存在
     */
    $scope.isExistUser = function () {

        var vlt = $("#registerForm").data('bootstrapValidator');
        vlt.validateField("account");

        if (vlt.isValidField("account")) {
            vlt.updateStatus("account", 'VALIDATING');
            $http.get("api/user/isExistAccount", {
                params: {
                    'account': $scope.account
                }, cache: true
            }).then(function (result) {
                if (result.data.success) {
                    vlt.getFieldElements('account').data("isExit",true);
                    console.log("账号存在")
                }
                else {
                    vlt.getFieldElements('account').data("isExit",false);
                    console.log("账号不存在")
                }
                vlt.validateField("account");
            });
        }
    };


});
