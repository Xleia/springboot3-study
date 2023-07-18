function askVerifyCode() {
    $.get("/api/auth/verify-code", {
        email: $("#email").val()
    }, function (resp) {
        alert(resp.message)
    })
}

function login() {
    $.post("/api/auth/login", {
        username: $("#username").val(),
        password: $("#password").val()
    }, function (resp) {
        if (resp.code === 200) {
            window.location.href = "/a.html"
        } else {
            alert(resp.message)
        }
    })
}