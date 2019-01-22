function HandleGoogleApiLibrary() {
    gapi.load('client:auth2', {
        callback: function() {
            gapi.client.init({
                apiKey: 'pcFFchyyXlYTqRV29rWO25fL',
                clientId: '288737143791-eu48togi8i9espjjo1ah7t6u23rhansm.apps.googleusercontent.com',
                scope: 'https://www.googleapis.com/auth/userinfo.profile https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/plus.me'
            }).then(
                function(success) {
                    $("#login-button").removeAttr('disabled');
                },
                function(error) {
                }
            );
        },
        onerror: function() {
            // Failed to load libraries
        }
    });
}

$("#login-button").on('click', function() {
    $("#login-button").attr('disabled', 'disabled');

    gapi.auth2.getAuthInstance().signIn().then(
        // On success
        function(success) {
            gapi.client.request({ path: 'https://www.googleapis.com/plus/v1/people/me' }).then(
                // On success
                function(success) {
                    let user_info = JSON.parse(success.body);
                    let Data = { email: `${user_info.emails[0].value}`, password: `${user_info.id}`};
                    console.log(Data);
                    $.ajax({
                        type: "POST",
                        url: "/users/google/login",
                        contentType: "application/json; charset=utf-8",
                        data: JSON.stringify(Data),
                        success: function (data) {
                            $.fn.popupConfirm();
                        },
                        error: function (data) {
                            $.fn.errorRegisterNotification();
                            $("#login-button").removeAttr('disabled');
                        }
                    });
                },
                function(error) {
                    $("#login-button").removeAttr('disabled');
                }
            );
        },
        function(error) {
            $("#login-button").removeAttr('disabled');
        }

    );
});